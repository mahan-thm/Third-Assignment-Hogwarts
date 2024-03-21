package Acounts;

import java.util.ArrayList;
import java.util.UUID;

public class StudentAccount implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;
    private String studentName;
    private final ArrayList<String> studentCourseList = new ArrayList<String>();





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
    public void setName(String studentName) {
        this.studentName = studentName;
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

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<String> getStudentCourseList() {
        return studentCourseList;
    }

}
