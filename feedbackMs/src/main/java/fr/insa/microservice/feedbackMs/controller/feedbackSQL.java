package fr.insa.microservice.feedbackMs.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Statement;

import fr.insa.microservice.feedbackMs.model.ConnectionJavaMySQL;
import fr.insa.microservice.feedbackMs.model.feedback;

@RestController
@RequestMapping("/feedback")
public class feedbackSQL {

    public static List<feedback> getAllComments() {
        List<feedback> feedbacks = new ArrayList<>();
        String query = """
                SELECT idmission, GROUP_CONCAT(comment SEPARATOR ', ') AS comments
                FROM Comment
                GROUP BY idmission
                """;
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
        	 while (resultSet.next()) {
                 int idMission = resultSet.getInt("idmission");
                 String comments = resultSet.getString("comments");

                 // Convert comments string into a List<String>
                 List<String> commentList = Arrays.asList(comments.split(", "));

                 // Add the feedback object
                 feedback feedback = new feedback(idMission, commentList);
                 feedbacks.add(feedback);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }


    public static void valideMission(int idMission) {
        String query = "UPDATE Mission SET state = 'Validée' WHERE idMission = ?";
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
        String updateMissionQuery = "UPDATE Mission SET state = 'Refusée' WHERE idmission = ?";
        String insertCommentQuery = "INSERT INTO Comment (idmission, comment) VALUES (?, ?)";
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
        try  {
                try (PreparedStatement updateMissionStmt = connection.prepareStatement(updateMissionQuery)) {
                    updateMissionStmt.setInt(1, idMission);
                    updateMissionStmt.executeUpdate();
                }
                try (PreparedStatement insertCommentStmt = connection.prepareStatement(insertCommentQuery)) {
                    insertCommentStmt.setInt(1, idMission);
                    insertCommentStmt.setString(2, comment);
                    insertCommentStmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public static void setAvis(int idMission,String comment) {
        String updateMissionQuery = "UPDATE Mission SET state = 'Réalisée' WHERE idmission = ?";
        String insertCommentQuery = "INSERT INTO Comment (idmission, comment) VALUES (?, ?)";
        ConnectionJavaMySQL connectionManager = new ConnectionJavaMySQL();
        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement updateMissionStmt = connection.prepareStatement(updateMissionQuery)) {
                updateMissionStmt.setInt(1, idMission);
                updateMissionStmt.executeUpdate();
            }
            try (PreparedStatement insertCommentStmt = connection.prepareStatement(insertCommentQuery)) {
                insertCommentStmt.setInt(1, idMission);
                insertCommentStmt.setString(2, comment);
                insertCommentStmt.executeUpdate();
            }
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}
