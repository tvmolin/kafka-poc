package com.kafkapoc.consumer;

import com.kafkapoc.pojo.OrderCreated;
import com.kafkapoc.persistence.OrderEntity;
import com.kafkapoc.persistence.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final OrderRepository repository;

    public OrderConsumer(OrderRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "orders", groupId = "order-processing")
    public void handleOrder(OrderCreated event) {
        OrderEntity entity = new OrderEntity(
                event.orderId(),
                event.customerId(),
                event.totalAmount(),
                event.items(),
                event.createdAt(),
                event.restaurantId()
        );

        repository.save(entity);
        System.out.println("Saved order " + event.orderId());
    }
}
