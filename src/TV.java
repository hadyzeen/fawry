public class TV extends Product implements Shippable {
    double weight;

    TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity, false);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}