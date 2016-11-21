package shreyas.io.weld.azaro.Model;

/**
 * Created by shreyas on 14/11/16.
 */


/**
 * This model is used to store Project details.
 */

public class Project {

    private int projectId;
    private int projectCourseId;
    private String projectName;
    private String projectDescription;
    private long projectDueDate;
    private int projectDueTime;
    private int projectTotalPhases;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectCourseId() {
        return projectCourseId;
    }

    public void setProjectCourseId(int projectCourseId) {

        this.projectCourseId = projectCourseId;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public long getProjectDueDate() {
        return projectDueDate;
    }

    public void setProjectDueDate(long projectDueDate) {
        this.projectDueDate = projectDueDate;
    }


    public int getProjectDueTime() {
        return projectDueTime;
    }

    public void setProjectDueTime(int projectDueTime) {
        this.projectDueTime = projectDueTime;
    }


    public int getProjectTotalPhases() {
        return projectTotalPhases;
    }

    public void setProjectTotalPhases(int projectTotalPhases) {
        this.projectTotalPhases = projectTotalPhases;
    }

}