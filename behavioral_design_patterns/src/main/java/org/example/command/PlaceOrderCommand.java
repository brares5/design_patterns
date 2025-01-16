package org.example.command;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
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
        log.info("Order placed successfully: " + order.getId());
    }
}
