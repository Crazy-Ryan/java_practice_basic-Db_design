package userRepository;

import entities.Student;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryHandler {
    public static User getUserByNameAndPassword(String input) {
        String[] inputEntries = input.split(",");
        String name = inputEntries[0];
        String password = inputEntries[1];
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sqlQuery = "SELECT " +
                    "user_id,username,password" +
                    " FROM user_info WHERE username = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User fetchedUser = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"));

                if (password.equals(fetchedUser.getPassword())) {
                    return fetchedUser;
                } else {
                    return new User();
                }
            } else {
                return new User();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new User();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement, resultSet);
        }
    }

    public static List<Student> getAllStudents() {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> allStudents = new ArrayList<>();
        try {
            String sqlQuery = "SELECT " +
                    "student_id,student_name,age,gender" +
                    " FROM student";
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allStudents.add(new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("student_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement, resultSet);
        }
        return allStudents;
    }
}

