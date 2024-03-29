package aut.utcluj.isp.ex2;

import java.util.Objects;

/**
 * @author stefan
 */
public class Shop {
    private String name;
    private String city;

    public Shop(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Shop(String name) {
        this.name = name;
        this.city = "";
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.getName()) && Objects.equals(city, shop.getCity());
    }

    @Override
    public String toString() {
        return "Shop: " + name + " City: " + city;
    }
}
