package aut.utcluj.isp.ex1;

/**
 * @author stefan
 */
public class Shop {
    private String name;
    private String city;

    public Shop(String name) {
        this.name = name;
    }

    public Shop(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void hatz() {
        System.out.println("HATZ");
        System.out.println("Hatz");
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void error() {
        int x = 3;

    }
}
