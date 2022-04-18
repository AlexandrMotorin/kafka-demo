package com.example.kafkademo.controller;

import com.example.kafkademo.dto.UserDto;
import com.example.kafkademo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<Long, UserDto> kafkaTemplate;

    @GetMapping
    public void sendOrder(){
//        msg.setAddress(new Address("RUS","Msk","Lenina",1L,1L));
        UserDto userDto = UserDto.builder()
                .name("Alexandr")
                .age(25L)
                .address(new Address("RUS", "Msk", "Lenina St", 5L, 41L))
                .build();

        Long msgId = 1L;

        ListenableFuture<SendResult<Long, UserDto>> future = kafkaTemplate.send("msg", msgId, userDto);
        future.addCallback(System.out::println,System.err::println);
        kafkaTemplate.flush();
    }
}
