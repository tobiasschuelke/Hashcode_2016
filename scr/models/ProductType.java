package models;


public class ProductType extends Base {
    private int id;
    private int weight;

    public ProductType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }
}
