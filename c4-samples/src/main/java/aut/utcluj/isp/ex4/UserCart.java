package aut.utcluj.isp.ex4;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author stefan
 */
public class UserCart implements ICartDetails{
    private List<Product> cardProducts;
    private double totalPrice;

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
    public void removeProductFromCart(final String productId) {
        boolean removed = false;

        for (Product p : cardProducts) {
            if(p.getProductId().equals(productId) && !removed) {
                cardProducts.remove(p);
                removed = true;
            }
        }

        if(!removed) {
            try {
                throw new ProductNotFoundException();
            } catch (ProductNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        for (Product p : cardProducts) {
            cardProducts.remove(p);
        }
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
            message.append(" ,Items: ").append(counter);
        }

        return message.toString();
    }
}
