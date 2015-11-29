package src.main.java.salestaxes;

import java.util.*;

public interface TaxRepository {
    public List<TaxRule> taxesFor(TaxableItem product);
}
