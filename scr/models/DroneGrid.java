package models;

import models.Drone;
import models.Order;
import models.ProductType;
import models.Warehouse;

import java.util.ArrayList;

public class DroneGrid {
    private int worldX, worldY;
    private int droneAmount;
    private int deadline;
    private ArrayList<Drone> drones = new ArrayList<>();
    private ArrayList<ProductType> productTypes;
    public ArrayList<Warehouse> warehouses;
    public ArrayList<Order> orders;


    public DroneGrid(int worldX, int worldY, int droneAmount, int droneWeightMax, ArrayList<ProductType> productTypes, ArrayList<Warehouse> warehouses, ArrayList<Order> orders) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.productTypes = productTypes;
        this.warehouses = warehouses;
        this.orders = orders;

        for (int i = 0; i < droneAmount; i++) {
            drones.add(new Drone(droneWeightMax, this));
        }
    }

    public void simulate(){
        for(int i = 0; i < drones.size(); i++){
            drones.get(i).load(orders.remove(0));
        }

        for(int t = 0; t<deadline;t++){
            for (Drone drone : drones) {
                drone.fly();
            }
        }
    }

    public void returnOrder(Order order) {
        if (!order.wishes.isEmpty()) {
            orders.add(order);
        }
    }
}
