package model;

public class ProductCategory {
    private int id;
    private String name;

    public ProductCategory() {
    }

    public ProductCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductCategory(int id) {
        this.id = id;
    }

    public ProductCategory(String name) {
        this.name = name;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCategory{" + "id=" + id + ", name=" + name + '}';
    }
        
}
