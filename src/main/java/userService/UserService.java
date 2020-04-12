package userService;

import entities.EntityType;
import entities.Grade;
import entities.Student;
import entities.Subject;
import userRepository.QueryHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
