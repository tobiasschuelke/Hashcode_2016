package models;


import java.util.ArrayList;

public class Drone extends Base {
    private int maxLoad;
    boolean busy = false;
    Order order;
    private int leftDistance;
    ArrayList<ProductType> load = new ArrayList<>();
    DroneGrid grid;

    public Drone (int maxLoad, DroneGrid grid) {
        this.maxLoad = maxLoad;
        this.grid = grid;
    }

    public void load(Order order) {
        if (busy) {
            System.err.println("Busy drone wants to load order!");
            return;
        }
        this.order = order;
        this.busy = true;

        Warehouse house = null;
        for (Warehouse warehouse : grid.warehouses) {
            for (ProductType productType : order.wishes) {
                if (warehouse.removeProduct(productType)) {
                    load.add(productType);
                    house = warehouse;
                    order.wishes.remove(productType);

                    break;
                }
            }

            if (house != null) {
                break;
            }
        }

        if (house == null) {
            System.err.println("No warehouse found!");
            return;
        }

        leftDistance = calcDist(house);
        leftDistance++; // loading time

        setCoordinates(house); // destination coordinates
    }

    public void fly() {
        if (!busy) {
            if (grid.orders.size() > 0) {
                load(grid.orders.remove(0)); // get next job
            }
            return;
        }

        leftDistance--;

        if (leftDistance == 0) {
            if (order != null && !load.isEmpty()) {
                deliver();
            } else {
                this.busy = false;
                grid.returnOrder(order);
                order = null;
                load.remove(0);     // TODO
            }
        }
    }

    public void deliver() {
        leftDistance = calcDist(order);
        setCoordinates(order);
    }
}
