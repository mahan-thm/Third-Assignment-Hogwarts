/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */

import Acounts.StudentAccount;
import Acounts.TeacherAccount;

import java.util.*;


public class Main {
    public static Scanner input = new Scanner(System.in);
    Boolean acountType; //true = teacher, false = student

    public static void main(String[] args) {
        // TODO: Program starts from here
        runMenu();

    }


    public static void putUuidTeacherAccountHashMap(TeacherAccount teacherAccount) {
        UsernameID.uuidTeacherAccountHashMap.put(teacherAccount.getAccountID(), teacherAccount);
    }

    public static void putUuidStudentAccountHashMap(StudentAccount studentAccount) {
        UsernameID.uuidStudentAccountHashMap.put(studentAccount.getAccountID(), studentAccount);
    }

    public static void putUsernameUuidTeacherHashMap(TeacherAccount teacherAccount) {
        UsernameID.usernameUuidTeacherHashMap.put(teacherAccount.getUsername(), teacherAccount.getAccountID());
    }

    public static void putUsernameUuidStudentHashMap(StudentAccount studentAccount) {
        UsernameID.usernameUuidStudentHashMap.put(studentAccount.getUsername(), studentAccount.getAccountID());
    }


    public static void runMenu() {
        // TODO: Menu will be shown here...

        System.out.println("\033[31;1mWelcome to Hogwarts!\nPlease choose your personality.\033[0m");
        System.out.println("\033[34m1. Teacher\n2. Student\n3. Admin\n4. Exit\033[0m");
        while (true) {
            String order = input.nextLine();
            if (Objects.equals(order, "1")) {
                teacherAccountMenu();
                break;
            } else if (Objects.equals(order, "2")) {
                studentAccountMenu();
                break;
            } else if (Objects.equals(order, "3")) {
                adminMenu();
                break;
            } else if (Objects.equals(order, "4")) {
                break;
            } else {
                System.out.println("\033[34mInvalid choice!\033[0m");
            }
        }

    }

    //{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{ REFERS TO ADMIN }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
    public static void adminMenu() {
        System.out.println("\033[31;1mEnter the password To access the adminstration panel.\033[0m");
        String pass = input.nextLine();
        Admin admin = new Admin();
        if (!Objects.equals(pass, admin.getEnteryPasswoed())) {
            System.out.println("\033[31;1mWRONG PASSWORD. ACCESS DENIED!\033[0m");
            runMenu();
        }
        adminLoginMenu();


    }

    public static void adminLoginMenu() {
        System.out.println("\033[31;1mWELCOME!\033[0m");
        System.out.println("\033[34m1. Remove a teacher/student\n2. View courses and their list of students\n3. Check student/teacher profile\n4. Create a course\n5. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            if (Objects.equals(order, "1")) {
                removeAcountMenu();
            } else if (Objects.equals(order, "2")) {

            } else if (Objects.equals(order, "3")) {

            } else if (Objects.equals(order, "4")) {
                creatCourseMenu();
                break;
            } else if (Objects.equals(order, "5")) {
                runMenu();
                break;
            } else {
                System.out.println("\033[34mInvalid choice\033[0m");
            }
        }
    }

    public static void removeAcountMenu() {
        System.out.println("\033[31;1mThese are the signed up accounts:\033[0m");
        System.out.println("\033[31mNOTE : You can remove an account by entering its ID or get back to menu by entering the num '0'.\033[0m");

        System.out.println("\033[34;1mTeacher Acounts:\033[0m");
        for (UUID key : UsernameID.uuidTeacherAccountHashMap.keySet()) {
            TeacherAccount teacherAccount = UsernameID.uuidTeacherAccountHashMap.get(key);
            System.out.println("\033[34m" + teacherAccount.getUsername() + "\033[0m     " +
                    "\033[34;1m" + teacherAccount.getTeacherName() + "\033[0m     " +
                    "\033[34m" + key + "\033[0m");
        }
        System.out.println("\033[34;1mStudent Acounts:\033[0m");
        for (UUID key : UsernameID.uuidStudentAccountHashMap.keySet()) {
            StudentAccount studentAccount = UsernameID.uuidStudentAccountHashMap.get(key);
            System.out.println("\033[34m" + studentAccount.getUsername() + "\033[0m     " +
                    "\033[34;1m" + studentAccount.getStudentName() + "\033[0m     " +
                    "\033[34m" + key + "\033[0m");
        }

        while (true) {
            String deleteAccountId = input.nextLine();
            if (Objects.equals(deleteAccountId, "0")) {
                break;
            }
            if (UsernameID.uuidTeacherAccountHashMap.containsKey(UUID.fromString(deleteAccountId))) {
                UsernameID.usernameUuidTeacherHashMap.remove(UsernameID.uuidTeacherAccountHashMap.get(UUID.fromString(deleteAccountId)).getUsername());
                UsernameID.uuidTeacherAccountHashMap.remove(UUID.fromString(deleteAccountId));
                System.out.println("\033[32mAccount removed successfuly.\033[0m");
            } else if (UsernameID.uuidStudentAccountHashMap.containsKey(UUID.fromString(deleteAccountId))) {
                UsernameID.usernameUuidStudentHashMap.remove(UsernameID.uuidStudentAccountHashMap.get(UUID.fromString(deleteAccountId)).getUsername());
                UsernameID.uuidStudentAccountHashMap.remove(UUID.fromString(deleteAccountId));
                System.out.println("\033[32mAccount removed successfuly.\033[0m");
            } else {
                System.out.println("\033[34mThere is no account with tis ID! Try again.\033[0m");
            }
        }
        adminLoginMenu();
    }

    public static void creatCourseMenu() {
        System.out.println("\033[31;1mType the course you want to add.\033[0m");
        System.out.println("\033[31mNOTE 1 : You can register the course by pressing enter.");
        System.out.println("NOTE 2 : You can confirm and get back to menu by entering the num '0'.\033[0m");
        String newCourseName;
        while (true) {
            newCourseName = input.nextLine();
            if (Objects.equals(newCourseName, "0")) {
                break;
            }
            if (Course.getCourseList().contains(newCourseName)) {
                System.out.println("\033[34mThis course exists!\033[0m");
                continue;
            }
            Course.setAddCourseList(newCourseName);
        }
        adminLoginMenu();
    }

    //{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{ REFERS TO STUDENT }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
    public static void studentAccountMenu() {
        System.out.println("\033[31;1mStudent menu:\033[0m");
        System.out.println("\033[34m1. Sign up\n2. Log in\n3. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            //_________________CREATING ACCOUNT__________________
            if (Objects.equals(order, "1")) {
                System.out.println("\033[31;1mSign up:\033[0m");
                //take name
                StudentAccount studentAccount = new StudentAccount();
                System.out.println("\033[34mEnter your name and your family name completely.\033[0m");
                String studentName = input.nextLine();
                studentAccount.setName(studentName);

                //take username
                System.out.println("\033[34mEnter your chosen username.\nNOTE 1 : Duplication is not alowed!\nNOTE 2 : Username named \"0\" not allowed!\033[0m");
                String studentNewUsername;
                while (true) {
                    studentNewUsername = input.nextLine();
                    if (Objects.equals(studentNewUsername, "0")) {
                        System.out.println("\033[34mInvalid username\033[0m");
                    } else if (UsernameID.usernameUuidTeacherHashMap.containsKey(studentNewUsername)) {
                        System.out.println("\033[34mUsername exists! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                studentAccount.setUsername(studentNewUsername);

                //take password
                System.out.println("\033[34mEnter your password.\nNOTE 2 : Password \"0\" not allowed!\033[0m");
                String studentNewPassword;
                while (true) {
                    studentNewPassword = input.nextLine();
                    if (Objects.equals(studentNewPassword, "0")) {
                        System.out.println("\033[34mInvalid password\033[0m");

                    } else {
                        break;
                    }
                }
                studentAccount.setPassword(studentNewPassword);

                //take id
                studentAccount.setAccountID(UUID.randomUUID());

                //put to HashMap
                putUsernameUuidStudentHashMap(studentAccount);
                putUuidStudentAccountHashMap(studentAccount);

                System.out.println("\033[32mAccount created successful!\033[0m");
                runMenu();

                //___________________LOGGING IN__________________
            } else if (Objects.equals(order, "2")) {
                //TAKING USERNAME
                System.out.println("\033[31;1mLog in:\033[0m");
                System.out.println("\033[31mNOTE : In any stage you can get to menu by entering the num '0'.\033[0m");
                StudentAccount studentAccount = new StudentAccount();
                System.out.println("\033[34mEnter your username.\033[0m");
                String studentUsername;
                while (true) {
                    studentUsername = input.nextLine();
                    if (Objects.equals(studentUsername, "0")) {
                        studentAccountMenu();
                        break;
                    } else if (!UsernameID.usernameUuidStudentHashMap.containsKey(studentUsername)) {
                        System.out.println("\033[34mUsername not found! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                studentAccount = UsernameID.uuidStudentAccountHashMap.get(UsernameID.usernameUuidStudentHashMap.get(studentUsername));
                //TAKING PASS
                System.out.println("\033[34mEnter your password.\033[0m");
                while (true) {
                    String studentPassword = input.nextLine();
                    if (Objects.equals(studentUsername, "0")) {
                        studentAccountMenu();
                        break;
                    } else if (Objects.equals(UsernameID.uuidStudentAccountHashMap.get(UsernameID.usernameUuidStudentHashMap.get(studentUsername)).getPassword(), studentPassword)) {
                        break;
                    } else {
                        System.out.println("\033[34mPassword incorrect! Try again\033[0m");
                    }
                }
                System.out.println("\033[31;1m" + "Welcome " + studentAccount.getStudentName() + "!" + "\033[0m");
                studentLoggedInMenu(studentAccount);
            } else if (Objects.equals(order, "3")) {
                break;
            } else {
                System.out.println("\033[34mInvalid choice\033[0m");
            }
        }

        runMenu();

    }

    public static void studentLoggedInMenu(StudentAccount studentAccount) {
        System.out.println("\033[34m1. Take course\n2. View courses list\n3. Score teacher\n4. Account settings\n5. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            if (Objects.equals(order, "1")) {
                takeCourseStudentMenu(studentAccount);

                break;
            } else if (Objects.equals(order, "2")) {
                viewStudentCoursesListMenu(studentAccount);
                break;
            } else if (Objects.equals(order, "3")) {

            } else if (Objects.equals(order, "4")) {

            } else if (Objects.equals(order, "5")) {
                runMenu();
                break;
            } else {
                System.out.println("\033[34mInvalid choice\033[0m");
            }
        }
    }

    public static void viewStudentCoursesListMenu(StudentAccount studentAccount) {
        System.out.println("\033[31;1mThere are the courses you have taken.\033[0m");
        System.out.println("\033[31mNOTE : You can remove a course by entering its ID or get back to menu by entering the num '0'.\033[0m");

        for (int i = 0; i < studentAccount.getStudentCourseIdList().size(); i++) {
            UUID courseId = studentAccount.getStudentCourseIdList().get(i);
            Object courseName = Course.getCourseId_detailsHashMap().get(courseId).get("course_name");
            Object teacherUsername = Course.getCourseId_detailsHashMap().get(courseId).get("teacher_username");
            Object courseComment = Course.getCourseId_detailsHashMap().get(courseId).get("course_comment");

            System.out.println("\033[41;34;1m" + courseName + "\033[0m     " +
                    "\033[34;1m" + courseComment + "\033[0m     " +
                    "\033[34m" + courseId + "\033[0m");
        }
        while (true) {
            String deleteCourseId = input.nextLine();
            if (Objects.equals(deleteCourseId, "0")) {
                break;
            }
            if (studentAccount.getStudentCourseIdList().contains(UUID.fromString(deleteCourseId))) {
                studentAccount.getStudentCourseIdList().remove(UUID.fromString(deleteCourseId));
                Arrays.asList(Course.getCourseId_detailsHashMap().get(UUID.fromString(deleteCourseId)).get("course_students")).remove(studentAccount.getStudentName());
                System.out.println("\033[32mCourse removed successfuly.\033[0m");
            } else {
                System.out.println("\033[34mThere is no course with tis ID! Try again.\033[0m");
            }
        }
    }


    public static void takeCourseStudentMenu(StudentAccount studentAccount) {
        System.out.println("\033[31;1mThere are the courses you can take.\n1mType the course ID that you want to take.\033[0m");
        System.out.println("\033[31mNOTE 1 : You can register the course by pressing enter.");
        System.out.println("NOTE 2 : You can confirm and get back to menu by entering the num '0'.\033[0m");

//        ArrayList<String> courseIdList = new ArrayList<String>();
        for (UUID key : Course.getCourseId_detailsHashMap().keySet()) {

            Object teacherName = Course.getCourseId_detailsHashMap().get(key).get("course_name");
            Object courseName = Course.getCourseId_detailsHashMap().get(key).get("course_name");
            Object courseComment = Course.getCourseId_detailsHashMap().get(key).get("course_comment");

            System.out.println("\033[41;34;1m" + courseName + " >>>>> " + teacherName + "\033[0m     " +
                    "\033[34;1m" + courseComment + "\033[0m     " +
                    "\033[34m" + key + "\033[0m");

        }
        while (true) {
            String takenCourseId = input.nextLine();
            if (Objects.equals(takenCourseId, "0")) {
                break;
            }
            if (Course.getCourseId_detailsHashMap().containsKey(UUID.fromString(takenCourseId))) {
                Arrays.asList(Course.getCourseId_detailsHashMap().get(UUID.fromString(takenCourseId)).get("course_students")).add(studentAccount.getStudentName());
                studentAccount.setStudentCourseIdList(UUID.fromString(takenCourseId));
                System.out.println("\033[32mCourse took successfuly.\033[0m");
            } else {
                System.out.println("\033[34mThere is no course with tis ID! Try again.\033[0m");
            }
        }
    }

    //{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{ REFERS TO TEACHER }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
    public static void teacherAccountMenu() {
        System.out.println("\033[31;1mTeacher menu:\033[0m");
        System.out.println("\033[34m1. Sign up\n2. Log in\n3. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            //____________________________CREATING ACCOUNT____________________________
            if (Objects.equals(order, "1")) {
                System.out.println("\033[31;1mSign up:\033[0m");
                //take name
                TeacherAccount teacherAccount = new TeacherAccount();
                System.out.println("\033[34mEnter your name and your family name completely.\033[0m");
                String teacherName = input.nextLine();
                teacherAccount.setName(teacherName);

                //take username
                System.out.println("\033[34mEnter your chosen username.\nNOTE 1 : Duplication is not alowed!\nNOTE 2 : Username named \"0\" not allowed!\033[0m");
                String teacherNewUsername;
                while (true) {
                    teacherNewUsername = input.nextLine();
                    if (Objects.equals(teacherNewUsername, "0")) {
                        System.out.println("\033[34mInvalid username\033[0m");
                    } else if (UsernameID.usernameUuidTeacherHashMap.containsKey(teacherNewUsername)) {
                        System.out.println("\033[34mUsername exists! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                teacherAccount.setUsername(teacherNewUsername);

                //take password
                System.out.println("\033[34mEnter your password.\033[0m");
                String teacherNewPassword;
                while (true) {
                    teacherNewPassword = input.nextLine();
                    if (Objects.equals(teacherNewPassword, "0")) {
                        System.out.println("\033[34mInvalid password\033[0m");

                    } else {
                        break;
                    }
                }
                teacherAccount.setPassword(teacherNewPassword);

                //take id
                teacherAccount.setAccountID(UUID.randomUUID());

                //put to HashMap
                putUsernameUuidTeacherHashMap(teacherAccount);
                putUuidTeacherAccountHashMap(teacherAccount);

                System.out.println("\033[32mAccount created successful!\033[0m");
                runMenu();

                //____________________________LOGGING IN____________________________
            } else if (Objects.equals(order, "2")) {
                //TAKING USERNAME
                System.out.println("\033[31;1mLog in:\033[0m");
                System.out.println("\033[31mNOTE : In any stage you can get to menu by entering the num '0'.\033[0m");
                TeacherAccount teacherAccount = new TeacherAccount();
                System.out.println("\033[34mEnter username.\033[0m");
                String teacherUsername;
                while (true) {
                    teacherUsername = input.nextLine();
                    if (Objects.equals(teacherUsername, "0")) {
                        teacherAccountMenu();
                        break;
                    } else if (!UsernameID.usernameUuidTeacherHashMap.containsKey(teacherUsername)) {
                        System.out.println("\033[34mUsername not found! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                teacherAccount = UsernameID.uuidTeacherAccountHashMap.get(UsernameID.usernameUuidTeacherHashMap.get(teacherUsername));
                //TAKING PASS
                System.out.println("\033[34mEnter password.\033[0m");
                while (true) {
                    String teacherPassword = input.nextLine();
                    if (Objects.equals(teacherUsername, "0")) {
                        teacherAccountMenu();
                        break;
                    } else if (Objects.equals(UsernameID.uuidTeacherAccountHashMap.get(UsernameID.usernameUuidTeacherHashMap.get(teacherUsername)).getPassword(), teacherPassword)) {
                        break;
                    } else {
                        System.out.println("\033[34mPassword incorrect! Try again\033[0m");
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
        System.out.println("\033[34m1. Set course\n2. View courses list\n3. View course's list of students\n4. Score students\n5. Teacher poll score\n6. Account settings\n7. Back\033[0m");
        while (true) {
            String order = input.nextLine();
            if (Objects.equals(order, "1")) {
                takeCoursesTeacherMenu(teacherAccount);
                break;
            } else if (Objects.equals(order, "2")) {
                viewTeacherCoursesListMenu(teacherAccount);
                break;
            } else if (Objects.equals(order, "3")) {

            } else if (Objects.equals(order, "4")) {

            } else if (Objects.equals(order, "5")) {

            } else if (Objects.equals(order, "6")) {
                accountSettingsMenu(teacherAccount);
                break;
            } else if (Objects.equals(order, "7")) {
                runMenu();
                break;
            } else {
                System.out.println("\033[34mInvalid choice\033[0m");
            }
        }

    }

    public static void accountSettingsMenu(TeacherAccount teacherAccount) {
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
                    if (UsernameID.usernameUuidTeacherHashMap.containsKey(newUsername)) {
                        System.out.println("\033[34mUsername exists! Try again.\033[0m");
                    } else {
                        break;
                    }
                }
                UUID idCopy = teacherAccount.getAccountID();
                UsernameID.usernameUuidTeacherHashMap.remove(teacherAccount.getUsername());
                teacherAccount.setUsername(newUsername);
                UsernameID.usernameUuidTeacherHashMap.put(teacherAccount.getUsername(), idCopy);
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

    public static void viewTeacherCoursesListMenu(TeacherAccount teacherAccount) {
        System.out.println("\033[31;1mThere are the courses you set.\033[0m");
        System.out.println("\033[31mNOTE : You can remove a course by entering its ID or get back to menu by entering the num '0'.\033[0m");
//        System.out.println("\n" + teacherAccount.getCourseUuidHashMap().keySet());

        for (UUID key : Course.getCourseId_detailsHashMap().keySet()) {
            Object teacherUsername = Course.getCourseId_detailsHashMap().get(key).get("teacher_username");
            Object courseName = Course.getCourseId_detailsHashMap().get(key).get("course_name");
            Object courseComment = Course.getCourseId_detailsHashMap().get(key).get("course_comment");
            if (Objects.equals(teacherUsername, teacherAccount.getUsername())) {
                System.out.println("\033[41;34;1m" + courseName + "\033[0m     " +
                        "\033[34;1m" + courseComment + "\033[0m     " +
                        "\033[34m" + key + "\033[0m");
            }
        }


        while (true) {
            String deleteCourseId = input.nextLine();
            if (Objects.equals(deleteCourseId, "0")) {
                break;
            }
            if (Course.getCourseId_detailsHashMap().containsKey(UUID.fromString(deleteCourseId))) {
                Course.getCourseId_detailsHashMap().remove(UUID.fromString(deleteCourseId));
                System.out.println("\033[32mCourse removed successfuly.\033[0m");
            } else {
                System.out.println("\033[34mThere is no course with tis ID! Try again.\033[0m");
            }
        }
//        Course.setTeacher_courseUuidHashMap(teacherAccount);
        teacherLoggedInMenu(teacherAccount);
    }

    public static void takeCoursesTeacherMenu(TeacherAccount teacherAccount) {
        Course course = new Course();
        System.out.println("\033[31;1mThere are the courses you can present.\n1mType the course you want to present.\033[0m");
        System.out.println("\033[31mNOTE 1 : You can register the course by pressing enter.");
        System.out.println("NOTE 2 : You can confirm and get back to menu by entering the num '0'.\033[0m");
        for (int i = 0; i < Course.getCourseList().size(); i++) {
            System.out.println(Course.getCourseList().get(i));
        }
        while (true) {
            String courseName = input.nextLine();

            if (Objects.equals(courseName, "0")) {
                break;
            } else if (!Course.getCourseList().contains(courseName)) {
                System.out.println("\033[34mThere is no course with tis name! Try again.\033[0m");
                continue;
            }
            System.out.println("\033[31;1mEnter any comment you want to add.\033[0m");
            System.out.println("\033[31mNOTE : if you don't want to add any comment, just press enter.\033[0m");
            String courseComment = input.nextLine();
            course.setCourseId_detailsHashMap(courseName, courseComment, teacherAccount);
        }
        System.out.println("\033[32mCourse built successfuly!\033[0m");
        teacherLoggedInMenu(teacherAccount);

    }
}
