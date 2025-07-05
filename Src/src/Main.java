import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 100.0, 10, LocalDate.now().plusDays(3), 0.2);
        Product biscuits = new Biscuits("Biscuits", 150.0, 5, LocalDate.now().plusDays(5), 0.7);

        Customer customer = new Customer("Arsany", 500.0);
        customer.addToCart(cheese, 2);
        customer.addToCart(biscuits, 1);

        CheckOutService checkout = new CheckOutService();
        checkout.checkout(customer);
    }
}
