package ru.job4j.order.service;

import ru.job4j.order.dto.OrderDto;

public interface KafkaOrderService {
    void send(OrderDto dto);
}
