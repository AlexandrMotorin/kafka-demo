package com.example.kafkademo.service;

import com.example.kafkademo.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {
    
    private final KafkaTemplate<Long, PersonDto> kafkaTemplate;
    private final String TOPIC = "test";

    @Override
    public boolean send(PersonDto personDto) {
        long key = new Random().nextLong();
        ListenableFuture<SendResult<Long, PersonDto>> send = kafkaTemplate.send(TOPIC, key, personDto);
        return true;
    }
}
