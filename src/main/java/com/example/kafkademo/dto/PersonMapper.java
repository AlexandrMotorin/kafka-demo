package com.example.kafkademo.dto;

import com.example.kafkademo.model.Person;

public interface PersonMapper {

    PersonDto to(Person person);
    Person from(PersonDto personDto);

}
