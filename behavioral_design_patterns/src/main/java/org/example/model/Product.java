package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int stockQuantity; // Represents the number of items in stock
    private double price;

    public void decrementStock() {
        if (stockQuantity > 0) {
            stockQuantity -= 1;
        } else {
            throw new RuntimeException("Product " + name + " is out of stock.");
        }
    }
}
