package com.example.kafkademo.service;

import com.example.kafkademo.dto.PersonDto;

import java.util.List;

public interface PersonService {

    void save(PersonDto person);
    List<PersonDto> findAll();
    PersonDto findById(Long id);
    void deleteById(Long id);

}
