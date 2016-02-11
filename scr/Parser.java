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
        }
    }
}
