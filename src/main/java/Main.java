/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */

import java.util.Scanner;


public class Main {
    public static Scanner input = new Scanner(System.in);
    Boolean acountType; //true = teacher, false = student

    public static void main(String[] args) {
        // TODO: Program starts from here
        runMenu();

    }

    public static void runMenu() {
        // TODO: Menu will be shown here...
        System.out.println("Welcome to Hogwarts!\nPlease choose your personality\n1. Teacher\n2. Student");
        int order = Integer.valueOf(input.nextLine());
        if (order == 1) {
            teacherAccountsMenu();
        }
    }

    public static void teacherAccountsMenu() {
        System.out.println("1. sign up\n2. log in");
        int order = Integer.valueOf(input.nextLine());
        if (order == 1) {                                                                                                  //new teacher account
            System.out.println("Enter your chosen username\n(Duplicated is not valid)");
            String teacherNewUsername;
            TeacherAcounts teacherAcounts = new TeacherAcounts();
            while (true) {
                teacherNewUsername = input.nextLine();
                if (TeacherAcounts.teacherUsernamePassword.containsKey(teacherNewUsername)) {
                    System.out.println("Username exists! Try again");
                } else {
                    break;
                }
            }
            teacherAcounts.setUsername(teacherNewUsername);
            System.out.println("Enter your password");
            String teacherNewPassword;
            teacherNewPassword = input.nextLine();
            teacherAcounts.setPassword(teacherNewPassword);

            teacherAcounts.newTeacherAccount();
            System.out.println("Account created successful!");
            runMenu();
        } else if (order == 2) {
            System.out.println("Enter your username");
            String teacherUsername = input.nextLine();
            while (true) {
                if (!TeacherAcounts.teacherUsernamePassword.containsKey(teacherUsername)) {
                    System.out.println("Username not found! Try again");
                } else {
                    break;
                }
            }
            System.out.println("Enter your password");
            String teacherPassword = input.nextLine();
            if (TeacherAcounts.teacherUsernamePassword.get(teacherUsername) == teacherPassword){
                System.out.println("Welcome " + teacherUsername + "!");
            }
            else {
                System.out.println("Password incorrect!");
            }
        } else {
            System.out.println("Invalid choice");
            teacherAccountsMenu();
        }

    }

    public static void signUpMenu() {
        System.out.println("Enter your username");
        Scanner input = new Scanner(System.in);
        String newUserName = input.nextLine();

    }

}
