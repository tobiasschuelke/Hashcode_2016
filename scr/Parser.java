import models.DroneGrid;
import models.Order;
import models.ProductType;
import models.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jschaeffer on 11.02.16.
 */
public class Parser {

    public static DroneGrid parse(String input){
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int rows = new Integer(firstLine[0]);
        int cols = new Integer(firstLine[1]);
        int droneAmount = new Integer(firstLine[2]);
        int deadline = new Integer(firstLine[3]);
        int droneWeightMax = new Integer(firstLine[4]);

        int productAmount = new Integer(lines[1]);
        ArrayList<ProductType> productTypes = new ArrayList<>(productAmount);
        for(int i = 0; i<productAmount; i++){
            int weight = new Integer(lines[2].split(" ")[i]);
            productTypes.add(new ProductType(i, weight));
        }
        int currentLine = 4;
        int warehouseAmount = new Integer(lines[3]);
        ArrayList<Warehouse> warehouses = new ArrayList<>(warehouseAmount);
        for(int i = currentLine; i< currentLine+(warehouseAmount*2); i++){
            Map<ProductType, Integer> availableProducts = new HashMap<ProductType, Integer>();
            int row = new Integer(lines[i].split(" ")[0]);
            int col = new Integer(lines[i].split(" ")[1]);
            i++;
            int[] warehouseProducts = new int[productAmount];
            String[] warehouseProductsStrings = lines[i].split(" ");
            for(int j = 0; j<warehouseProducts.length;j++){
                warehouseProducts[j] = new Integer(warehouseProductsStrings[j]);
                availableProducts.put(productTypes.get(j), new Integer(warehouseProductsStrings[j]));
            }
            warehouses.add(new Warehouse(availableProducts,row, col));
            //System.out.println("warehouse at "+ row + "|" + col + " has products: " + Arrays.toString(warehouseProducts));
        }
        currentLine += warehouseAmount*2;
        int orderAmount = new Integer(lines[currentLine]);
        currentLine ++;
        ArrayList<Order> orders = new ArrayList<>(orderAmount);
        for(int i = currentLine;i<currentLine+(orderAmount*3);i++){
            ArrayList<ProductType> wishes = new ArrayList<>();
            int row = new Integer(lines[i].split(" ")[0]);
            int col = new Integer(lines[i].split(" ")[1]);
            i++;
            int productsForOrderAmount = new Integer(lines[i]);
            i++;
            int[] productTypesForOrder = new int[productsForOrderAmount];
            String[] productTypesStrings = lines[i].split(" ");
            for(int j = 0; j<productTypesForOrder.length;j++){
                productTypesForOrder[j] = new Integer(productTypesStrings[j]);
                wishes.add(productTypes.get(j));
            }
            orders.add(new Order(wishes, row, col));
            //System.out.println("Customer: "+ (i-2) + " at " + row + "|" + col + " orders " + productsForOrderAmount + " products: " + Arrays.toString(productTypesForOrder));
        }

        return new DroneGrid(rows, cols, droneAmount, droneWeightMax, productTypes, warehouses, orders);
    }
}
