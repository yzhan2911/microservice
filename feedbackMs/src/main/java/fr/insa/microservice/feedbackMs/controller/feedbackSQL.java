package fr.insa.microservice.feedbackMs.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.microservice.feedbackMs.model.ConnectionJavaMySQL;

@RestController
@RequestMapping("/feedback")
public class feedbackSQL {


    public static void valideMission(int idMission) {
        String query = "UPDATE Feedback SET status = 'Validée' WHERE idMission = ?";
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query))  {

            preparedStatement.setInt(1, idMission);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void refuseMission(int idMission,String comment) {
        String query = "UPDATE Feedback SET status = 'Refusée', comment = ? WHERE idMission = ?";
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
      try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, comment); 
            preparedStatement.setInt(2, idMission);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void setAvis(int idMission,String comment) {
        String query = "UPDATE Feedback SET status = 'Réalisée', comment = ? WHERE idMission = ?";
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
      try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, comment); 
            preparedStatement.setInt(2, idMission);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
