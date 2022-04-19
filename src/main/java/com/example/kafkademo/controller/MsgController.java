package com.example.kafkademo.controller;

import com.example.kafkademo.dto.PersonDto;
import com.example.kafkademo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class MsgController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public void sendOrder(@RequestBody PersonDto personDto){
        kafkaProducerService.send(personDto);
    }
}
