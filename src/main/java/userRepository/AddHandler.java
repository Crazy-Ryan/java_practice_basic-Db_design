package userRepository;

import entities.Student;
import entities.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddHandler {
    public static void addNewStudent(Student student) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCmd = "INSERT INTO student" +
                    "(student_name, age, gender)" +
                    "VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement);
        }
    }

    public static void addNewSubject(Subject subject) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCmd = "INSERT INTO subject" +
                    "(subject_name, teacher_id)" +
                    "VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getTeacherId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement);
        }
    }
}
