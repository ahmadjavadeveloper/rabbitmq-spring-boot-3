package com.springboot.rabbitmq.publisher;

import com.springboot.rabbitmq.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(Student student){
        LOGGER.info(String.format("Json message sent -> %s", student.toString()));
        rabbitTemplate.convertAndSend(exchangeName, routingJsonKey, student);
    }
}
