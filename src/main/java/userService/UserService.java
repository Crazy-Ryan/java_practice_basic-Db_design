package userService;

import entities.EntityType;
import entities.Grade;
import entities.Student;
import entities.Subject;
import entities.Teacher;
import userRepository.AddHandler;
import userRepository.QueryHandler;
import userRepository.UpdateHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserService {
    public List<Student> getAllStudents() {
        return QueryHandler.getAllStudents();
    }

    public Map<EntityType, Object> getStudentGradeSubjectByStudentName(String name) {
        Map<EntityType, Object> result = new HashMap<>();
        Student studentFound = QueryHandler.getStudentByName(name);
        result.put(EntityType.STUDENT, studentFound);
        List<Grade> studentGrades = QueryHandler.getGradeByStudentId(studentFound.getId());
        result.put(EntityType.GRADE_LIST, studentGrades);
        List<Subject> studentSubjects = new ArrayList<>();
        for (Grade grade : studentGrades) {
            studentSubjects.add(QueryHandler.getSubjectById(grade.getSubjectId()));
        }
        result.put(EntityType.SUBJECT_LIST, studentSubjects);
        return result;
    }

    public Map<EntityType, Object> getStudentsByTeacherName(String name) {
        Map<EntityType, Object> result = new HashMap<>();
        Teacher teacherFound = QueryHandler.getTeacherByName(name);
        List<Subject> subjects = QueryHandler.getSubjectByTeacherId(teacherFound.getId());
        Set<Student> students = new HashSet<>();
        for (Subject subject : subjects) {
            List<Grade> gradesBySubject = QueryHandler.getGradeBySubjectId(subject.getId());
            for (Grade grade : gradesBySubject) {
                Student studentByGradeId = QueryHandler.getStudentById(grade.getStudentId());
                students.add(studentByGradeId);
            }
        }
        result.put(EntityType.TEACHER, teacherFound);
        result.put(EntityType.STUDENT_LIST, new ArrayList<>(students));
        return result;
    }

    public List<Subject> getAllSubjects() {
        return QueryHandler.getAllSubjects();
    }

    public Subject getSubjectByName(String name) {
        return QueryHandler.getSubjectByName(name);
    }

    public List<Subject> getSubjectByTeacherName(String name) {
        Teacher teacherFound = QueryHandler.getTeacherByName(name);
        return QueryHandler.getSubjectByTeacherId(teacherFound.getId());
    }

    public List<Teacher> getAllTeachers() {
        return QueryHandler.getAllTeachers();
    }

    public Teacher getTeacherByName(String name) {
        return QueryHandler.getTeacherByName(name);
    }

    public void addNewStudent(String name, int age, String gender) {
        AddHandler.addNewStudent(new Student(0, name, age, gender));
    }

    public void addNewSubject(String name, int teacherId) {
        AddHandler.addNewSubject(new Subject(0, name, teacherId));
    }

    public void updateGrade(String studentName,String subjectName,int score){
        Student student = QueryHandler.getStudentByName(studentName);
        Subject subject = QueryHandler.getSubjectByName(subjectName);
        UpdateHandler.updateGradeByStudentIdAndSubject(student.getId(),subject.getId(),score);
    }
}
