import Acounts.StudentAccount;
import Acounts.TeacherAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Course {


    private static ArrayList<String> courseList = new ArrayList<String>();
    private static HashMap<String, HashMap<String, UUID>> teacher_courseUuidHashMap = new HashMap<String, HashMap<String, UUID>>(); //<teacher username, list of courses>
    private static HashMap<UUID, ArrayList<String>> courseId_studentsHasMap = new HashMap<UUID, ArrayList<String>>();
    //setter
    public static void setAddCourseList(String newCourse) {
        courseList.add(newCourse);
    }

    public static void setTeacher_courseUuidHashMap(TeacherAccount teacherAccount) {
        teacher_courseUuidHashMap.put(teacherAccount.getUsername(), teacherAccount.getCourseUuidHashMap());
    }

//    public static void setCourseId_studentsHasMap(UUID courseId, StudentAccount studentAccount){
//        courseId_studentsHasMap.put(courseId, studentAccount)
//    }


    //getter
    public static ArrayList<String> getCourseList() {
        return courseList;
    }
    public static HashMap<String, HashMap<String, UUID>> getTeacher_courseUuidHashMap()
    {
        return teacher_courseUuidHashMap;
    }


}
