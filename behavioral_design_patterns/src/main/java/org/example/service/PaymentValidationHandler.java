package org.example.service;

import org.example.model.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentValidationHandler extends OrderValidationHandler {

    @Override
    public void validate(Order order) {
        boolean paymentValid = validatePayment(order);

        if (paymentValid) {
            System.out.println("Payment validation passed for order ID: " + order.getId());
            super.validate(order);
        } else {
            System.out.println("Payment validation failed for order ID: " + order.getId());
            throw new RuntimeException("Payment validation failed.");
        }
    }

    private boolean validatePayment(Order order) {
        // for simplicity, all payments are validated
        return true;
    }
}
