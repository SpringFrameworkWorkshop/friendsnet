package io.spring.friendsnet.controller.domain;

import lombok.Data;

import java.util.Set;

@Data
public class PersonDTO {

    private String name, surname;
    private PersonDTO parent;
    private Set<PersonDTO> children;

}
