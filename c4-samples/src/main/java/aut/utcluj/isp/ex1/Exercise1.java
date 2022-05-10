package aut.utcluj.isp.ex1;

public class Exercise1 {
    public static void main(String[] args) {
        //vrajeala
        Shop shop1 = new Shop("La Dinu", "Braila");
        Shop shop2 = new Shop("La Dinu", "Braila");

        System.out.println(shop1.toString());
        System.out.println("Shop1 equals shop2: " + shop1.equals(shop2));
        System.out.println(shop2.getCity());
        System.out.println(shop2.getName());
    }
}
