package userRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteHandler {
    public static void deleteStudentById(int id) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCmd = "DELETE FROM student " +
                    "WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement);
        }
    }

    public static void deleteSubjectById(int id) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCmd = "DELETE FROM subject " +
                    "WHERE subject_id = ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement);
        }
    }
    public static void deleteTeacherById(int id) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCmd = "DELETE FROM teacher " +
                    "WHERE teacher_id = ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement);
        }
    }
}
