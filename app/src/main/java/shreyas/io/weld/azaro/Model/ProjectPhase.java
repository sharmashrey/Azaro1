package shreyas.io.weld.azaro.Model;

/**
 * Created by shreyas on 14/11/16.
 */

/**
 * This model will store details of project phases.
 */

public class ProjectPhase {

    private int projectId;
    private int courseId;
    private int projectPhaseId;
    private String projectphaseName;
    private long projectPhaseDueDate;
    private int projectPhaseDueTime;
    private String projectphaseDescription;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    public int getProjectPhaseId() {
        return projectPhaseId;
    }

    public void setProjectPhaseId(int projectPhaseId) {
        this.projectPhaseId = projectPhaseId;
    }

    public String getProjectphaseName() {
        return projectphaseName;
    }

    public void setProjectphaseName(String projectphaseName) {
        this.projectphaseName = projectphaseName;
    }

    public long getProjectPhaseDueDate() {
        return projectPhaseDueDate;
    }

    public void setProjectPhaseDueDate(long projectPhaseDueDate) {
        this.projectPhaseDueDate = projectPhaseDueDate;
    }

    public int getProjectPhaseDueTime() {
        return projectPhaseDueTime;
    }

    public void setProjectPhaseDueTime(int projectPhaseDueTime) {
        this.projectPhaseDueTime = projectPhaseDueTime;
    }

    public String getProjectphaseDescription() {
        return projectphaseDescription;
    }

    public void setProjectphaseDescription(String projectphaseDescription) {
        this.projectphaseDescription = projectphaseDescription;
    }

}