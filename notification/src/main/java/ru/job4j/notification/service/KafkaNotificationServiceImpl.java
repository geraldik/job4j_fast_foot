package ru.job4j.notification.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Notification;
import ru.job4j.notification.repository.NotificationRepository;
import ru.job4j.order.dto.OrderDto;

@Service
@AllArgsConstructor
public class KafkaNotificationServiceImpl implements KafkaNotificationService {
    private final NotificationRepository repository;

    @Override
    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    @Override
    @KafkaListener(topics = {"messengers"})
    public void consume(ConsumerRecord<Integer, OrderDto> input) {
        var dto = input.value();
        var notification = new Notification();
        notification.setMessage(dto.getDescription());
        save(notification);
    }
}

