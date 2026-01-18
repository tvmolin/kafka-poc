package com.kafkapoc.producer;

import com.kafkapoc.pojo.OrderCreated;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, OrderCreated> kafkaTemplate;
    private static final String TOPIC = "orders";

    public OrderProducer(KafkaTemplate<String, OrderCreated> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(OrderCreated event) {
        kafkaTemplate.send(TOPIC, event.restaurantId(), event);
    }
}