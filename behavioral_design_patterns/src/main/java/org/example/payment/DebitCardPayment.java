package org.example.payment;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DebitCardPayment implements PaymentStrategy {

    private final String cardNumber;

    @Override
    public void pay(double amount) {
        if (validateCard()) {
            System.out.println("Paid $" + amount + " with Debit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
        } else {
            throw new RuntimeException("Debit card validation failed. Payment could not be processed.");
        }
    }

    private boolean validateCard() {
        return true;
    }
}
