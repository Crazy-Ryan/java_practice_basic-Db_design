package userInterface;

import entities.Student;
import entities.User;
import userRepository.QueryHandler;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
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
        List<Student> allStudents = QueryHandler.getAllStudents();
        for (Student student : allStudents) {
            System.out.println("学号：" + student.getId() +
                    "，姓名： " + student.getName() +
                    ", 年龄： " + student.getAge() +
                    ", 性别： " + student.getGender());
        }
    }
}
