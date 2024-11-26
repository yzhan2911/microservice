package main.java.fr.insa.microservice.ManagementMissionMs.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.fr.insa.microservice.ManagementMissionMs.model.ConnectionJavaMySQL;

public class managementMissionSQL {

 public static List<Mission> getAllMission() {
        List<Mission> missions = new ArrayList<>();
        String query = "SELECT * FROM Mission";
        Connection connection = connectionManager.getConnection();

        try (
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Mission mission = new Mission(
                        resultSet.getInt("idmission"),
                        resultSet.getInt("idDemandeur"),
                        resultSet.getInt("idBenevole"),
                        resultSet.getInt("state"),
                        resultSet.getString("comment")
                );
                missions.add(mission);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return missions;
    }

    
    public static Mission getMissionById(int idMission) {
        Mission mission = null;
        String query = "SELECT * FROM Mission WHERE idmission = ?";
        Connection connection = connectionManager.getConnection();

        try (
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idMission);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                mission = new Mission(
                        resultSet.getInt("idmission"),
                        resultSet.getInt("idDemandeur"),
                        resultSet.getInt("idBenevole"),
                        resultSet.getInt("state"),
                        resultSet.getString("comment")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mission;
    }


    public static void addMission(Mission mission) {
        String query = "INSERT INTO Mission (idDemandeur, idBenevole, state, comment) VALUES (?, ?, ?, ?)";
        Connection connection = connectionManager.getConnection();
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, mission.getIdDemandeur());
            preparedStatement.setInt(2, mission.getIdBenevole());
            preparedStatement.setInt(3, mission.getState());
            preparedStatement.setString(4, mission.getComment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public static void deleteMission(int idMission) {
  ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
      Connection connection = connectionManager.getConnection();
      try (
          Statement statement = connection.createStatement()) {
          statement.execute("Delete from Mission WHERE idmission = ?"+ idMission + "'");
          statement.close();
          connection.close();
      }catch(SQLException e){
          e.printStackTrace();
      }
}


public static void assignMission(int idMission, int idBenevole) {
    String query = "UPDATE Mission SET idBenevole = ?, state = 1 WHERE idmission = ?";

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, idBenevole);
        preparedStatement.setInt(2, idMission);
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
