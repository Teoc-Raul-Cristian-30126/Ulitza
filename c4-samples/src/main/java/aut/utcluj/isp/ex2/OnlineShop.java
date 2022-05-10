package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class OnlineShop extends Shop{
    private String webAddress;

    public OnlineShop(String name, String city, String webAddress) {
        super(name, city);
        this.webAddress = webAddress;
    }

    @Override
    public String toString() {
        return super.toString() + " Web address: " + this.webAddress;

    }

    public String getWebAddress() {
        return webAddress;
    }
}
