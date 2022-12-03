package ru.job4j.order.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Order;
import ru.job4j.domain.Status;
import ru.job4j.order.repository.OrderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor

public class OrderService {

    private final OrderRepository repository;

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Status checkStatus(int orderId) {
        var optionalOrder = this.findById(orderId);
        return optionalOrder.getStatus();
    }

    public void deleteOrder(int orderId) {
        repository.deleteById(orderId);
    }

    public List<Order> findAllOrders() {
        return repository.findAll();
    }

    public Order findById(int orderId) {
        var optionalOrder = repository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new NoSuchElementException("There is no order by this id");
        }
        return optionalOrder.get();
    }

    public Order update(Order order) {
       return repository.save(order);
    }
}
