package model;

public class ProductVariants {
    private String sku, name, size;
    private int category, price, stock;

    public ProductVariants() {
    }

    public ProductVariants(String sku, int category, String name, String size, int price, int stock) {
        this.sku = sku;
        this.category = category;
        this.name = name;
        this.size = size;        
        this.price = price;
        this.stock = stock;
    }

    public ProductVariants(String sku) {
        this.sku = sku;
    }        

    public ProductVariants(String sku, int price, int stock) {
        this.sku = sku;
        this.price = price;
        this.stock = stock;
    }          

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductVariants{" + "sku=" + sku + ", name=" + name + ", size=" + size + ", category=" + category + ", price=" + price + ", stock=" + stock + '}';
    }
        
}
