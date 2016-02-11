package models;


public class ProductType  {
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

    public String toString(){
        return ""+id;
    }
}
