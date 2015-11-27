package src.main.java.salestaxes;

import java.util.*;

public interface Display{
    public String format(Receipt receipt, List<Sellable> products);
}
