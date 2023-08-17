package com.springboot.rabbitmq.controller;

import com.springboot.rabbitmq.dto.Student;
import com.springboot.rabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class JsonMessageController {

    @Autowired
    private RabbitMQJsonProducer rabbitMQJsonProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody Student student){
        rabbitMQJsonProducer.sendJsonMessage(student);
        return ResponseEntity.ok("Json Message sent to RabbitMQ.... ");
    }
}
