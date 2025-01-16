package org.example.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        log.info("Processing payment");
        if (paymentStrategy != null) {
            paymentStrategy.pay();
        } else {
            log.error("No payment method set.");
        }
    }
}

