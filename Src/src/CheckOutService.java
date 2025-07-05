import java.util.ArrayList;
import java.util.List;

public class CheckOutService {

    public void checkout(Customer customer) {
        List<CartItem> cart = customer.getCart();

        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shippingFees = 0;
        double shippingFeesPerKG = 1;
        List<Shippable> itemsToShip = new ArrayList<>();

        for (CartItem item : cart) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            if (p instanceof Expirable expirable && expirable.isExpired()) {
                System.out.printf("Error: %s is expired.\n", p.getName());
                return;
            }

            if (qty > p.getQuantity()) {
                System.out.printf("Error: %s is out of stock.\n", p.getName());
                return;
            }

            subtotal += item.getTotalPrice();

            if (p instanceof Shippable s) {
                shippingFees += s.getWeight() * shippingFeesPerKG;
                itemsToShip.add(s);
            }
        }

        double total = subtotal + shippingFees;
        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.deductBalance(total);
        for (CartItem item : cart) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println("Checkout successful for " + customer.getName());
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Shipping: $%.2f\n", shippingFees);
        System.out.printf("Total Paid: $%.2f\n", total);
        System.out.printf("Remaining Balance: $%.2f\n", customer.getBalance());

        if (!itemsToShip.isEmpty()) {
            ShippingService.ship(itemsToShip);
        }

        customer.clearCart();
    }
}
