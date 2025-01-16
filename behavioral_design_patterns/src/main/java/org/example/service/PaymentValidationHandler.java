package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentValidationHandler extends OrderValidationHandler {

    @Override
    public void validate(Order order) {
        if (validatePayment(order)) {
            log.info("Payment validation passed for order -- " + order.toString());
            super.validate(order); // Proceed to the next handler
        } else {
            log.error("Payment validation failed for order ID -- " + order.toString());
            throw new RuntimeException("Payment validation failed.");
        }
    }

    private boolean validatePayment(Order order) {
        // for simplicity, all payments are valid
        return true;
    }
}
