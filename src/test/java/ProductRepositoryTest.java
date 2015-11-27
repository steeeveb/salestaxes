package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.BigDecimalCloseTo.*;


import java.util.*;
import java.math.*;

import src.main.java.*;
import src.main.java.salestaxes.*;


public class ProductRepositoryTest {
    Tax tax = new Tax();
    @Test
    public void getAKnownProduct() throws ProductNotFound {
        ProductRepository repository = new ProductRepository();
        String description = "book";
        BigDecimal price = new BigDecimal("1.00");
        Sellable product = repository.get(String.format("%s at %.2f", description, price));
        assertThat(product, is(equalTo(new Product(description, price, tax.exemption()))));
    }
    public void getAnUnknownProduct() throws ProductNotFound {
        ProductRepository repository = new ProductRepository();
        String description = "kindle";
        BigDecimal price = new BigDecimal(1.00);
        Sellable product = repository.get(String.format("%s at %.2f", description, price));
        assertThat(product, is(equalTo(new Product(description, price, tax.basic()))));
    }
}
