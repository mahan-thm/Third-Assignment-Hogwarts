package Acounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TeacherAccount implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;
    private String teacherName;
    private final ArrayList<String> teacherCourseList = new ArrayList<String>();




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

    public void setTeacherCourseList(String courseName) {
        teacherCourseList.add(courseName);
    }
    public void deleteCourse(String deleteCourseName){
        teacherCourseList.remove(deleteCourseName);
    }
    //___________________________GETTER______________________________
    public String getPassword()
    {
        return password;
    }
    public String getUsername(){
        return username;
    }
    public UUID getAccountID() {
        return accountID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public ArrayList<String> getTeacherCourseList() {
        return teacherCourseList;
    }

}


