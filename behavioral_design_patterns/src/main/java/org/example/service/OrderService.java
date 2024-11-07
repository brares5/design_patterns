package org.example.service;

import org.example.model.Order;
import org.example.notification.EmailNotification;
import org.example.notification.SMSNotification;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.notification.Observer;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    @Autowired
    public OrderService(OrderRepository orderRepository, NotificationService notificationService, EmailNotification emailNotification, SMSNotification smsNotification) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
        this.notificationService.addObserver(emailNotification);
        this.notificationService.addObserver(smsNotification);
    }

    public Order addOrder(Order order) {
        notificationService.notifyObservers("Order " + order.getId() + " placed successfully.");
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrderOpt = orderRepository.findById(id);
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            existingOrder.setCustomerName(updatedOrder.getCustomerName());
            existingOrder.setStatus(updatedOrder.getStatus());
            existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            notificationService.notifyObservers("Order " + id + " has been updated.");
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        notificationService.notifyObservers("Order " + id + " has been canceled.");
        orderRepository.deleteById(id);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
