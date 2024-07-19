package com.hexagonal.person.infrastruture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexagonal.database;
import com.hexagonal.person.domain.entity.Person;
import com.hexagonal.person.domain.service.PersonService;


/*
 * El paquete infrastructure se encarga de implementar los detalles técnicos y tecnológicos de la aplicación, 
 * como la persistencia de datos, la comunicación con sistemas externos, 
 * y cualquier integración con tecnologías específicas (por ejemplo, bases de datos, servicios web, etc.). 
 * Esta capa proporciona adaptadores concretos que implementan las interfaces definidas en la capa domain, 
 * permitiendo que las entidades y servicios del dominio interactúen con los recursos externos.
 */

public class PersonRepository implements PersonService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void createPerson(Person person) {
       String sql = "INSERT INTO personas (id,nombre,apellido,edad,email,idciudad) VALUES (?, ?, ?,?,?,?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, person.getId());
            statement.setString(2, person.getNombre());
            statement.setString(3, person.getApellido());
            statement.setInt(4, person.getEdad());
            statement.setString(5, person.getEmail());
            statement.setInt(6, person.getIdciudad());

            statement.executeUpdate();
            System.out.println("Persona creada: " + person.getNombre());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deletePerson(String id)  {
        String query = "DELETE FROM personas WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, id);
            statement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();

        }
        
    }

    @Override
    public List<Person> findAllPerson() {
        List<Person> personas = new ArrayList<>();
        String query = "SELECT id, nombre, apellido, edad, email, idciudad FROM personas";
        //Se utiliza para ejecutar consultas SQL estáticas que no cambian durante la ejecución del programa.
        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String email = rs.getString("email");
                int  idciudad = rs.getInt("idciudad");
                Person person = new Person(id,nombre,apellido,edad,email,idciudad);
                personas.add(person);
            }
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return personas;
    }

    @Override
    public Person findPersonById(String id) {
        String query = "SELECT id, nombre, apellido, edad, email, idciudad FROM personas WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1,id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String email = rs.getString("email");
                int  idciudad = rs.getInt("idciudad");

                return new Person(id, nombre, apellido, edad, email, idciudad);
            }
            connection.close();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null;
    }

    @Override
    public void updatePerson(String id) {
        String query = "UPDATE personas SET nombre = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
            Person persona = findPersonById(id);
            System.out.print("Ingrese el nombre de la persona: ");
            String nombre = scanner.nextLine();
            statement.setString(1, nombre);
            statement.setString(2, persona.getId());
            statement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
}



/*
 * ddl
 *  
 * drop
 * create
 * alter
 * 
 * Dml
 * 
 * insert   _
 * update   _|_ prepareStament --- execute update
 * delect   _|
 * 
 * sql
 * 
 * select - createStatement..... resulset para cuando me retorna algo
 */
