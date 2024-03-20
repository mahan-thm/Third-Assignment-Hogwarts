package Acounts;

import java.util.UUID;

public interface AccountManagement {
    public void setUsername(String username);
    public void setPassword(String enteredPassword);
    public void setAccountID(UUID accountID);
    public boolean validatePassword(String enteredPassword);
    public void setChangedUsername(String changedUsername);
    public void setChangedPassword(String changedPassword);
    public void setNewName(String teacherName);
    public void setChangeName(String inputChangedName);
}
