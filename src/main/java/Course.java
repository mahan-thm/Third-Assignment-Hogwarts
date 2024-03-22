import Acounts.StudentAccount;
import Acounts.TeacherAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class Course {


    private static ArrayList<String> courseList = new ArrayList<String>();
    //    private static HashMap<String, HashMap<String, UUID>> teacher_courseUuidHashMap = new HashMap<String, HashMap<String, UUID>>(); //<teacher username, list of courses>
//    private static HashMap<UUID, ArrayList<HashMap<String, String>>> courseId_listOfDitailsHasMap = new HashMap<UUID, ArrayList<HashMap<String, String>>();
    private static HashMap<UUID, HashMap<String, Object>> courseId_detailsHashMap = new HashMap<UUID, HashMap<String, Object>>();
    //    public ArrayList<HashMap<String,String>> listOfDetailsHashMap = new ArrayList<HashMap<String,String>>();
    HashMap<String, Object> detailsHashMap = new HashMap<String, Object>();
    ArrayList<String> courseStudentsList = new ArrayList<String>();

    //setter
    public static void setAddCourseList(String newCourse) {
        courseList.add(newCourse);
    }

//    public static void setTeacher_courseUuidHashMap(TeacherAccount teacherAccount) {
//        teacher_courseUuidHashMap.put(teacherAccount.getUsername(), teacherAccount.getCourseUuidHashMap());
//    }
//
//    public static void setCourseId_listOfDitailsHasMap(UUID courseId, TeacherAccount teacherAccount) {
//        courseId_listOfDitailsHasMap.put()
//
//    }

    public void setCourseId_detailsHashMap(String courseName, String courseComment, TeacherAccount teacherAccount) {
        detailsHashMap.put("teacher_username", teacherAccount.getUsername());
        detailsHashMap.put("course_name", courseName);
        detailsHashMap.put("course_teacher", teacherAccount.getTeacherName());
        detailsHashMap.put("course_comment", courseComment);
        detailsHashMap.put("course_students", courseStudentsList);
        courseId_detailsHashMap.put(UUID.randomUUID(), detailsHashMap);
    }


    //getter
    public static ArrayList<String> getCourseList() {
        return courseList;
    }

//    public static HashMap<String, HashMap<String, UUID>> getTeacher_courseUuidHashMap() {
//        return teacher_courseUuidHashMap;
//    }

    public static HashMap<UUID, HashMap<String, Object>> getCourseId_detailsHashMap(){
        return courseId_detailsHashMap;
    }


}
