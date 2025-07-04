public class Cheese extends Product implements Shippable {
    double weight;

    Cheese(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity, expired);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
