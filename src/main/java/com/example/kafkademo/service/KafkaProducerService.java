package com.example.kafkademo.service;

import com.example.kafkademo.dto.PersonDto;

public interface KafkaProducerService {
    boolean send(PersonDto personDto);
}
