package models;


public class ProductType extends Base {
    private int id;
    private int weight;

    public ProductType(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }
}
