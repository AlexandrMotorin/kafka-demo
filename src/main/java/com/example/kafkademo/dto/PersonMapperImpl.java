package com.example.kafkademo.dto;

import com.example.kafkademo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper{

    @Override
    public PersonDto to(Person person) {
//        return new PersonDto(person.getName(), person.getAge());
        return PersonDto.builder()
                .name(person.getName())
                .age(person.getAge())
                .build();
    }

    @Override
    public Person from(PersonDto personDto) {
        return Person.builder()
                .name(personDto.getName())
                .age(personDto.getAge())
                .build();
    }
}
