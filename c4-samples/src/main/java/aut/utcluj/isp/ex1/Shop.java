package aut.utcluj.isp.ex1;

/**
 * @author stefan
 */
public class Shop {
    private String name;
    private String city;

    public Shop(String name, String city) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Shop(String name) {
        this.city = "";
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void hatz() {
        System.out.println("HATZ");
        for(int i = 0; i<10; i++)
        {
            System.out.println(i);
        }
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
