package ru.job4j.order.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Order;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.service.KafkaOrderService;
import ru.job4j.order.service.SimpleOrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final SimpleOrderService service;

    private final KafkaOrderService kafkaOrderService;

    private final ModelMapper modelMapper;

    @PostMapping()
    public ResponseEntity<Order> crateOrder(@RequestBody Order order) {
        var savedOrder = service.createOrder(order);
        kafkaOrderService.send(orderToDto(order));
        return new ResponseEntity<>(
                savedOrder,
                HttpStatus.CREATED
        );
    }

    private OrderDto orderToDto(Order order) {
       return modelMapper.map(order, OrderDto.class);
    }

    @GetMapping()
    public ResponseEntity<List<Order>> findAllOrders() {
        var orders = service.findAllOrders();
        return new ResponseEntity<>(
                orders,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable int id) {
        var order = service.findById(id);
        return new ResponseEntity<>(
                order,
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable int id, Order order) {
        order.setId(id);
        var updateOrder = service.update(order);
        return new ResponseEntity<>(
                updateOrder,
                HttpStatus.OK
        );
    }

}
