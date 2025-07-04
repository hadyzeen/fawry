import java.util.*;
public class ECommerceSystem {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        double subtotal = 0;
        List<Shippable> shippables = new ArrayList<>();

        for (CartItem item : cart.items) {
            Product p = item.product;
            if (p.isExpired()) {
                System.out.println("Error: " + p.getName() + " is expired");
                return;
            }
            if (item.quantity > p.getQuantity()) {
                System.out.println("Error: " + p.getName() + " is out of stock");
                return;
            }
            subtotal += item.quantity * p.getPrice();
            if (p instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    shippables.add((Shippable) p);
                }
            }
        }

        double shipping;
        if (shippables.isEmpty()) {
            shipping = 0;
        } else {
            shipping = 30;
        }
        double total = subtotal + shipping;

        if (customer.balance < total) {
            System.out.println("Error: Insufficient balance");
            return;
        }


        for (CartItem item : cart.items) {
            item.product.reduceQuantity(item.quantity);
        }
        customer.balance -= total;


        if (!shippables.isEmpty()) {
            ShippingService.ship(shippables);
        }


        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.items) {
            System.out.printf("%dx %s %.0f\n", item.quantity, item.product.getName(), item.product.getPrice() * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal: %.0f\n", subtotal);
        System.out.printf("Shipping: %.0f\n", shipping);
        System.out.printf("Amount: %.0f\n", total);
        System.out.printf("Remaining balance: %.0f\n", customer.balance);
    }

        public static void main(String[] args) {

        Cheese cheese = new Cheese("Cheese", 100, 10, false, 0.2);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, false, 0.7);
        TV tv = new TV("TV", 5000, 3, 10);
        MobileScratchCard scratchCard = new MobileScratchCard("Scratch Card", 50, 100);


        Customer customer = new Customer("Ali", 1000);


        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);


        checkout(customer, cart);
    }
}
