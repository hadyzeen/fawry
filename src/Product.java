public abstract class Product {
    String name;
    double price;
    int quantity;
    boolean expired;

    Product(String name, double price, int quantity, boolean expired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        quantity -= amount;
    }

    public boolean isExpired() {
        return expired;
    }
}