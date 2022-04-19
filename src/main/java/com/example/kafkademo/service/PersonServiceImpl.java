package com.example.kafkademo.service;

import com.example.kafkademo.dto.PersonDto;
import com.example.kafkademo.dto.PersonMapper;
import com.example.kafkademo.model.Person;
import com.example.kafkademo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    @Override
    public void save(PersonDto dto) {
        personRepository.save(mapper.from(dto));
    }

    @Override
    public List<PersonDto> findAll() {
        return personRepository.findAll().stream().map(mapper::to).collect(toList());
    }

    @Override
    public PersonDto findById(Long id) {
        Optional<Person> byId = personRepository.findById(id);
        return byId.map(mapper::to).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
