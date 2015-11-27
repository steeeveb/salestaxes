package src.main.java.salestaxes;
import java.math.BigDecimal;

public interface RoundingPolicy {
    public BigDecimal round(BigDecimal value);
}
