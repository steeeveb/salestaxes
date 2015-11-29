package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import src.main.java.salestaxes.*;
import src.main.java.*;


public class ReceiptTest {
    ProductBuilder aProduct = new ProductBuilder();

    @Test
    public void anEmptyReceiptHasNoTaxes() {
        Receipt receipt = new Receipt();
        assertThat(receipt.salesTaxes(),
                   is(closeTo(new BigDecimal(0.00), new BigDecimal(0.001))));
    }
    @Test
    public void anEmptyReceiptHasNoTotal() {
        Receipt receipt = new Receipt();
        assertThat(receipt.total(),
                   is(closeTo(new BigDecimal(0.00), new BigDecimal(0.001))));
    }
    @Test
    public void aReceiptWith1LineHasTotal() {
        Receipt receipt = new Receipt();
        TaxableItem product = aProduct.called("ipad").priced("10.00").build();
        receipt.add(product, taxes());
        assertThat(receipt.total(),
                   is(closeTo(new BigDecimal("10.00"), new BigDecimal(0.001))));
    }
    private List<TaxRule> taxes(TaxRule... taxes){
        return Arrays.asList(taxes);
    }
}
