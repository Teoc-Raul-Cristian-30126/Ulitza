package aut.utcluj.isp.ex3;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import java.util.*;
import javax.swing.table.AbstractTableModel;




/**
 * @author stefan
 */
public class StockController extends AbstractTableModel{


    private Map<String, List<Product>> Catalogue = new HashMap<>();
    private String[] columns = new String[] {"Id","Name", "Price", "Quantity"};
    /**
     * Add product to catalogue
     *
     * @param product  - product information
     * @param quantity - number of times the product should be added
     * @apiNote: if products with the same products id already exists, assume that @param product has the same data
     */
    public void addProductToCatalogue(final Product product, final int quantity) {
        List<Product> listaProdus= new ArrayList();
        for(int i=0;i<quantity;i++){
            listaProdus.add(product);
        }
        Catalogue.put(product.getId(),listaProdus);

    }

    /**
     * Return catalogue information
     *
     * @return dictionary where the key is the product id and the value is an array of products with the same id
     */
    public Map<String, List<Product>> getCatalogue() {
        return this.Catalogue;
    }

    /**
     * Return all the products with particular id
     *
     * @param productId - unique product id
     * @return - list of existing products with same id or null if not found
     */
    public List<Product> getProductsWithSameId(final String productId) {
        for (Map.Entry<String,List<Product>> entry :Catalogue.entrySet()){
            if(entry.getKey().equals(productId)){
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Get total number of products from catalogue
     *
     * @return
     */
    public int getTotalNumberOfProducts() {
        int sum=0;
        for (Map.Entry<String,List<Product>> entry :Catalogue.entrySet()){
            sum+=(entry.getValue().size());
        }

        return sum;
    }

    /**
     * Remove all products with same product id
     *
     * @param productId - unique product id
     * @return true if at least one product was deleted or false instead
     */
    public boolean removeAllProductsWitProductId(final String productId) {
        for (Map.Entry<String,List<Product>> entry :Catalogue.entrySet()){
            if(entry.getKey().equals(productId)){
                Catalogue.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }

    /**
     * Update the price for all the products with same product id
     *
     * @param productId - unique product id
     * @param price     - new price to be added
     * @return true if at least one product was updated or false instead
     */
    public boolean updateProductPriceByProductId(final String productId, final Double price) {
        for (Map.Entry<String,List<Product>> entry :Catalogue.entrySet()){
            if(entry.getKey().equals(productId)){
                for(Product p:entry.getValue()){
                    p.setPrice(price);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int getRowCount() {
        return Catalogue.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object myKey = Catalogue.keySet().toArray()[rowIndex];
        List<Product> valueForMyKey = Catalogue.get(myKey.toString());
        
        switch (columnIndex) {
            case 0:return myKey;
            case 1:return valueForMyKey.get(0).getName();
            case 2:return valueForMyKey.get(0).getPrice();
            case 3:return valueForMyKey.size();
        }
        
        return "N/A";
    }
    
    public void requestData() throws IOException {
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
}
