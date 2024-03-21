import Acounts.StudentAccount;
import Acounts.TeacherAccount;

import java.util.HashMap;
import java.util.UUID;

public class UsernameID {
    public static HashMap<String, UUID> usernameUuidTeacherHashMap = new HashMap<String, UUID>();
    public static HashMap<String, UUID> usernameUuidStudentHashMap = new HashMap<String, UUID>();
    public static HashMap<UUID, TeacherAccount> uuidTeacherAccountHashMap = new HashMap<UUID, TeacherAccount>();
    public static HashMap<UUID, StudentAccount> uuidStudentAccountHashMap = new HashMap<UUID, StudentAccount>();
}
