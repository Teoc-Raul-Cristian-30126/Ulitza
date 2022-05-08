package aut.utcluj.isp.ex2;

public class Exercise2 {
    public static void main(String[] args) {
        //vrajeala
        OnlineShop onlineShop1 = new OnlineShop("Ieftinel", "Buzau", "www.celMaiBunMagazinBuzau.ro");
        OnlineShop onlineShop2 = new OnlineShop("Ieftinel", "Buzau", "www.celMaiBunMagazinBuzau.ro");

        System.out.println(onlineShop1.toString());
        System.out.println("onlineShop1 equals onlineShop2: " + onlineShop1.equals(onlineShop2));
        System.out.println(onlineShop1.getWebAddress());
        System.out.println(onlineShop2.getCity());
        System.out.println(onlineShop2.getName());
    }
}
