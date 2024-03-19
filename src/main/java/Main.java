/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */

import Acounts.TeacherAccount;
import Users.Teacher;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static Scanner input = new Scanner(System.in);
    Boolean acountType; //true = teacher, false = student

    public static void main(String[] args) {
        // TODO: Program starts from here
        runMenu();

    }

    public static void runMenu() {
        // TODO: Menu will be shown here...

        while (true) {
            System.out.println("Welcome to Hogwarts!\nPlease choose your personality\n1. Teacher\n2. Student\n3. Exit");
            int order = Integer.parseInt(input.nextLine());
            if (order == 1) {
                teacherAccountsMenu();
            } else if (order == 2) {

            } else if (order == 3) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }

    }

    public static void teacherAccountsMenu() {
        System.out.println("1. Sign up\n2. Log in\n3. Back");
        while (true) {
            int order = Integer.parseInt(input.nextLine());
            //____________________________CREATING ACCOUNT____________________________
            if (order == 1) {
                //take name
                System.out.println("Enter your name and your family name completely");
                String teacherName = input.nextLine();
                Teacher teacher = new Teacher();
                teacher.setNewTeacherName(teacherName);

                //take username
                System.out.println("Enter your chosen username\n(Duplicated is not valid)");
                String teacherNewUsername;
                TeacherAccount teacherAccount = new TeacherAccount();
                while (true) {
                    teacherNewUsername = input.nextLine();
                    if (TeacherAccount.teacherUserPassHashMap.containsKey(teacherNewUsername)) {
                        System.out.println("Username exists! Try again");
                    } else {
                        break;
                    }
                }

                //take password
                teacherAccount.setNewUsername(teacherNewUsername);
                System.out.println("Enter your password");
                String teacherNewPassword;
                teacherNewPassword = input.nextLine();
                teacherAccount.setNewPassword(teacherNewPassword);

                teacherAccount.setAccountID(UUID.randomUUID());
                teacherAccount.setTeacheUserPassHashMap();
                teacher.setTeacherHashMap();
                System.out.println("Account created successful!");
                runMenu();

            //____________________________LOGGING IN____________________________
            } else if (order == 2) {
                //TAKING USERNAME
                Teacher teacher = new Teacher();
                TeacherAccount teacherAccount = new TeacherAccount();
                System.out.println("Enter your username");
                String teacherUsername;
                while (true) {
                    teacherUsername = input.nextLine();
                    if (!TeacherAccount.teacherUserPassHashMap.containsKey(teacherUsername)) {
                        System.out.println("Username not found! Try again");
                    } else {
                        break;
                    }
                }
                //TAKING PASS
                System.out.println("Enter your password");
                while (true) {
                    System.out.println(teacher.teacherHashMap);
                    String teacherPassword = input.nextLine();
                    if (Objects.equals(TeacherAccount.teacherUserPassHashMap.get(teacherUsername), teacherPassword)) {
                        System.out.println("Welcome " + teacher.teacherHashMap.get(teacherAccount.getAccountID()).getTeacherName() + "!");
                        break;
                    } else {
                        System.out.println("Password incorrect! Try again"); /////////////////////////////////////creat back click
                    }
                }
                teacherLoggedInMenu();
            } else if (order == 3) {
                break;
            } else {
                System.out.println("Invalid choice");
                teacherAccountsMenu();
            }
        }
        runMenu();

    }

    public static void teacherLoggedInMenu() {
        System.out.println("1. Take courses\n2. View courses list\n3. View course's list of students\n4. Score students\n5. Teacher poll score\n6. Account settings");
        int order = Integer.parseInt(input.nextLine());
        switch (order) {
            case 1:
                takeCoursesMenu();
                break;
            case 2:

        }
    }

    public static void takeCoursesMenu() {
        Teacher teacher = new Teacher();
        System.out.println("Enter the name of course you wish to teach");
        String courseName = input.nextLine();
        teacher.setTeacherCourse(courseName);
    }

    public static void viewCourseListMenu() {
        Teacher teacher = new Teacher();
        System.out.println("This is the courses you chose to present");
        System.out.println(teacher.getTeacherCourse());

    }

    public static void signUpMenu() {
        System.out.println("Enter your username");
        Scanner input = new Scanner(System.in);
        String newUserName = input.nextLine();

    }

}
