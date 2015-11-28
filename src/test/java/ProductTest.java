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
        Sellable book = new Product("book", price);
        assertThat(book.total(), is(closeTo(new BigDecimal(price), new BigDecimal(0.001))));
    }

    @Test
    public void aCdHasBasicTaxes() {
        TaxRule basicTax = tax.basic();
        Sellable cd = new Product("Cd", "14.99", basicTax);
        assertThat(cd.total(), is(closeTo(new BigDecimal(16.49), new BigDecimal(0.001))));
    }

    @Test
    public void anImportedBookHasDutyTaxes() {
        TaxRule dutyTax = tax.duty();
        Sellable cd = new Product("Cd", "10", dutyTax);
        assertThat(cd.total(), is(closeTo(new BigDecimal(10.50), new BigDecimal(0.001))));
    }

    @Test
    public void anImportedCdHasBasicTaxesAndDutyTaxes() {
        TaxRule basicTax = tax.basic();
        TaxRule dutyTax = tax.duty();
        Sellable cd = new Product("Cd", "10", basicTax, dutyTax);
        assertThat(cd.total(), is(closeTo(new BigDecimal(11.50), new BigDecimal(0.001))));
    }

    @Test
    public void aBookIsEqualToABook(){
        String description = "book";
        String price = "12.49";
        Sellable book1 = new Product(description, price);
        Sellable book2 = new Product(description, price);
        assertThat(book1, is(equalTo(book2)));
    }
    @Test
    public void aChocolateBarIsNotEqualToABook(){
        Sellable book1 = new Product("book", "12.49");
        Sellable book2 = new Product("chocolate bar", "12.49");
        assertThat(book1, is(not(equalTo(book2))));
    }

    @Test
    public void aBoxOfImportedBooksIsABoxOfBooks(){
        Product product = new Product("box of imported books", "1.00");
        assertThat(product.description(), is(equalTo("box of books")));
    }
    @Test
    public void aBoxOfImportedBooksIsImported(){
        Product product = new Product("box of imported books", "1.00");
        assertThat(product.imported(), is(true));
    }
}
