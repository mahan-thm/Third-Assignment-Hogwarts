import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    public static HashMap<String, ArrayList<String>> courseHashMap = new HashMap<String, ArrayList<String>>();

    private final ArrayList<String> courseLisst = new ArrayList<String>();


    public void setAddCourseList(String newCourse) {
        courseLisst.add(newCourse);
    }

    public ArrayList<String> getCourseLisst() {
        return courseLisst;
    }


}
