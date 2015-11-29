package src.main.java.salestaxes;

import java.math.*;

public interface Display{
    public String print(BigDecimal salesTaxes, BigDecimal total);
    public void addLine(TaxableItem product, BigDecimal total);
}
