package com.getInTheCloud.junit;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 22/10/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    private Money money;

    /**
     * Good way for testing the constructor, but it is only testing a couple of values
     */
    @Test
    public void constructorTest(){
        money = Money.createMoney(10, "£");
        assertEquals(10, money.getAmount());
        assertEquals("£", money.getCurrency());
    }

    /**
     * This is making use of the Parameterised Testing framework
     */
    @Test
    @Parameters({"0, USD", "10, USD", "20, GBP", "30, EUR"})
    public void constructorWithDifferentValuesTest(int amount, String currency) {
        money = Money.createMoney(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1", "-10", "-19873"})
    public void constructorWithInvalidAmountTest(int invalidAmount) {
        money = Money.createMoney(invalidAmount, "USD");
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCurrency")
    public void constructorWithInvalidCurrencyTest(String invalidCurrency) {
        money = Money.createMoney(10, invalidCurrency);
    }

    private static final Object[] getInvalidCurrency() {
        return new String[][] {
                {""}, {null}
        };
    }

}
