import java.time.LocalDate;

public class Biscuits extends Product implements  Shippable , Expirable {
    private LocalDate expiryDate;
    private double weight;

    public Biscuits(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate=expiryDate;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
