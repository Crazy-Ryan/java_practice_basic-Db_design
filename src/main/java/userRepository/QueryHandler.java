package userRepository;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}

