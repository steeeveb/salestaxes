package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import src.main.java.*;
import src.main.java.salestaxes.*;


public class ProductTest {
    TaxFactory tax = new TaxFactory();

    @Test
    public void aBookHasNoTaxes() {
        String price = "12.49";
        TaxableItem book = new Product("book", price);
        assertThat(book.total(), is(closeTo(new BigDecimal(price), new BigDecimal(0.001))));
    }

    @Test
    public void theOrderOfTaxesIsNotImportant() {
        TaxableItem cd = new Product("Cd", "10");
        TaxableItem cd1 = cd.setTaxes(tax.basic(), tax.duty());
        TaxableItem cd2 = cd.setTaxes(tax.duty(), tax.basic());
        assertThat(cd1.total(), is(closeTo(cd2.total(), new BigDecimal(0.001))));
    }

    @Test
    public void aBookIsEqualToABook(){
        String description = "book";
        String price = "12.49";
        TaxableItem book1 = new Product(description, price);
        TaxableItem book2 = new Product(description, price);
        assertThat(book1, is(equalTo(book2)));
    }
    @Test
    public void aChocolateBarIsNotEqualToABook(){
        TaxableItem book1 = new Product("book", "12.49");
        TaxableItem book2 = new Product("chocolate bar", "12.49");
        assertThat(book1, is(not(equalTo(book2))));
    }

    @Test
    public void aBoxOfImportedBooksIsABoxOfBooks(){
        Product product = new Product("box of imported books", "1.00");
        assertThat(product.name(), is(equalTo("box of books")));
    }
    @Test
    public void aBoxOfImportedBooksIsImported(){
        Product product = new Product("box of imported books", "1.00");
        assertThat(product.imported(), is(true));
    }
}
