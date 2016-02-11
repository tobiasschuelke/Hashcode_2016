package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order extends  Base {
    ArrayList<ProductType> wishes;

    public Order(ArrayList<ProductType> wishes, int x, int y) {
        this.wishes = wishes;
        xCoordinate = x;
        yCoordinate = y;
    }
}
