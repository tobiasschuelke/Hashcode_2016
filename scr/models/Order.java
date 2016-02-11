package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order extends  Base {
    ArrayList<ProductType> wishes;
    int id;

    public Order(ArrayList<ProductType> wishes, int x, int y, int id) {
        this.wishes = wishes;
        xCoordinate = x;
        yCoordinate = y;
        this.id = id;
    }

    public String toString(){
        return ""+id;
    }
}
