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
    ArrayList<String> droneCommands = new ArrayList<>();


    public DroneGrid(int worldX, int worldY, int droneAmount, int droneWeightMax, ArrayList<ProductType> productTypes, ArrayList<Warehouse> warehouses, ArrayList<Order> orders, int deadline) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.productTypes = productTypes;
        this.warehouses = warehouses;
        this.orders = orders;
        this.deadline = deadline;
        for (int i = 0; i < droneAmount; i++) {
            drones.add(new Drone(droneWeightMax, this, i));
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

        System.out.println(droneCommands.size());
        for(String s : droneCommands){
            System.out.println(s);
        }
    }

    public void returnOrder(Order order) {
        if (!order.wishes.isEmpty()) {
            orders.add(order);
        }
    }


}
