package com.hexagonal.person.application;

import com.hexagonal.person.domain.entity.Person;
import com.hexagonal.person.domain.service.PersonService;

public class FindPersoByIdUseCase {

    private final PersonService personService;

    public FindPersoByIdUseCase(PersonService personService) {
        this.personService = personService;
    }
    
    public Person findPersonById(String id){
        return personService.findPersonById(id); 
    }

}
