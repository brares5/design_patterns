package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryCheckHandler extends OrderValidationHandler {

    private final ProductRepository productRepository;

    @Autowired
    public InventoryCheckHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(Order order) {
        for (String product : order.getProducts()) {
            Product existingProduct = productRepository.findByName(product)
                    .orElseThrow(() -> new RuntimeException("Product " + product + " does not exist."));

            if (existingProduct.getStockQuantity() > 0) {
                existingProduct.decrementStock();
                productRepository.save(existingProduct);
                log.info("Stock decremented for product: " + product);
            } else {
                throw new RuntimeException("Product " + product + " is out of stock.");
            }
        }

        log.info("Inventory check passed for order -- " + order.toString());
        super.validate(order);
    }

}
