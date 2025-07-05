import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private double balance;
    private List<CartItem> cart;
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new ArrayList<>();
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }
    public List<CartItem> getCart() { return cart; }

    public void addToCart(Product product, int quantity){
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Requested quantity exceeds available stock");
        }
        cart.add(new CartItem(product, quantity));
    }
    public void deductBalance(double amount) {
        this.balance -= amount;
    }
    public void clearCart() {
        cart.clear();
    }
}
