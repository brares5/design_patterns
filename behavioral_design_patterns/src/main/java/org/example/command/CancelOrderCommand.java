package org.example.command;

import org.example.model.Order;
import org.example.service.OrderService;

public class CancelOrderCommand implements OrderCommand {

    private final OrderService orderService;
    private final Order order;

    public CancelOrderCommand(OrderService orderService, Order order) {
        this.orderService = orderService;
        this.order = order;
    }

    @Override
    public void execute() {
        orderService.deleteOrder(order.getId());
        System.out.println("Order canceled successfully: " + order.getId());
    }
}
