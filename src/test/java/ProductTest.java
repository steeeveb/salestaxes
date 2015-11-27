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
    Tax tax = new Tax();

    @Test
    public void aBookHasNoTaxes() {
        BigDecimal price = new BigDecimal(12.49);
        TaxRule taxExemption = tax.exemption();
        Sellable book = new Product("book", price, taxExemption);
        assertThat(book.total(), is(closeTo(price, new BigDecimal(0.001))));
    }

    @Test
    public void aCdHasBasicTaxes() {
        BigDecimal price = new BigDecimal(14.99);
        TaxRule basicTax = tax.basic();
        Sellable cd = new Product("Cd", price, basicTax);
        assertThat(cd.total(), is(closeTo(new BigDecimal(16.49), new BigDecimal(0.001))));
    }

    @Test
    public void anImportedBookHasDutyTaxes() {
        BigDecimal price = new BigDecimal(10);
        TaxRule dutyTax = tax.duty();
        Sellable cd = new Product("Cd", price, dutyTax);
        assertThat(cd.total(), is(closeTo(new BigDecimal(10.50), new BigDecimal(0.001))));
    }

    @Test
    public void anImportedCdHasBasicTaxesAndDutyTaxes() {
        BigDecimal price = new BigDecimal(10);
        TaxRule basicTax = tax.basic();
        TaxRule dutyTax = tax.duty();
        Sellable cd = new Product("Cd", price, basicTax, dutyTax);
        assertThat(cd.total(), is(closeTo(new BigDecimal(11.50), new BigDecimal(0.001))));
    }

    @Test
    public void aBookIsEqualToABook(){
        BigDecimal price = new BigDecimal(12.49);
        String description = "book";
        Sellable book1 = new Product(description, price, tax.exemption());
        Sellable book2 = new Product(description, price, tax.exemption());
        assertThat(book1, is(equalTo(book2)));
    }
    @Test
    public void aChocolateBarIsNotEqualToABook(){
        BigDecimal price = new BigDecimal(12.49);
        Sellable book1 = new Product("book", price, tax.exemption());
        Sellable book2 = new Product("chocolate bar", price, tax.exemption());
        assertThat(book1, is(not(equalTo(book2))));
    }

}
