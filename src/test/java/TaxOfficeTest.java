package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.BigDecimalCloseTo.*;


import java.util.*;
import java.math.*;

import src.main.java.*;
import src.main.java.salestaxes.*;


public class TaxOfficeTest {
    TaxOffice taxOffice = new TaxOffice();
    TaxFactory tax = new TaxFactory();

    @Test
    public void getTaxesForABook() {
        TaxableItem product = new Product("book", "1.00");
        assertThat(taxOffice.taxesFor(product), is(empty()));
    }
    @Test
    public void getTaxesForACD() {
        TaxableItem product = new Product("cd", "1.00");
        assertThat(taxOffice.taxesFor(product),
                   is(equalTo(taxes(tax.basic()))));
    }
    @Test
    public void getTaxesForAnImportedBook() {
        TaxableItem product = new Product("book", "1.00", true);
        assertThat(taxOffice.taxesFor(product),
                   is(equalTo(taxes(tax.duty()))));
    }
    @Test
    public void getTaxesForAnImportedCD() {
        TaxableItem product = new Product("cd", "1.00", true);
        assertThat(taxOffice.taxesFor(product),
                   is(equalTo(taxes(tax.basic(), tax.duty()))));
    }
    private Set<TaxRule> taxes(TaxRule... rules){
        return new HashSet<>(Arrays.asList(rules));
    }
}
