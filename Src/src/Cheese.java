import java.time.LocalDate;

public abstract class Cheese extends Product implements Expirable, Shippable {
    private LocalDate expiryDate;
    private double weight;

    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public boolean isExpired() { return LocalDate.now().isAfter(expiryDate); }
    public double getWeight() { return weight; }
}

