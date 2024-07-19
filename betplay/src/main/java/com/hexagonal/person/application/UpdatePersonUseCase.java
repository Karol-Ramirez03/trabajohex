package com.hexagonal.person.application;

import com.hexagonal.person.domain.service.PersonService;

public class UpdatePersonUseCase {
    private final PersonService personService;

    public UpdatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void updatePerson(String id) {
        personService.updatePerson(id);
    }
}
