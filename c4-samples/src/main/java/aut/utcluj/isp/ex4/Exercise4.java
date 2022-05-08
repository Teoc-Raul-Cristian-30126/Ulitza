package aut.utcluj.isp.ex4;

public class Exercise4 {
    public static void main(String[] args) {
        Product firstProduct = new Product("Eggs", 100d);
        Product secondProduct = new Product("Jaxana", 300d);
        Product thirdProduct = new Product("Hatz with milk", 1000d);
        User user = new User(2000d);

        user.addProductToCart(firstProduct, 6);
        user.addProductToCart(secondProduct, 1);
        user.addProductToCart(thirdProduct, 2);

        //removing existing product
        System.out.println(user.getUserCart().getCartDetails() + "\n");
        try {
            user.removeProductFromCart(thirdProduct.getProductId());
        } catch (Exception e) {
            System.out.println("N-ai pus asta an cos johnule");
        }
        System.out.println(user.getUserCart().getCartDetails() + "\n");

        try {
            user.submitCart();
        } catch (Exception e) {
            System.out.println("N-ai bani vericule ca i-ai dat pe e46 turbat, mai tii minte?\n");
        }
        System.out.println(user.getUserCart().getCartDetails() + "\n");
    }
}
