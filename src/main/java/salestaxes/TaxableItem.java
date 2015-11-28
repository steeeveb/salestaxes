package src.main.java.salestaxes;
import java.math.BigDecimal;
import java.util.Set;

public interface TaxableItem{
    public BigDecimal total();
    public BigDecimal salesTaxes();
    public String name();
    public TaxableItem setTaxes(Set<TaxRule> rules);
    public TaxableItem setTaxes(TaxRule... rules);
    public boolean imported();
}
