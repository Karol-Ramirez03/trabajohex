package com.hexagonal.person.application;

import java.util.List;

import com.hexagonal.person.domain.entity.Person;
import com.hexagonal.person.domain.service.PersonService;

public class FindPersonUseCase {
    private final PersonService personService;

    public FindPersonUseCase(PersonService personService) {
        this.personService = personService;
    }
    public List<Person> findPerson(){
        return personService.findAllPerson();
    }
}
