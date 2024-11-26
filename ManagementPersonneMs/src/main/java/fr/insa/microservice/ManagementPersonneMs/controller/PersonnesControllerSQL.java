package fr.insa.microservice.ManagementPersonneMs.controller;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
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
                int role = resultSet.getInt("role"); 
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
      int role=P.getRole();
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
  
  public  void supprimerPersonne(int idPersonne ) {
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
      Connection connection = connectionManager.getConnection();
      try (
          Statement statement = connection.createStatement()) {
          statement.execute(" Delete from Personne where id = '"+ idPersonne + "'");
          // System.out.println(id + "bien supprime au tableau de personne");
          statement.close();
          connection.close();
      }catch(SQLException e1){
          e1.printStackTrace();
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
            int role = resultSet.getInt("role");
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



public  void setRole(int idPersonne,int role) {
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
    Connection connection = connectionManager.getConnection();

    String query = null;

    switch (role) {
        case 1:
            query = "UPDATE Personne SET role = 1 WHERE id = " + idPersonne;
            break;
        case 2:
            query = "UPDATE Personne SET role = 2 WHERE id = " + idPersonne;
            break;
        case 3:
            query = "UPDATE Personne SET role = 3, age = NULL WHERE id = " + idPersonne;
            break;
        default:
            System.out.println("Rôle non valide : " + role);
            return; 
    }
    try (
        Statement statement = connection.createStatement()) {
        int rowsUpdated = statement.executeUpdate(query);

        if (rowsUpdated > 0) {
            System.out.println("Le rôle de la personne avec l'ID " + idPersonne + " a été mis à jour.");
        } else {
            System.out.println("Aucune personne trouvée avec l'ID " + idPersonne + ".");
        }

        statement.close();
        connection.close();
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
         String query = "SELECT * FROM Personne where role = 1";
         ResultSet resultSet = statement.executeQuery(query);
         
         while (resultSet.next()) {
             int id = resultSet.getInt("id");
             String nom = resultSet.getString("nom");
             String prenom = resultSet.getString("prenom");
             int age = resultSet.getInt("age");
             int role = resultSet.getInt("role"); 
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
        String query = "SELECT * FROM Personne where role = 2";
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            int role = resultSet.getInt("role"); 
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
        String query = "SELECT * FROM Personne where role = 3";
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            int age = resultSet.getInt("age");
            int role = resultSet.getInt("role"); 
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