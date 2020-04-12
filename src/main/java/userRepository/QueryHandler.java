package userRepository;

import entities.Grade;
import entities.Student;
import entities.Subject;
import entities.Teacher;
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

    public static Student getStudentByName(String name) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = new Student();
        try {
            String sqlQuery = "SELECT " +
                    "student_id,student_name,age,gender" +
                    " FROM student WHERE student_name = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("student_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement, resultSet);
        }
        return student;
    }

    public static List<Grade> getGradeByStudentId(int studentId) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Grade> allGrades = new ArrayList<>();
        try {
            String sqlQuery = "SELECT " +
                    "grade_id,student_id,subject_id,score" +
                    " FROM grade WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allGrades.add(new Grade(
                        resultSet.getInt("grade_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("subject_id"),
                        resultSet.getInt("score")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement, resultSet);
        }
        return allGrades;
    }

    public static Teacher getTeacherByName(String name) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Teacher teacher = new Teacher();
        try {
            String sqlQuery = "SELECT " +
                    "teacher_id,teacher_name" +
                    " FROM teacher WHERE teacher_name = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                teacher = new Teacher(
                        resultSet.getInt("teacher_id"),
                        resultSet.getString("teacher_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement, resultSet);
        }
        return teacher;
    }


    public static Subject getSubjectByName(String name) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Subject subject = new Subject();
        try {
            String sqlQuery = "SELECT " +
                    "subject_id,subject_name,teacher_id" +
                    " FROM subject WHERE subject_name = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                subject = new Subject(
                        resultSet.getInt("subject_id"),
                        resultSet.getString("subject_name"),
                        resultSet.getInt("teacher_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement, resultSet);
        }
        return subject;
    }

    public static Subject getSubjectById(int id) {
        Connection connection = DatabaseUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Subject subject = new Subject();
        try {
            String sqlQuery = "SELECT " +
                    "subject_id,subject_name,teacher_id" +
                    " FROM subject WHERE subject_id = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                subject = new Subject(
                        resultSet.getInt("subject_id"),
                        resultSet.getString("subject_name"),
                        resultSet.getInt("teacher_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.releaseSource(connection, preparedStatement, resultSet);
        }
        return subject;
    }

}

