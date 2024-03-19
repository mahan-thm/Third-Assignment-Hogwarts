package Users;

import Acounts.TeacherAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Teacher implements UserManagment {
    private String teacherName;
    private ArrayList<String> teacherCourse;

    TeacherAccount teacherAccount = new TeacherAccount();

    public HashMap<UUID, Teacher> teacherHashMap = new HashMap<UUID, Teacher>();


    @Override
    public void setNewTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void setChangeTeacherName(String inputChangedName) {
        this.teacherName = inputChangedName;
    }

    public void setTeacherCourse(String inputCourseName) {
        teacherCourse.add(inputCourseName);
    }

    public void setTeacherHashMap() {
        Teacher teacher = new Teacher();
        teacherHashMap.put(teacherAccount.getAccountID(), teacher);
    }

    public String getTeacherName() {
        return teacherName;
    }

    public ArrayList<String> getTeacherCourse() {
        return teacherCourse;
    }


}
