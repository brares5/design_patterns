
package org.example.service;

import org.example.model.Order;

public abstract class OrderValidationHandler {
    protected OrderValidationHandler next;

    public void setNext(OrderValidationHandler next) {
        this.next = next;
    }

    public void validate(Order order) {
        if (next != null) {
            next.validate(order);
        }
    }
}
