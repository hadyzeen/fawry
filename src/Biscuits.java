public class Biscuits extends Product implements Shippable {
    double weight;

    Biscuits(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity, expired);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
