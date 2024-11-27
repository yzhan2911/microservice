package fr.insa.microservice.ManagementMissionMs.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import fr.insa.microservice.ManagementMissionMs.model.ConnectionJavaMySQL;
import fr.insa.microservice.ManagementMissionMs.model.Mission;


public class managementMissionSQL {

    public static List<Mission> getAllMission() {
        List<Mission> missions = new ArrayList<>();
        String query = """
                SELECT m.idmission, m.idDemandeur, m.idBenevole, m.state, c.comment
                FROM Mission m
                LEFT JOIN Comment c ON m.idmission = c.idmission
                """;
    
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
    
        try (
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
    
            while (resultSet.next()) {
                Mission mission = new Mission(
                        resultSet.getInt("idmission"),
                        resultSet.getInt("idDemandeur"),
                        resultSet.getInt("idBenevole"),
                        resultSet.getString("state"),
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
        String query ="""
            SELECT m.idmission, m.idDemandeur, m.idBenevole, m.state, c.comment
            FROM Mission m
            LEFT JOIN Comment c ON m.idmission = c.idmission
            WHERE m.idmission = ?
            """;
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
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
                        resultSet.getString("state"),
                        resultSet.getString("comment")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mission;
    }


    public static void addMission(Mission mission) {
        String query = "INSERT INTO Mission (idmission,idDemandeur,state) VALUES (?, ?,'En Attente')";
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, mission.getIdmission()); 
            preparedStatement.setInt(2, mission.getIdDemandeur());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMission(int idMission) {
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
        String query1 = "DELETE FROM Mission WHERE idmission = ?";
        String query2 = "DELETE FROM Comment WHERE idmission = ?";
        
        try {
            try(PreparedStatement preparedStatement2 = connection.prepareStatement(query2))
            { preparedStatement2.setInt(1, idMission);
                preparedStatement2.executeUpdate();    
            }
            try(PreparedStatement preparedStatement1 = connection.prepareStatement(query1))
            { preparedStatement1.setInt(1, idMission);
                preparedStatement1.executeUpdate();
            }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


public static void assignMission(int idMission, int idBenevole) {
    String query = "UPDATE Mission SET idBenevole = ? WHERE idmission = ?";
    ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
    Connection connection = connectionManager.getConnection();
    try (
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, idBenevole);
        preparedStatement.setInt(2, idMission);
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
