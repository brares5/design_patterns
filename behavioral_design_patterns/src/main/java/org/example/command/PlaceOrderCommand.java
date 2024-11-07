package org.example.command;

import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class PlaceOrderCommand implements OrderCommand {

    @Autowired
    private OrderService orderService;

    private final Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        orderService.addOrder(order);
        System.out.println("Order placed successfully: " + order.getId());
    }
}
