package org.example.service;

import org.example.model.Order;
import org.springframework.stereotype.Component;

@Component
public class InventoryCheckHandler extends OrderValidationHandler {

    @Override
    public void validate(Order order) {
        // Simulate checking inventory stock for each item in the order
        boolean inStock = checkInventory(order);

        if (inStock) {
            System.out.println("Inventory check passed for order ID: " + order.getId());
            super.validate(order); // Proceed to the next validation step if available
        } else {
            System.out.println("Inventory check failed for order ID: " + order.getId());
            throw new RuntimeException("Inventory check failed: some items are out of stock.");
        }
    }

    private boolean checkInventory(Order order) {
        // w will assume that all items are in stock for simplticity
        return true;
    }
}
