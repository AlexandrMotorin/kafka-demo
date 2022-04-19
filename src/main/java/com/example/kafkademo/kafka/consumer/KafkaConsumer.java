package com.example.kafkademo.kafka.consumer;

import com.example.kafkademo.dto.PersonDto;
import com.example.kafkademo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final PersonService personService;

    @KafkaListener(topics = "test")
    public void topicListener(ConsumerRecord<Long, PersonDto> record){
        var value = record.value();
        personService.save(value);
    }
}
