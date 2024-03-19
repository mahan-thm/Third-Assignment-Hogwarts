package Acounts;

import java.util.HashMap;
import java.util.UUID;

public class TeacherAcounts implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;
    public static HashMap<String, String> teacherUsernamePassword = new HashMap<String, String>();

    public void newTeacherAccount() {
        teacherUsernamePassword.put(username, password);
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
        this.accountID = UUID.randomUUID();
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
}
