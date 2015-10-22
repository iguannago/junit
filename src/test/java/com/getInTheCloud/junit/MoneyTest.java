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

    /**
     * Good way for testing the constructor, but it is only testing a couple of values
     */
    @Test
    public void constructorTest(){
        Money money = new Money(10, "£");
        assertEquals(10, money.getAmount());
        assertEquals("£", money.getCurrency());
    }

    /**
     * This is making use of the Parameterised Testing framework
     */
    @Test
    @Parameters(method = "getMoney")
    public void constructorWithDifferentValuesTest(int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    public static final Object[] getMoney() {
        return new Object[] {
                new Object[] {10, "USD"},
                new Object[] {20, "GBP"},
                new Object[] {30, "EUR"}
        };
    }

}
