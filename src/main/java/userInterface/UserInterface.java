package userInterface;

import entities.EntityType;
import entities.Grade;
import entities.Student;
import entities.Subject;
import entities.Teacher;
import entities.User;
import userService.UserService;
import userRepository.QueryHandler;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private UserService userService = new UserService();

    public void run() {
        getAllStudents();
//        loginHandler();
    }

    private void loginHandler() {
        boolean isFinished = false;
        System.out.println("您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名,密码)：");
        while (!isFinished) {
            User loginUser = QueryHandler.getUserByNameAndPassword(loginCollector());
            if (null == loginUser.getUsername()) {
                System.out.println("密码或用户名错误");
                System.out.println("请重新输入用户名和密码：");
            } else {
                isFinished = true;
            }
        }
    }


    private String loginCollector() {
        Scanner scanner = new Scanner(System.in);
        boolean isInputFormatCorrect = false;
        String loginInput = "";
        while (!isInputFormatCorrect) {
            loginInput = scanner.nextLine();
            if (FormatCheckUtil.loginFormatCheck(loginInput)) {
                isInputFormatCorrect = true;
            } else {
                System.out.println("格式错误");
                System.out.println("请按正确格式输入用户名和密码：");
            }
        }
        return loginInput;
    }

    private void getAllStudents() {
        List<Student> allStudents = userService.getAllStudents();
        for (Student student : allStudents) {
            System.out.println("学号：" + student.getId() +
                    "，姓名： " + student.getName() +
                    ", 年龄： " + student.getAge() +
                    ", 性别： " + student.getGender());
        }
    }

    public void getStudentGradeSubjectByStudentName(String name) {
        Map<EntityType, Object> studentGradeSubject = userService.getStudentGradeSubjectByStudentName(name);
        Student student = (Student) studentGradeSubject.get(EntityType.STUDENT);
        System.out.println("学号：" + student.getId() +
                "，姓名： " + student.getName() +
                ", 年龄： " + student.getAge() +
                ", 性别： " + student.getGender());
        List<Subject> subjects = (List<Subject>) studentGradeSubject.get(EntityType.SUBJECT_LIST);
        List<Grade> grades = (List<Grade>) studentGradeSubject.get(EntityType.GRADE_LIST);
        for (int index = 0; index < subjects.size(); index++) {
            System.out.println("科目：" + subjects.get(index).getName() + "，成绩：" + grades.get(index).getScore());
        }
    }

    public void getStudentGradeSubjectByTeacherName(String name) {
        Map<EntityType, Object> teacherStudents = userService.getStudentsByTeacherName(name);
        List<Student> students = (List<Student>) teacherStudents.get(EntityType.STUDENT_LIST);
        System.out.println(name + "的所有学生信息及各学生成绩为");
        for (Student student : students) {
            getStudentGradeSubjectByStudentName(student.getName());
        }
    }

    public void getAllSubjects() {
        List<Subject> allSubjects = userService.getAllSubjects();
        for (Subject subject : allSubjects) {
            System.out.println("课程编号：" + subject.getId() +
                    "，课程名： " + subject.getName() +
                    ", 教师编号： " + subject.getTeacherId());
        }
    }

    public void getSubjectByName(String name) {
        Subject subject = userService.getSubjectByName(name);
        System.out.println("课程编号：" + subject.getId() +
                "，课程名： " + subject.getName() +
                ", 教师编号： " + subject.getTeacherId());
    }

    public void getSubjectsByTeacherName(String name) {
        List<Subject> allSubjects = userService.getSubjectByTeacherName(name);
        for (Subject subject : allSubjects) {
            System.out.println("课程编号：" + subject.getId() +
                    "，课程名： " + subject.getName() +
                    ", 教师编号： " + subject.getTeacherId());
        }
    }
}
