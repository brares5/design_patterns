package org.example.payment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class DebitCardPayment implements PaymentStrategy {


    @Override
    public void pay() {
        if (validateCard()) {
            log.info("Paid with Debit Card");
        } else {
            throw new RuntimeException("Debit card validation failed. Payment could not be processed.");
        }
    }

    private boolean validateCard() {
        return true;
    }
}
