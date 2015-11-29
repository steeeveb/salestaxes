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
    ProductBuilder aProduct = new ProductBuilder();

    @Test
    public void aBookHasNoTaxes() {
        BigDecimal price = new BigDecimal("12.49");
        TaxableItem book = aProduct.called("book").priced(price).build();
        assertThat(book.total(taxes()), is(closeTo(price, new BigDecimal(0.001))));
    }

    @Test
    public void theOrderOfTaxesIsNotImportant() {
        TaxableItem cd = aProduct.called("cd").priced("10").build();
        assertThat(cd.total(taxes(tax.basic(), tax.duty())),
                   is(closeTo(cd.total(taxes(tax.duty(), tax.basic())), new BigDecimal(0.001))));
    }

    @Test
    public void aBookIsEqualToABook(){
        ProductBuilder copy = aProduct.called("book").priced("10");
        TaxableItem book1 = copy.build();
        TaxableItem book2 = copy.build();
        assertThat(book1, is(equalTo(book2)));
    }
    @Test
    public void aChocolateBarIsNotEqualToABook(){
        TaxableItem book1 = aProduct.called("book").priced("12.49").build();
        TaxableItem book2 = aProduct.called("chocolate bar").priced("12.49").build();
        assertThat(book1, is(not(equalTo(book2))));
    }

    private List<TaxRule> taxes(TaxRule... rules){
        return Arrays.asList(rules);
    }
}
