package models;


import java.util.HashMap;
import java.util.Map;

public class Warehouse extends Base {
    Map<ProductType, Integer> availableProducts = new HashMap<>();
    int id;

    public void addProduct(int productId) {

    }

    public boolean removeProduct(ProductType productType) {
        if (availableProducts.containsKey(productType) && availableProducts.get(productType) > 0) {
            int count = availableProducts.get(productType);
            if (count > 1) {
                availableProducts.put(productType, --count);
            } else {
                availableProducts.remove(productType);
            }
            return true;
        }
        return false;
    }

    public Warehouse(Map<ProductType, Integer> availableProducts, int x, int y, int id) {
        this.availableProducts = availableProducts;
        xCoordinate = x;
        yCoordinate = y;
        this.id = id;
    }

    public String toString(){
        return ""+id;
    }
}
