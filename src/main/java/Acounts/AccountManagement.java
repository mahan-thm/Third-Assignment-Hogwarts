package Acounts;

import java.util.UUID;

public interface AccountManagement {
    public void setName(String teacherName);
    public void setUsername(String username);
    public void setPassword(String enteredPassword);
    public void setAccountID(UUID accountID);
    public boolean validatePassword(String enteredPassword);
}
