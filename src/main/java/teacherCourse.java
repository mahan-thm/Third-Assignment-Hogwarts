import java.util.ArrayList;
import java.util.HashMap;

public class teacherCourse {

    public HashMap<String, String> teacherCourseMap = new HashMap<String, String>();

    public void teacherCourseMapAdd(String teacherName, String courseNameList){
        teacherCourseMap.put(teacherName,courseNameList);
    }


}
