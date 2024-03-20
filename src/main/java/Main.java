/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */

import Acounts.TeacherAccount;

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


    public static void putUuidTeacherAccountHashMap(TeacherAccount teacherAccount){
        TeacherAccount.uuidTeacherAccountHashMap.put(teacherAccount.getAccountID(), teacherAccount);
    }
    public static void putUsernameUuidHashMap(TeacherAccount teacherAccount){
        TeacherAccount.usernameUuidHashMap.put(teacherAccount.getUsername(), teacherAccount.getAccountID());
    }

    public static void runMenu() {
        // TODO: Menu will be shown here...

        while (true) {
            System.out.println("Welcome to Hogwarts!\nPlease choose your personality\n1. Teacher\n2. Student\n3. Exit");
            int order = Integer.parseInt(input.nextLine());
            if (order == 1) {
                teacherAccountMenu();
            } else if (order == 2) {

            } else if (order == 3) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }

    }

    public static void teacherAccountMenu() {
        System.out.println("1. Sign up\n2. Log in\n3. Back");
        while (true) {
            int order = Integer.parseInt(input.nextLine());
            //____________________________CREATING ACCOUNT____________________________
            if (order == 1) {
                //take name
                TeacherAccount teacherAccount = new TeacherAccount();
                System.out.println("Enter your name and your family name completely");
                String teacherName = input.nextLine();
                teacherAccount.setNewName(teacherName);

                //take username
                System.out.println("Enter your chosen username\n(Duplicated is not valid)");
                String teacherNewUsername;
                while (true) {
                    teacherNewUsername = input.nextLine();
                    if (TeacherAccount.usernameUuidHashMap.containsKey(teacherNewUsername)) {
                        System.out.println("Username exists! Try again");
                    } else {
                        break;
                    }
                }
                teacherAccount.setUsername(teacherNewUsername);

                //take password
                System.out.println("Enter your password");
                String teacherNewPassword;
                teacherNewPassword = input.nextLine();
                teacherAccount.setPassword(teacherNewPassword);

                //take id
                teacherAccount.setAccountID(UUID.randomUUID());

                //put to HashMap
                putUsernameUuidHashMap(teacherAccount);
                putUuidTeacherAccountHashMap(teacherAccount);

                System.out.println("Account created successful!");
                runMenu();

                //____________________________LOGGING IN____________________________
            } else if (order == 2) {
                //TAKING USERNAME
                TeacherAccount teacherAccount = new TeacherAccount();
                System.out.println("Enter your username");
                String teacherUsername;
                while (true) {
                    teacherUsername = input.nextLine();
                    if (!TeacherAccount.usernameUuidHashMap.containsKey(teacherUsername)) {
                        System.out.println("Username not found! Try again");
                    } else {
                        break;
                    }
                }
                teacherAccount = TeacherAccount.uuidTeacherAccountHashMap.get(TeacherAccount.usernameUuidHashMap.get(teacherUsername));
                //TAKING PASS
                System.out.println("Enter your password");
                while (true) {
                    String teacherPassword = input.nextLine();
                    if (Objects.equals(TeacherAccount.uuidTeacherAccountHashMap.get(TeacherAccount.usernameUuidHashMap.get(teacherUsername)).getPassword(), teacherPassword)) {
                        System.out.println("Welcome " + teacherAccount.getTeacherName() + "!");
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
                teacherAccountMenu();
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
        TeacherAccount teacherAccount = new TeacherAccount();
        System.out.println("Enter the name of course you wish to teach");
        String courseName = input.nextLine();
        teacherAccount.setTeacherCourse(courseName);
    }

    public static void viewCourseListMenu() {
        TeacherAccount teacherAccount = new TeacherAccount();
        System.out.println("This is the courses you chose to present");
        System.out.println(teacherAccount.getTeacherCourse());

    }

    public static void signUpMenu() {
        System.out.println("Enter your username");
        Scanner input = new Scanner(System.in);
        String newUserName = input.nextLine();

    }

}
