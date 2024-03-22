package Acounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TeacherAccount implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;
    private String teacherName;
    private final HashMap<String, UUID> courseUuidHashMap = new HashMap<String, UUID>();
//    private HashMap<String, ArrayList<String>> teacherCourse_StudentsHasMap = new HashMap<String, ArrayList<String>>(); //<course name, list of students>

    //________________________SETTER_____________________________
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setAccountID(UUID accountID) {
        this.accountID = accountID;
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        return false;
    }

    @Override
    public void setName(String teacherName) {
        this.teacherName = teacherName;
    }

//    public void setCourseUuidHashMap(String courseName) {
//        courseUuidHashMap.put(courseName, UUID.randomUUID());
//    }

    public void setTeacherCourse_StudentsHasMap(UUID courseId){


    }

    public void deleteCourse(String deleteCourseName) {
        courseUuidHashMap.remove(deleteCourseName);
    }



    //___________________________GETTER______________________________
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public UUID getAccountID() {
        return accountID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public HashMap<String, UUID> getCourseUuidHashMap() {
        return courseUuidHashMap;
    }

}


