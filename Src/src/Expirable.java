import java.time.LocalDate;
public interface Expirable {
    LocalDate getExpireDate();
    boolean isExpired();

}
