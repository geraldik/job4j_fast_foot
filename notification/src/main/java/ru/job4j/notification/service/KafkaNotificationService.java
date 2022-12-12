package ru.job4j.notification.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import ru.job4j.domain.Notification;
import ru.job4j.order.dto.OrderDto;

public interface KafkaNotificationService {

    Notification save(Notification notification);

    void consume(ConsumerRecord<Integer, OrderDto> input);
}
