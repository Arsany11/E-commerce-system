import java.time.LocalDate;

public class Cheese extends Product implements Shippable, Expirable {
    private LocalDate expiryDate;
    private double weight;


    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public double getWeight() { return weight; }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}

