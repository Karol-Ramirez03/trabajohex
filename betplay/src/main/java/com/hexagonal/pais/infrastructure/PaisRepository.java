package com.hexagonal.pais.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hexagonal.database;
import com.hexagonal.pais.domain.entity.Pais;
import com.hexagonal.pais.domain.service.PaisService;

public class PaisRepository implements PaisService {
    Scanner sc = new Scanner(System.in);

    @Override
    public void createPais(Pais Pais) {
    String sql = "INSERT INTO pais (nombre) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(2, Pais.getNombre());

            statement.executeUpdate();
            System.out.println("pais creado: " + Pais.getNombre());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
        

    @Override
    public void deletePais(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Pais> findAllPais() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pais findPaisById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updatePais(String id) {
        // TODO Auto-generated method stub
        
    }

}
