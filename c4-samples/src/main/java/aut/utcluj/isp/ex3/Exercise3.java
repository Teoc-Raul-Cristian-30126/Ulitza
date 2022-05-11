package aut.utcluj.isp.ex3;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        final Product product = new Product("p_1", "Dell", 100d);
        final Product secondProduct = new Product("p_2", "Toshiba", 200d);
        final StockController stockController = new StockController();
        stockController.addProductToCatalogue(product, 2);
        stockController.addProductToCatalogue(secondProduct, 3);


        List<Product> Lp;
        Lp=stockController.getProductsWithSameId("p_2");
        for(Product p:Lp){
            System.out.println(p.getId());
        }
        System.out.println();
        System.out.println("Total nr of products: "+stockController.getTotalNumberOfProducts());


        stockController.updateProductPriceByProductId("p_2",622d);

    }
}
