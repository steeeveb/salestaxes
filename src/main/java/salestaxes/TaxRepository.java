package src.main.java.salestaxes;

import java.util.*;

public interface TaxRepository {
    public Set<TaxRule> taxesFor(Sellable product);
}
