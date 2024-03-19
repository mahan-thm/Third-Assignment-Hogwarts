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

    TeacherAccount teacherAccount = new TeacherAccount();

    public static HashMap<String, String> teacherUserPassHashMap = new HashMap<String, String>();
    public HashMap<UUID, TeacherAccount> uuidTeacherAccountHashMap = new HashMap<UUID, TeacherAccount>();

//
    //    public static HashMap<UUID, Teacher> teacher = new HashMap<UUID, Teacher>();


    //________________________SETTER_____________________________
    public void setTeacherUserPassHashMap() {
        teacherUserPassHashMap.put(username, password);
    }

    @Override
    public void setNewUsername(String username) {
        this.username = username;
    }

    @Override
    public void setNewPassword(String password) {
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
    public void changeUsername(String newUsername) {
        this.username = username;
    }

    @Override
    public void changePassword(String newPassword) {
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

    public void setTeacherHashMap() {
        uuidTeacherAccountHashMap.put(teacherAccount.getAccountID(), teacherAccount);
    }

    //___________________________GETTER______________________________
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
