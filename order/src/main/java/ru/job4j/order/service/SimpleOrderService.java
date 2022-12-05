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

public class SimpleOrderService implements OrderService {

    private final OrderRepository repository;

    @Override
    public Order createOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Status checkStatus(int orderId) {
        var optionalOrder = this.findById(orderId);
        return optionalOrder.getStatus();
    }

    @Override
    public void deleteOrder(int orderId) {
        repository.deleteById(orderId);
    }

    @Override
    public List<Order> findAllOrders() {
        return repository.findAll();
    }

    @Override
    public Order findById(int orderId) {
        var optionalOrder = repository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new NoSuchElementException("There is no order by this id");
        }
        return optionalOrder.get();
    }

    @Override
    public Order update(Order order) {
       return repository.save(order);
    }
}
