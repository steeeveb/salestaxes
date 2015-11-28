package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.BigDecimalCloseTo.*;


import java.util.*;
import java.math.*;

import src.main.java.*;
import src.main.java.salestaxes.*;


public class StoreTest {
    Store store = new Store();
    BigDecimal price = new BigDecimal("1.00");

    @Test
    public void getAKnownProduct() throws ProductNotFound {
        String description = "book";
        String line = String.format("%s at %.2f", description, price);
        Sellable product = store.get(line);
        assertThat(product, is(equalTo(new Product(description, price))));
    }
    @Test
    public void getAnUnknownProduct() throws ProductNotFound {
        String description = "kindle";
        String line = String.format("%s at %.2f", description, price);
        Sellable product = store.get(line);
        assertThat(product, is(equalTo(new Product(description, price))));
    }
    @Test(expected=ProductNotFound.class)
    public void sendABadDescription() throws ProductNotFound {
        String description = "kindle";
        String line = String.format("%s %.2f", description, price);
        Sellable product = store.get(line);
        assertThat(product, is(equalTo(new Product(description, price))));
    }
}
