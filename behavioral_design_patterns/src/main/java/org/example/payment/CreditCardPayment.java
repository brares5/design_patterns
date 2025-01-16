package org.example.payment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay() {
        if (validateCard()) {
            log.info("Paid with Credit Card.");
        } else {
            throw new RuntimeException("Credit card validation failed. Payment could not be processed.");
        }
    }

    private boolean validateCard() {
        // assume card is valid for simplicity
        return true;
    }
}
