// Source code is decompiled from a .class file using FernFlower decompiler.
package main.java.fr.insa.microservice.ManagementMissionMs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJavaMySQL {
   public ConnectionJavaMySQL() {
   }

   public Connection getConnection() {
      try {
         return DriverManager.getConnection("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_056", "projet_gei_056", "Fuvahn5f");
      } catch (SQLException var2) {
         System.out.println("Erreur lors de la connexion \u00e0 la base de donn\u00e9es : " + var2.getMessage());
         return null;
      }
   }
}
