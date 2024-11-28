package fr.insa.microservice.ManagementPersonneMs.controller;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.insa.microservice.ManagementPersonneMs.model.Benevole;
import fr.insa.microservice.ManagementPersonneMs.model.ConnectionJavaMySQL;
import fr.insa.microservice.ManagementPersonneMs.model.Demandeur;
import fr.insa.microservice.ManagementPersonneMs.model.Personne;
import fr.insa.microservice.ManagementPersonneMs.model.Valideur;

public class PersonnesControllerSQL {

    public  List<Personne> getAllPersonnes() {
        List<Personne> personnes = new ArrayList<>();
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
        
        try (
            Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Personne";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                int age = resultSet.getInt("age");
                String role = resultSet.getString("role"); 
                Personne personne = new Personne(id, nom, prenom, age,role);
                personnes.add(personne);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnes;
    }



  public  void ajoutPersonne(Personne P){
      int id=P.getId();
      String nom=P.getNom();
      String prenom=P.getPrenom();
      int age=P.getAge();
      String role=P.getRole();
      ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
      Connection connection = connectionManager.getConnection();
      try (
          Statement statement = connection.createStatement()) {
          statement.execute(" INSERT INTO Personne (id, nom, prenom,age,role) VALUES ('"+id+"', '"+nom+"', '"+prenom+"', '"+age+"', '"+role+"')");
          statement.close();
          connection.close();
      }catch(SQLException e1){
          e1.printStackTrace();
      }     
  }
  
  public  boolean supprimerPersonne(int idPersonne ) {
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
    Connection connection = connectionManager.getConnection();
    String query = "DELETE FROM Personne WHERE id = ?";
    try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, idPersonne);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }catch(SQLException e1){
        e1.printStackTrace();
        return false;
    }
             
  }


  public  Personne getPersonneById(int idPersonne) {
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
    Connection connection = connectionManager.getConnection();
    Personne personne = null;

    try (
        Statement statement = connection.createStatement()) {
        String query = "SELECT * FROM Personne WHERE id = " + idPersonne;
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            String role = resultSet.getString("role");
            personne = new Personne(id, nom, prenom, age, role);
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return personne;
}



public  void setRole(int idPersonne,String role) {
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
    Connection connection = connectionManager.getConnection();
    String query = "UPDATE Personne SET role = ? WHERE id = ?";
     
    try (
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role);
            preparedStatement.setInt(2, idPersonne);
            int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Le rôle de la personne avec l'ID " + idPersonne + " a été mis à jour.");
        } else {
            System.out.println("Aucune personne trouvée avec l'ID " + idPersonne + ".");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public  List<Demandeur> getAllDemandeurs() {
	 List<Demandeur> Demandeurs = new ArrayList<>();
     ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
     Connection connection = connectionManager.getConnection();
     
     try (
         Statement statement = connection.createStatement()) {
         String query = "SELECT * FROM Personne where role = 'Demandeur'";
         ResultSet resultSet = statement.executeQuery(query);
         
         while (resultSet.next()) {
             int id = resultSet.getInt("id");
             String nom = resultSet.getString("nom");
             String prenom = resultSet.getString("prenom");
             int age = resultSet.getInt("age");
             String role = resultSet.getString("role"); 
             Demandeur demandeur = new Demandeur(id, nom, prenom, age,role);
             Demandeurs.add(demandeur);
         }
         resultSet.close();
         statement.close();
         connection.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return Demandeurs;
}

public  List<Benevole> getAllBenevoles() {
	 List<Benevole> Benevoles = new ArrayList<>();
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
    Connection connection = connectionManager.getConnection();
    
    try (
        Statement statement = connection.createStatement()) {
        String query = "SELECT * FROM Personne where role = 'Bénévole'";
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            String role = resultSet.getString("role"); 
            Benevole benevole = new Benevole(id, nom, prenom, age,role);
            Benevoles.add(benevole);
        }
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Benevoles;
}

public  List<Valideur> getAllValideurs() {
	 List<Valideur> Valideurs = new ArrayList<>();
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
    Connection connection = connectionManager.getConnection();
    
    try (
        Statement statement = connection.createStatement()) {
        String query = "SELECT * FROM Personne where role = 'Valideur'";
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            String role = resultSet.getString("role"); 
            Valideur valideur = new Valideur(id, nom, prenom, age,role);
            Valideurs.add(valideur);
        }
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Valideurs;
}

}