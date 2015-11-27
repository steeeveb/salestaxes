package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import src.main.java.salestaxes.*;


public class RoundToTest {
    @Test
    public void a0_235becomes0_25() {
        RoundingPolicy policy = new RoundTo(0.05);
        assertThat(policy.round(new BigDecimal(0.235)),
                   is(closeTo(new BigDecimal(0.25), new BigDecimal(0.001))));
    }
}
