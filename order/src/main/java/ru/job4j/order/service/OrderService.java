package ru.job4j.order.service;

import ru.job4j.domain.Order;
import ru.job4j.domain.Status;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Status checkStatus(int orderId);

    void deleteOrder(int orderId);

    List<Order> findAllOrders();

    Order findById(int orderId);

    Order update(Order order);
}
