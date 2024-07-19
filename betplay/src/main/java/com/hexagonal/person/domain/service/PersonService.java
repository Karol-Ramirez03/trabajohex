package com.hexagonal.person.domain.service;

import java.util.List;

import com.hexagonal.person.domain.entity.Person;

public interface PersonService {
    void createPerson(Person person);
    void updatePerson( String id);
    void deletePerson(String id);
    Person findPersonById(String id);
    List<Person> findAllPerson();
}
