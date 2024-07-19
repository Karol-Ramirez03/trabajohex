package com.hexagonal.person.application;

import com.hexagonal.person.domain.service.PersonService;

public class DeletePersonUseCase {
    private final PersonService personService;

    public DeletePersonUseCase(PersonService personService) {
        this.personService = personService;
    }
    
    public void delete(String id) {
        personService.deletePerson(id);
    }
}
