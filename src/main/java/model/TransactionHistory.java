package model;

public class TransactionHistory {
    private int id, customerId, totalItem;
    private String sku, transactionTime;

    public TransactionHistory() {
    }

    public TransactionHistory(int id, int customerId, String sku, int totalItem, String transactionTime) {
        this.id = id;
        this.customerId = customerId;
        this.sku = sku;
        this.totalItem = totalItem;       
        this.transactionTime = transactionTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" + "id=" + id + ", customerId=" + customerId + ", totalItem=" + totalItem + ", sku=" + sku + ", transactionTime=" + transactionTime + '}';
    }
        
}
