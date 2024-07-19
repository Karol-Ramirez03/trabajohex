package com.hexagonal.person.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.hexagonal.person.application.DeletePersonUseCase;
import com.hexagonal.person.application.FindPersoByIdUseCase;
import com.hexagonal.person.application.FindPersonUseCase;
import com.hexagonal.person.application.UpdatePersonUseCase;
import com.hexagonal.person.application.createPersonUseCase;
import com.hexagonal.person.domain.entity.Person;

public class personConsoleAdapter {
    //el menu
    private final createPersonUseCase personService;
    private final DeletePersonUseCase personServiceDelete;
    private final FindPersoByIdUseCase personById;
    private final FindPersonUseCase Findperson;
    private final UpdatePersonUseCase updateperson;





    //personservice es la interfaz de definicion de toda la implementacion del crud
    //pero realmente aqui le pasamos pasamos personreposity que implementa la interfaz y tiene la logica
    
    


    public personConsoleAdapter(createPersonUseCase personService, DeletePersonUseCase personServiceDelete,
            FindPersoByIdUseCase personById, FindPersonUseCase findperson, UpdatePersonUseCase updateperson) {
        this.personService = personService;
        this.personServiceDelete = personServiceDelete;
        this.personById = personById;
        Findperson = findperson;
        this.updateperson = updateperson;
    }





    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear persona");
            System.out.println("2. Actualizar persona");
            System.out.println("3. Buscar persona por ID");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Listar todos personas");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el id de la persona: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese el nombre de la persona: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido de la persona: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese el edad de la persona: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el email de la persona: ");
                    String email = scanner.next();
                    System.out.print("Ingrese el id de la ciudad de la persona: ");
                    int idciudad = scanner.nextInt();

                    Person newperson = new Person(id,nombre,apellido,edad,email,idciudad);
                    personService.execute(newperson);
                    break;

                case 2:
                    System.out.print("Ingrese el id de la persona: ");
                    String idbuscarup = scanner.nextLine();
        
                    updateperson.updatePerson(idbuscarup);
                    break;

                case 3:
                    System.out.print("Ingrese el id de la persona: ");
                    String idbuscar = scanner.nextLine();
                
                    Person persona = personById.findPersonById(idbuscar);
                    System.out.println("ID: " + persona.getId());
                    System.out.println("Nombre: " + persona.getNombre());
                    System.out.println("Apellido: " + persona.getApellido());
                    System.out.println("Edad: " + persona.getEdad());
                    System.out.println("Email: " + persona.getEmail());
                    System.out.println("ID Ciudad: " + persona.getIdciudad());

                    break;

                case 4:
                    System.out.print("Ingrese el id de la persona: ");
                    String idDelete = scanner.nextLine();
                    
                    personServiceDelete.delete(idDelete);
                    break;

                case 5:
                    List<Person> listperson = Findperson.findPerson();
                    for (Person person : listperson) {
                        System.out.println("ID: " + person.getId() + " Nombre: " + person.getNombre()+ " Apellido: " + person.getApellido() + " Edad: " + person.getEdad() + " Email: " + person.getEmail() + " ID Ciudad: " + person.getIdciudad());
                        System.out.println("--------------------");
                    }
            
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
