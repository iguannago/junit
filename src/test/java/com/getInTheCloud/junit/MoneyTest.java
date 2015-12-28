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
    @Parameters(method = "getMoney")
    public void constructorWithDifferentValuesTest(int amount, String currency) {
        money = Money.createMoney(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    private static final Object[] getMoney() {
        return new Object[] {
                new Object[] {0, "USD"},
                new Object[] {10, "USD"},
                new Object[] {20, "GBP"},
                new Object[] {30, "EUR"}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void constructorWithInvalidAmountTest(int invalidAmount) {
        money = Money.createMoney(invalidAmount, "USD");
    }

    private static final Object[] getInvalidAmount() {
        return new Integer[][] {
                {-1}, {-10}, {-19873}
        };
    }

}
