package Acounts;

import java.util.UUID;

public interface AccountManagement {
    public void setNewUsername(String username);
    public void setNewPassword(String enteredPassword);
    public void setAccountID(UUID accountID);
    public boolean validatePassword(String enteredPassword);
    public void changeUsername(String changedUsername);
    public void changePassword(String changedPassword);
    public void setNewName(String teacherName);
    public void setChangeName(String inputChangedName);
}
