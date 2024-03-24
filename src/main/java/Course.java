import Acounts.StudentAccount;
import Acounts.TeacherAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class Course {


    private static ArrayList<String> courseList = new ArrayList<String>();
    public static HashMap<UUID, HashMap<String, Object>> courseId_detailsHashMap = new HashMap<UUID, HashMap<String, Object>>();
    public HashMap<String, Object> detailsHashMap = new HashMap<String, Object>();
    public ArrayList<String> courseStudentsList = new ArrayList<String>();

    //setter
    public static void setAddCourseList(String newCourse) {
        courseList.add(newCourse);
    }


    public void putCourseId_detailsHashMap(String courseName, String courseComment, TeacherAccount teacherAccount) {
        detailsHashMap.put("teacher_object", teacherAccount);
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
