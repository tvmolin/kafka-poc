package com.kafkapoc.rest;

import com.kafkapoc.persistence.OrderEntity;
import com.kafkapoc.persistence.OrderRepository;
import com.kafkapoc.pojo.OrderCreated;
import com.kafkapoc.producer.OrderProducer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer producer;
    private final OrderRepository repository;

    public OrderController(OrderProducer producer, OrderRepository repository) {
        this.producer = producer;
        this.repository = repository;
    }

    @PostMapping
    public OrderCreated createOrder(@RequestBody @Validated OrderCreated request) {
        OrderCreated event = new OrderCreated(
                UUID.randomUUID().toString(),
                request.customerId(),
                request.totalAmount(),
                request.items(),
                Instant.now(),
                request.restaurantId());
        producer.send(event);
        return event;
    }

    @GetMapping
    public List<OrderEntity> getAll() {
        return repository.findAll();
    }
}
