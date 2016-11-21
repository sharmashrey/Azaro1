package shreyas.io.weld.azaro.Model;

/**
 * Created by shreyas on 14/11/16.
 */


/**
 * This model will store the course details.
 */

public class Course {

    /**
     * How time is stored in system
     * Example:
     * Time : 8 am      Storage : 0800
     * Time : 12 pm     Storage : 1200
     * Time : 3:15 pm   Storage : 1515
     * Time : 8:55 pm   Storage : 2055 */

    private int courseId;
    private String courseName;
    private int courseTermId;
    private String courseLocation;
    private long courseStartTime;
    private long courseEndTime;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseTermId() {
        return courseTermId;
    }

    public void setCourseTermId(int courseTermId) {
        this.courseTermId = courseTermId;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public long getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(long courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public long getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(long courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

}