package com.kafkapoc.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {

    @Id
    private String orderId;

    private String customerId;

    private String restaurantId;

    private double totalAmount;

    @ElementCollection
    private List<String> items;

    private Instant createdAt;

    public OrderEntity() {
    }

    public OrderEntity(String orderId, String customerId, double totalAmount, List<String> items, Instant createdAt, String restaurantId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.items = items;
        this.createdAt = createdAt;
        this.restaurantId = restaurantId;
    }
}
