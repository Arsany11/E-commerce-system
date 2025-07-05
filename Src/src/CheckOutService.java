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
        double totalShippingWeightKg = 0;
        double shippingRatePerKg = 30.0;
        List<String> shippingLines = new ArrayList<>();
        List<String> receiptLines = new ArrayList<>();

        for (CartItem item : cart) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

//            if ( p.) {
//                System.out.printf("Error: %s is expired.\n", p.getName());
//                return;
//            }

            if (qty > p.getQuantity()) {
                System.out.printf("Error: %s is out of stock.\n", p.getName());
                return;
            }

            double lineTotal = p.getPrice() * qty;
            subtotal += lineTotal;

            receiptLines.add(qty + "x " + p.getName() + " " + (int) lineTotal);

            if (p instanceof Shippable s) {
                double totalWeightKg = s.getWeight() * qty;
                int weightGrams = (int) (totalWeightKg * 1000);
                shippingLines.add(qty + "x " + s.getName() + " " + weightGrams + "g");
                totalShippingWeightKg += totalWeightKg;
            }
        }

        double shippingCost = totalShippingWeightKg * shippingRatePerKg;
        double total = subtotal + shippingCost;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.deductBalance(total);
        for (CartItem item : cart) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        if (!shippingLines.isEmpty()) {
            System.out.println("** Shipment notice **");
            shippingLines.forEach(System.out::println);
            System.out.printf("Total package weight %.1fkg\n\n", totalShippingWeightKg);
        }

        System.out.println("** Checkout receipt **");
        receiptLines.forEach(System.out::println);
        System.out.println("----------------------");
        System.out.printf("Subtotal %d\n", (int) subtotal);
        System.out.printf("Shipping %d\n", (int) shippingCost);
        System.out.printf("Amount %d\n", (int) total);

        customer.clearCart();
    }
}
