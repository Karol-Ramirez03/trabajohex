package com.hexagonal.person.application;


import com.hexagonal.person.domain.entity.Person;
import com.hexagonal.person.domain.service.PersonService;

public class createPersonUseCase {
    private final PersonService personService;

    public createPersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person){
        personService.createPerson(person);
    }
}
