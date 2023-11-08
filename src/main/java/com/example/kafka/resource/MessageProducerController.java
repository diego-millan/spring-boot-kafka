package com.example.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducerController {

    private static final String TOPIC = "ecommerce.client";

    @Autowired
    private KafkaTemplate<String, String> template;

    @PostMapping("/producer/{message}")
    public void produce(@PathVariable("message") String message) {
        template.send(TOPIC, message);
    }
}
