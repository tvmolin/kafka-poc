package com.kafkapoc.pojo;

import java.time.Instant; import java.util.List;

public record OrderCreated( String orderId, String customerId, double totalAmount, List<String> items, Instant createdAt ) {}
