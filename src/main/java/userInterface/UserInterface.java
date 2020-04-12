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

    public void getAllTeachers() {
        List<Teacher> allTeachers = userService.getAllTeachers();
        for (Teacher teacher : allTeachers) {
            System.out.println("教师编号：" + teacher.getId() +
                    "，教师姓名： " + teacher.getName());
        }
    }

    public void getTeacherByName(String name) {
        Teacher teacher = userService.getTeacherByName(name);
        System.out.println("教师编号：" + teacher.getId() +
                "，教师姓名： " + teacher.getName());
    }

    public void addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入新增学生信息（格式：姓名,年龄,性别）");
        String studentInfo = scanner.nextLine();
        String[] studentDetails = studentInfo.split(",");
        userService.addNewStudent(studentDetails[0], Integer.parseInt(studentDetails[1]), studentDetails[2]);
    }

    public void addNewSubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入新增课程信息（格式：课程名,授课教师编号）");
        String subjectInfo = scanner.nextLine();
        String[] subjectDetails = subjectInfo.split(",");
        userService.addNewSubject(subjectDetails[0], Integer.parseInt(subjectDetails[1]));
    }

    public void updateGrade() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生姓名、课程名和课程成绩（格式：学生姓名,课程名,课程成绩）");
        String inputInfo = scanner.nextLine();
        String[] inputDetails = inputInfo.split(",");
        userService.updateGrade(inputDetails[0], inputDetails[1], Integer.parseInt(inputDetails[2]));
    }

    public void deleteStudentById() {
        System.out.println("请输入您需要删除的学生学号：");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("删除学生之后，该学生信息将不能恢复，是否要继续删除？");
        System.out.println("1.是");
        System.out.println("2.否");
        int choice = scanner.nextInt();
        if(1 == choice){
            Student student = userService.deleteStudentById(id);
            System.out.println("删除学生" + student.getName() + "(学号：" + student.getId() + ")成功！");
        }
    }

}
