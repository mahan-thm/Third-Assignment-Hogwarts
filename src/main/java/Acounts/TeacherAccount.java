package Acounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TeacherAccount implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;
    private String teacherName;
    private ArrayList<String> teacherCourse;


//    public static HashMap<String, String> teacherUserPassHashMap = new HashMap<String, String>();
    public static HashMap<String, UUID> usernameUuidHashMap = new HashMap<String, UUID>();
    public static HashMap<UUID, TeacherAccount> uuidTeacherAccountHashMap = new HashMap<UUID, TeacherAccount>();
    //    public static HashMap<UUID, Teacher> teacher = new HashMap<UUID, Teacher>();


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
    public void setChangedUsername(String newUsername) {
        this.username = username;
    }

    @Override
    public void setChangedPassword(String newPassword) {
        this.password = password;
    }

    @Override
    public void setNewName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void setChangeName(String inputChangedName) {
        this.teacherName = inputChangedName;
    }

    public void setTeacherCourse(String inputCourseName) {
        teacherCourse.add(inputCourseName);
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

    public ArrayList<String> getTeacherCourse() {
        return teacherCourse;
    }

}


