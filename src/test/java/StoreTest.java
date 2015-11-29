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
        String line = String.format("1 %s at %.2f", description, price);
        TaxableItem product = store.get(line);
        assertThat(product, is(equalTo(new Product(description, price))));
    }
    @Test
    public void getAnUnknownProduct() throws ProductNotFound {
        String description = "kindle";
        String line = String.format("1 %s at %.2f", description, price);
        TaxableItem product = store.get(line);
        assertThat(product, is(equalTo(new Product(description, price))));
    }
    @Test(expected=ProductNotFound.class)
    public void sendABadDescription() throws ProductNotFound {
        String description = "kindle";
        String line = String.format("1 %s %.2f", description, price);
        TaxableItem product = store.get(line);
        assertThat(product, is(equalTo(new Product(description, price))));
    }

    @Test
    public void aBoxOfImportedBooksIsABoxOfBooks() throws ProductNotFound{
        String line = "1 box of imported books at 1.00";
        TaxableItem product = store.get(line);
        TaxableItem expected = new Product("box of books", "1.00", true);
        assertThat(product, is(equalTo(expected)));
    }
}
