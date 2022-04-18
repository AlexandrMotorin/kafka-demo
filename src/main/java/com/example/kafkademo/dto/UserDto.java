package com.example.kafkademo.dto;

import com.example.kafkademo.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long age;
    private String name;
    private Address address;
}
