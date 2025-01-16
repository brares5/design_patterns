package org.example.service;

import org.example.model.Order;
import org.example.notification.EmailNotification;
import org.example.notification.SMSNotification;
import org.example.payment.CreditCardPayment;
import org.example.payment.DebitCardPayment;
import org.example.payment.PaymentContext;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;
    private final PaymentValidationHandler paymentValidationHandler;
    private final InventoryCheckHandler inventoryCheckHandler;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            NotificationService notificationService,
            EmailNotification emailNotification,
            SMSNotification smsNotification,
            PaymentValidationHandler paymentValidationHandler,
            InventoryCheckHandler inventoryCheckHandler) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
        this.paymentValidationHandler = paymentValidationHandler;
        this.inventoryCheckHandler = inventoryCheckHandler;

        this.notificationService.addObserver(emailNotification);
        this.notificationService.addObserver(smsNotification);

        this.paymentValidationHandler.setNext(this.inventoryCheckHandler);
    }

    public Order addOrder(Order order) {
        paymentValidationHandler.validate(order);

        order.updateStatus("COMPLETED");

        Order savedOrder = orderRepository.save(order);

        notificationService.notifyObservers("Order " + savedOrder.getId() + " placed successfully.");

        return savedOrder;
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrderOpt = orderRepository.findById(id);
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            existingOrder.setCustomerName(updatedOrder.getCustomerName());
            existingOrder.setStatus(updatedOrder.getStatus());
            existingOrder.setProducts(updatedOrder.getProducts());

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

    public void processOrder(Order order) {
        PaymentContext paymentContext = new PaymentContext();

        String orderCard = order.getTypeOfPayment();

        if ("credit".equalsIgnoreCase(orderCard)) {
            paymentContext.setPaymentStrategy(new CreditCardPayment());
        } else if ("debit".equalsIgnoreCase(orderCard)) {
            paymentContext.setPaymentStrategy(new DebitCardPayment());
        } else {
            throw new RuntimeException("Invalid credit card!");
        }

        paymentContext.processPayment();
    }
}
