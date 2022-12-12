package ru.job4j.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.order.dto.OrderDto;

@Service
public class KafkaOrderServiceImpl implements KafkaOrderService {

    @Autowired
    private KafkaTemplate<Integer, OrderDto> template;

    @Override
    public void send(OrderDto dto) {
        template.send("messengers", dto);
    }
}
