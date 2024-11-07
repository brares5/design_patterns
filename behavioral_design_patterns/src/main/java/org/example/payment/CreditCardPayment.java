package org.example.payment;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryDate;
    private final String cvv;

    @Override
    public void pay(double amount) {
        if (validateCard()) {
            System.out.println("Paid $" + amount + " with Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
        } else {
            throw new RuntimeException("Credit card validation failed. Payment could not be processed.");
        }
    }

    private boolean validateCard() {
        // assume card is valid for simplicity
        return true;
    }
}
