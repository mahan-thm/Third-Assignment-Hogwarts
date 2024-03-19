package Acounts;

import java.util.HashMap;
import java.util.UUID;

public class TeacherAccount implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;
    public static HashMap<String, String> teacherUserPassHashMap = new HashMap<String, String>();
//    public static HashMap<UUID, Teacher> teacher = new HashMap<UUID, Teacher>();

    public void setTeacheUserPassHashMap() {
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
    public UUID getAccountID()
    {
        return accountID;
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
