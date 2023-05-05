package com.hedima.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected Connection miConexion;
    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url ="jdbc:postgresql://localhost:5432/Northwind";
        String user= "postgres";
        String password= "claudio90553";
        miConexion = DriverManager.getConnection(url, user, password);
        System.out.println("Exito al abrir la conexion");
    }
    public void cerrar() throws SQLException {
        miConexion.close();
    }

    public Conexion() {
    }

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }
}
