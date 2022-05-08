package aut.utcluj.isp.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author stefan
 */
public class UserCart implements ICartDetails{
    private List<Product> cardProducts;
    private double totalPrice;

    public UserCart() {
        cardProducts = new ArrayList<>();
        totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getCardProducts() {
        return cardProducts;
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            cardProducts.add(product);
            totalPrice += product.getPrice();
        }
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProduct(final String productId) throws Exception{
        boolean removed = false;

        for (Product p : cardProducts) {
            if(p.getProductId().equals(productId)) {
                cardProducts.remove(p);
                removed = true;
                totalPrice -= p.getPrice();
                break;
            }
        }

        if(!removed) {
            throw new ProductNotFoundException();
        }
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        cardProducts.removeAll(cardProducts);
        totalPrice = 0;

    }

    /**
     * Return cart details
     * Cart details should have the following format:
     * Product id: , Items:
     * Product id: , Items:
     * Total price:
     *
     * @return cart details
     */
    @Override
    public String getCartDetails() {
        StringBuilder message = new StringBuilder();
        List<Product> uniqueProducts = cardProducts.stream().distinct().collect(Collectors.toList());
        for (Product p : uniqueProducts) {
            int counter = 0;
            message.append("Product id: ").append(p.getProductId());
            for (Product product : cardProducts) {
                if(product.getProductId().equals(p.getProductId())) {
                    counter++;
                }
            }
            message.append(", Items: ").append(counter).append("\n");
        }
        message.append("Total price: ").append(totalPrice);

        return message.toString();
    }
}
