package fr.insa.microservice.ManagementPersonneMs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJavaMySQL {
	   public Connection getConnection() {
	        try {
	            return DriverManager.getConnection("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_056", "projet_gei_056", "Fuvahn5f");
	        } catch (SQLException e) {
	            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
	        }
	        return null;
	    }
}
