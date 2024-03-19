import java.util.HashMap;
import java.util.UUID;

public class TeacherAcounts {
    private String username;
    private String password;
    private UUID accountID;
    static HashMap<String, String> teacherUsernamePassword = new HashMap<String, String>();

    public void newTeacherAccount ()
    {
        teacherUsernamePassword.put(username,password);
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setAccountID(UUID accountID)
    {
        this.accountID = UUID.randomUUID();
    }


}
