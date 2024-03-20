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


    public static void putUuidTeacherAccountHashMap(TeacherAccount teacherAccount) {
        TeacherAccount.uuidTeacherAccountHashMap.put(teacherAccount.getAccountID(), teacherAccount);
    }

    public static void putUsernameUuidHashMap(TeacherAccount teacherAccount) {
        TeacherAccount.usernameUuidHashMap.put(teacherAccount.getUsername(), teacherAccount.getAccountID());
    }

    public static void putCoursesHashMap(TeacherAccount teacherAccount) {
        Courses.courseHashMap.put(teacherAccount.getTeacherName(), teacherAccount.getTeacherCourseList());
    }

    public static void runMenu() {
        // TODO: Menu will be shown here...

        System.out.println("\033[31;1mWelcome to Hogwarts!\nPlease choose your personality.\033[0m");
        System.out.println("\033[34m1. Teacher\n2. Student\n3. Exit\033[0m");
        while (true) {
            String order = input.nextLine();
            if (Objects.equals(order, "1")) {
                teacherAccountMenu();
            } else if (Objects.equals(order, "2")) {

            } else if (Objects.equals(order, "3")) {
                break;
            } else {
                System.out.println("\033[34mInvalid choice!\033[0m");
            }
        }

    }

    public static void teacherAccountMenu() {
        System.out.println("\033[31;1mTeacher menu:\033[0m");
        System.out.println("\033[34m1. Sign up\n2. Log in\n3. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            //____________________________CREATING ACCOUNT____________________________
            if (Objects.equals(order, "1")) {
                //take name
                TeacherAccount teacherAccount = new TeacherAccount();
                System.out.println("\033[34mEnter your name and your family name completely.\033[0m");
                String teacherName = input.nextLine();
                teacherAccount.setName(teacherName);

                //take username
                System.out.println("\033[34mEnter your chosen username.\nNOTE : Duplication is not alowed.\033[0m");
                String teacherNewUsername;
                while (true) {
                    teacherNewUsername = input.nextLine();
                    if (TeacherAccount.usernameUuidHashMap.containsKey(teacherNewUsername)) {
                        System.out.println("\033[34mUsername exists! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                teacherAccount.setUsername(teacherNewUsername);

                //take password
                System.out.println("\033[34mEnter your password.\033[0m");
                String teacherNewPassword;
                teacherNewPassword = input.nextLine();
                teacherAccount.setPassword(teacherNewPassword);

                //take id
                teacherAccount.setAccountID(UUID.randomUUID());

                //put to HashMap
                putUsernameUuidHashMap(teacherAccount);
                putUuidTeacherAccountHashMap(teacherAccount);

                System.out.println("\033[32mAccount created successful!\033[0m");
                runMenu();

                //____________________________LOGGING IN____________________________
            } else if (Objects.equals(order, "2")) {
                //TAKING USERNAME
                System.out.println("\033[31;1mLog in to acount:\033[0m");
                TeacherAccount teacherAccount = new TeacherAccount();
                System.out.println("\033[34mEnter your username.\033[0m");
                String teacherUsername;
                while (true) {
                    teacherUsername = input.nextLine();
                    if (!TeacherAccount.usernameUuidHashMap.containsKey(teacherUsername)) {
                        System.out.println("\033[34mUsername not found! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                teacherAccount = TeacherAccount.uuidTeacherAccountHashMap.get(TeacherAccount.usernameUuidHashMap.get(teacherUsername));
                //TAKING PASS
                System.out.println("\033[34mEnter your password.\033[0m");
                while (true) {
                    String teacherPassword = input.nextLine();
                    if (Objects.equals(TeacherAccount.uuidTeacherAccountHashMap.get(TeacherAccount.usernameUuidHashMap.get(teacherUsername)).getPassword(), teacherPassword)) {
                        break;
                    } else {
                        System.out.println("\033[34mPassword incorrect! Try again\033[0m"); /////////////////////////////////////creat back click
                    }
                }
                System.out.println("\033[31;1m" + "Welcome " + teacherAccount.getTeacherName() + "!" + "\033[0m");
                teacherLoggedInMenu(teacherAccount);
            } else if (Objects.equals(order, "3")) {
                break;
            } else {
                System.out.println("\033[34mInvalid choice\033[0m");
            }
        }
        runMenu();

    }

    public static void teacherLoggedInMenu(TeacherAccount teacherAccount) {
        System.out.println("\033[34m1. Set courses\n2. View courses list\n3. View course's list of students\n4. Score students\n5. Teacher poll score\n6. Account settings\n7. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            if (Objects.equals(order, "1")) {
                takeCoursesMenu(teacherAccount);
                break;
            } else if (Objects.equals(order, "2")) {
                viewCoursesListMenu(teacherAccount);
                break;
            } else if (Objects.equals(order, "3")) {

            } else if (Objects.equals(order, "4")) {

            } else if (Objects.equals(order, "5")) {

            } else if (Objects.equals(order, "6")) {
                accountSettings(teacherAccount);
                break;
            } else if (Objects.equals(order, "7")) {
                teacherAccountMenu();
                break;
            } else {
                System.out.println("\033[34mInvalid choice\033[0m");
            }
        }

    }

    public static void accountSettings(TeacherAccount teacherAccount) {
        System.out.println("\033[31;1mWaht do you want to do eith your account?\033[0m");
        System.out.println("\033[34m1. Change name\n2. Change username\n3. Change password\n4. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            if (Objects.equals(order, "1")) {
                System.out.println("\033[34mEnter your new name\033[0m");
                String newName = input.nextLine();
                teacherAccount.setName(newName);
                System.out.println("\033[32mName changed succesfully!\033[0m");
            } else if (Objects.equals(order, "2")) {
                System.out.println("\033[34mEnter your new username.\nNOTE : Duplication is not alowed.\033[0m");
                String newUsername;
                while (true) {
                    newUsername = input.nextLine();
                    if (TeacherAccount.usernameUuidHashMap.containsKey(newUsername)) {
                        System.out.println("\033[34mUsername exists! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                UUID idCopy = teacherAccount.getAccountID();
                TeacherAccount.usernameUuidHashMap.remove(teacherAccount.getUsername());
                teacherAccount.setUsername(newUsername);
                TeacherAccount.usernameUuidHashMap.put(teacherAccount.getUsername(), idCopy);
                System.out.println("\033[32mUsername changed succesfully!\033[0m");
            } else if (Objects.equals(order, "3")) {
                System.out.println("\033[34mEnter your new password\033[0m");
                String newPassword = input.nextLine();
                teacherAccount.setPassword(newPassword);
                System.out.println("\033[32mPassword changed succesfully!\033[0m");

            } else if (Objects.equals(order, "4")) {
                teacherLoggedInMenu(teacherAccount);
                break;
            } else {
                System.out.println("\033[34mInvalid choice\033[0m");
            }
        }
    }

    public static void viewCoursesListMenu(TeacherAccount teacherAccount) {
        System.out.println("\033[31;1mThis is the courses you set.\033[0m");
        System.out.println("\033[31mNOTE : You can remove a course by entering its name or get back to menu by entering the num '0'.\033[0m");
        System.out.println("\n" + teacherAccount.getTeacherCourseList());

        while (true) {
            String deleteCourseName = input.nextLine();
            if (Objects.equals(deleteCourseName, "0")) {
                break;
            }
            if (teacherAccount.getTeacherCourseList().contains(deleteCourseName)) {
                teacherAccount.deleteCourse(deleteCourseName);
                System.out.println("\033[32mCourse removed successfuly.\033[0m");
            } else {
                System.out.println("\033[34mThere is no course with tis name! Try again.\033[0m");
            }
        }
        teacherLoggedInMenu(teacherAccount);
    }

    public static void takeCoursesMenu(TeacherAccount teacherAccount) {
        System.out.println("\033[31;1mType the course you want to present.\033[0m");
        System.out.println("\033[31mNOTE 1 : You can register the course by pressing enter.");
        System.out.println("NOTE 2 : You can confirm and get back to menu by entering the num '0'.\033[0m");
        while (true) {
            String courseName = input.nextLine();

            if (Objects.equals(courseName, "0")) {
                break;
            }
            teacherAccount.setTeacherCourseList(courseName);
        }
        teacherLoggedInMenu(teacherAccount);

    }

    public static void viewCourseListMenu() {
        TeacherAccount teacherAccount = new TeacherAccount();
        System.out.println("This is the courses you chose to present.");
        System.out.println(teacherAccount.getTeacherCourseList());

    }

    public static void signUpMenu() {
        System.out.println("Enter your username");
        Scanner input = new Scanner(System.in);
        String newUserName = input.nextLine();

    }

}
