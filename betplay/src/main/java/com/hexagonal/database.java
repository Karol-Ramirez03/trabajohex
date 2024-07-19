package com.hexagonal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * crear clase con datos de la base de datos local
 * el localhost suele ser 3306/y el nombre de la base de datos
 *  
 */

public class database {
    private static final String URL = "jdbc:mysql://localhost:3306/ejemplo";
    private static final String USER = "root";
    private static final String PASSWORD = "Kr03";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

