import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("Shipping items:");
        for (Shippable item : items) {
            System.out.printf("- %s: %.2f kg\n", item.getName(), item.getWeight());
        }
    }
}
