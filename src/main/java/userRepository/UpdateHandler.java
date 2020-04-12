package userRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateHandler {
    public static void updateGradeByStudentIdAndSubject(int studentId, int subjectId, int score) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCmd = "UPDATE grade SET score = ? " +
                    "WHERE student_id = ? AND subject_id = ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setInt(1, score);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setInt(3, subjectId);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement);
        }
    }
}
