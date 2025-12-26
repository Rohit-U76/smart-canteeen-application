package com.canteen.Smart_Canteen.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    private LocalDateTime orderTime = LocalDateTime.now();

    // --- REQUIRED FIX: Must return the Long id ---
    public Long getId() {
        return id;
    }

    // --- REQUIRED GETTERS/SETTERS ---
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    // Placeholder setter for JPA
    public void setId(Long id) {
        this.id = id;
    }

    // Enum
    public enum OrderStatus {
        PENDING, READY, PICKED_UP
    }
}