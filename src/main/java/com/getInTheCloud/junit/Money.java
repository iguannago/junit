package com.getInTheCloud.junit;

/**
 * Created by davicres on 22/10/2015.
 */
public final class Money {
    private final int amount;
    private final String currency;

    private Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money createMoney(int amount, String currency) {
        if (amount < 0)
            throw new IllegalArgumentException();
        return new Money(amount, currency);
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (amount != money.amount) return false;
        return !(currency != null ? !currency.equals(money.currency) : money.currency != null);

    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Money onePound = createMoney(1, "€");
        Money oneEuro = createMoney(1, "€");
        System.out.println("oneEuro: " + oneEuro);
        System.out.println("onePound: " + onePound);
        if (oneEuro.equals(onePound))
            System.out.println("OneEuro is equal to OnePound");
        else
            System.out.println("OneEuro is NOT equal to OnePound");
    }

}
