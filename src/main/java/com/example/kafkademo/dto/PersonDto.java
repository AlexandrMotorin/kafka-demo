package com.example.kafkademo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
//@NoArgsConstructor
@Builder
@JsonDeserialize(builder = PersonDto.PersonDtoBuilder.class)
//@AllArgsConstructor
public class PersonDto implements Serializable {

    private String name;
    private int age;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PersonDtoBuilder {

    }
}
