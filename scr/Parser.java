import java.util.Arrays;

/**
 * Created by jschaeffer on 11.02.16.
 */
public class Parser {

    public static void parse(String input){
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int rows = new Integer(firstLine[0]);
        int cols = new Integer(firstLine[1]);
        int droneAmount = new Integer(firstLine[2]);
        int deadline = new Integer(firstLine[3]);
        int droneWeightMax = new Integer(firstLine[4]);

        int productAmount = new Integer(lines[1]);
        int[] productWeights = new int[productAmount];
        for(int i = 0; i<productAmount; i++){
            productWeights[i] = new Integer(lines[2].split(" ")[i]);
        }
        int currentLine = 4;
        int warehouseAmount = new Integer(lines[3]);
        for(int i = currentLine; i< currentLine+(warehouseAmount*2); i++){

            int row = new Integer(lines[i].split(" ")[0]);
            int col = new Integer(lines[i].split(" ")[1]);
            i++;
            int[] warehouseProducts = new int[productAmount];
            String[] warehouseProductsStrings = lines[i].split(" ");
            for(int j = 0; j<warehouseProducts.length;j++){
                warehouseProducts[j] = new Integer(warehouseProductsStrings[j]);
            }
            //System.out.println("warehouse at "+ row + "|" + col + " has products: " + Arrays.toString(warehouseProducts));
        }
        currentLine += warehouseAmount*2;
        int orderAmount = new Integer(lines[currentLine]);
        currentLine ++;
        for(int i = currentLine;i<currentLine+(orderAmount*3);i++){

            int row = new Integer(lines[i].split(" ")[0]);
            int col = new Integer(lines[i].split(" ")[1]);
            i++;
            int productsForOrderAmount = new Integer(lines[i]);
            i++;
            int[] productTypesForOrder = new int[productsForOrderAmount];
            String[] productTypesStrings = lines[i].split(" ");
            for(int j = 0; j<productTypesForOrder.length;j++){
                productTypesForOrder[j] = new Integer(productTypesStrings[j]);
            }
            //System.out.println("Customer: "+ (i-2) + " at " + row + "|" + col + " orders " + productsForOrderAmount + " products: " + Arrays.toString(productTypesForOrder));
        }
    }
}
