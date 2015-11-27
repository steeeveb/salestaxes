package src.main.java.salestaxes;

import java.math.BigDecimal;

public interface TaxRule {
    public BigDecimal compute(BigDecimal price);
}
