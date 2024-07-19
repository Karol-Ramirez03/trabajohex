package com.hexagonal;

import com.hexagonal.person.adapter.in.personConsoleAdapter;
import com.hexagonal.person.application.DeletePersonUseCase;
import com.hexagonal.person.application.FindPersoByIdUseCase;
import com.hexagonal.person.application.FindPersonUseCase;
import com.hexagonal.person.application.UpdatePersonUseCase;
import com.hexagonal.person.application.createPersonUseCase;
import com.hexagonal.person.infrastruture.PersonRepository;

public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        
        createPersonUseCase usecase = new createPersonUseCase(personRepository);
        DeletePersonUseCase usecasedel = new DeletePersonUseCase(personRepository);
        FindPersoByIdUseCase usecaseid = new FindPersoByIdUseCase(personRepository);
        FindPersonUseCase usecasefind = new FindPersonUseCase(personRepository);
        UpdatePersonUseCase usecaseupd = new UpdatePersonUseCase(personRepository);
        personConsoleAdapter console = new personConsoleAdapter(usecase,usecasedel,usecaseid,usecasefind,usecaseupd);

        console.start();
    }
}