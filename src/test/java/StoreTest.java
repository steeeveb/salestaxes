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
    ProductBuilder aProduct = new ProductBuilder();

    @Test
    public void getAKnownProduct() throws ProductNotFound {
        TaxableItem product = store.get("1 book at 1.00");
        TaxableItem expected = aProduct.called("book").priced("1.00").build();
        assertThat(product, is(equalTo(expected)));
    }
    @Test
    public void getAnUnknownProduct() throws ProductNotFound {
        TaxableItem product = store.get("1 kindle at 1.00");
        TaxableItem expected = aProduct.called("kindle").priced("1.00").build();
        assertThat(product, is(equalTo(expected)));
    }
    @Test(expected=ProductNotFound.class)
    public void sendABadDescription() throws ProductNotFound {
        String line = "1 kindle 1.00";
        TaxableItem product = store.get(line);
    }

    @Test
    public void aBoxOfImportedBooksIsABoxOfBooks() throws ProductNotFound{
        String line = "1 box of imported books at 1.00";
        TaxableItem product = store.get(line);
        TaxableItem expected = aProduct.called("box of books")
                                       .priced("1.00").imported().build();
        assertThat(product, is(equalTo(expected)));
    }
}
