package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;
    private String typeOfPayment;

    @Transient
    private List<String> products;

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        log.info("Order " + "status updated to: " + newStatus);
    }


    public String toString() {
        return "Customer name: '" +
                this.customerName +
                "', Order status: '" +
                this.status + "', Products: '" +
                this.products + "'";
    }
}
