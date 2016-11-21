package shreyas.io.weld.azaro.Database;

/* Created by shreyas on 14/11/16.
 * This class contains all table and column names for DB. */

public class DBRelatedConstants {
    // Database Version
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "StudentPlannerDB";

    // Tables in StudentPlanner Database
    public static final String TABLE_TERMS = "Terms";
    public static final String TABLE_COURSES = "Courses";
    public static final String TABLE_TASKS = "Tasks";
    public static final String TABLE_TASK_ATTACHMENTS = "Task_Attachments";
    public static final String TABLE_ASSIGNMENTS = "Assignments";
    public static final String TABLE_ASSIGNMENT_ATTACHMENTS = "Assignment_Attachments";
    public static final String TABLE_PROJECTS = "Projects";
    public static final String TABLE_PROJECT_PHASES = "Project_Phases";
    public static final String TABLE_PROJECT_PHASES_ATTACHMENTS = "Project_Phase_Attachments";

    // Columns for Terms table
    public static final String TERM_TERMID = "term_id";
    public static final String TERM_TERMNAME = "term_name";
    public static final String TERM_TERMSTARTDATE = "term_start_date";
    public static final String TERM_TERMENDDATE = "term_end_date";

    // Columns for Courses table
    public static final String COURSE_ID = "course_id";
    public static final String COURSE_COURSENAME = "course_name";
    public static final String COURSE_TERMID = "course_term_id";
    public static final String COURSE_COURSELOCATION = "course_location";
    public static final String COURSE_COURSESTARTTIME = "course_start_time";
    public static final String COURSE_COURSEENDTIME = "course_end_time";

    //Columns for Tasks table
    public static final String TASK_TASKID = "task_id";
    public static final String TASK_TASKCOURSEID = "task_course_id";
    public static final String TASK_TASKNAME = "task_name";
    public static final String TASK_TASKDESCRIPTION = "task_description";
    public static final String TASK_TASKDUEDATE = "task_due_date";
    public static final String TASK_TASKDUETIME = "task_due_time";
    public static final String TASK_TYPE = "task_type";

    // Columns for Task_Attachments table
    public static final String TASKATTACHMENT_ATTACHMENTID = "task_attachment_id";
    public static final String TASKATTACHMENT_TASKID = "task_id";
    public static final String TASKATTACHMENT_ATTACHMENTLINK = "task_attachment_link";
    public static final String TASKATTACHMENT_ATTACHMENTTYPE = "task_attachment_type";

    //Columns for Assignments table
    public static final String ASSIGNMENT_ASSIGNMENTID = "assignmment_id";
    public static final String ASSIGNMENT_ASSIGNMENTCOURSEID = "assignment_course_id";
    public static final String ASSIGNMENT_ASSIGNMENTNAME = "assignment_name";
    public static final String ASSIGNMENT_ASSIGNMENTDESCRIPTION = "assignment_description";
    public static final String ASSIGNMENT_ASSIGNMENTDUEDATE = "assignment_due_date";
    public static final String ASSIGNMENT_ASSIGNMENTDUETIME = "assignment_due_time";

    // Columns for Assignment_Attachments table
    public static final String ASSIGNMENTATTACHMENT_ATTACHMENTID = "assignment_attachment_id";
    public static final String ASSIGNMENTATTACHMENT_ASSIGNMENTID = "assignment_id";
    public static final String ASSIGNMENTATTACHMENT_ATTACHMENTLINK = "assignment_attachment_link";
    public static final String ASSIGNMENTATTACHMENT_ATTACHMENTTYPE = "assignment_attachment_type";

    // Columns for Projects table
    public static final String PROJECT_PROJECTID = "project_id";
    public static final String PROJECT_PROJECTCOURSEID = "project_course_id";
    public static final String PROJECT_PROJECTNAME = "project_name";
    public static final String PROJECT_PROJECTDESCRIPTION = "project_description";
    public static final String PROJECT_PROJECTDUEDATE = "project_due_date";
    public static final String PROJECT_PROJECTDUETIME = "project_due_time";
    public static final String PROJECT_PROJECTTOTALPHASES = "project_total_phases";

    //Columns for Project_Phases table
    public static final String PROJECTPHASES_PROJECTPHASEID = "projectphase_id";
    public static final String PROJECTPHASES_PROJECTID = "projectphase_project_id";
    public static final String PROJECTPHASES_COURSEID = "projectphase_course_id";
    public static final String PROJECTPHASES_PROJECTPHASENAME = "projectphase_name";
    public static final String PROJECTPHASES_PROJECTPHASEDESCRIPTION = "projectphase_description";
    public static final String PROJECTPHASES_PROJECTPHASEDUEDATE = "projectphase_due_date";
    public static final String PROJECTPHASE_PROJECTPHASEDUETIME = "projectphase_due_time";

    // Columns for Assignment_Attachments table
    public static final String PROJECTPHASESATTACHMENT_ATTACHMENTID = "projectphase_attachment_id";
    public static final String PROJECTPHASESATTACHMENT_PROJECTID = "ppa_project_id";
    public static final String PROJECTPHASESATTACHMENT_POJECTPHASEID = "ppa_projectphase_id";
    public static final String PROJECTPHASESATTACHMENT_ATTACHMENTLINK = "projectphase_attachment_link";
    public static final String PROJECTPHASESATTACHMENT_ATTACHMENTTYPE = "projectphase_attachment_type";

    // Term table create statement
    public static final String CREATE_TABLE_TERMS = "CREATE TABLE " + TABLE_TERMS + "( "
            + TERM_TERMID + " INTEGER PRIMARY KEY,"
            + TERM_TERMNAME + " TEXT,"
            + TERM_TERMSTARTDATE + " INTEGER,"
            + TERM_TERMENDDATE + " INTEGER"
            + ")";

    // Course table create statement
    public static final String CREATE_TABLE_COURSES = "CREATE TABLE " + TABLE_COURSES + "( "
            + COURSE_ID + " INTEGER PRIMARY KEY, "
            + COURSE_TERMID + " INTEGER, "
            + COURSE_COURSENAME + " TEXT, "
            +  COURSE_COURSELOCATION + " TEXT, "
            + COURSE_COURSESTARTTIME + " INTEGER, "
            + COURSE_COURSEENDTIME + " INTEGER, "
            + "FOREIGN KEY( " + COURSE_TERMID +") REFERENCES " + TABLE_TERMS + "(" + TERM_TERMID +")"
            +")";

    // Task table create statement
    public static final String CREATE_TABLE_TASKS = "CREATE TABLE " + TABLE_TASKS + "( "
            + TASK_TASKID + " INTEGER PRIMARY KEY, "
            + TASK_TASKCOURSEID + " INTEGER, "
            + TASK_TASKNAME + " TEXT, "
            + TASK_TASKDESCRIPTION + " TEXT, "
            + TASK_TASKDUEDATE + " INTEGER, "
            + TASK_TASKDUETIME + " INTEGER,"
            + TASK_TYPE + " INTEGER,"
            + "FOREIGN KEY( " + TASK_TASKCOURSEID +") REFERENCES " + TABLE_COURSES + "(" + COURSE_ID +")"
            + ")";

    // Task_Attachments table create statement
    public static final String CREATE_TABLE_TASK_ATTACHMENTS = "CREATE TABLE " + TABLE_TASK_ATTACHMENTS + "( "
            + TASKATTACHMENT_ATTACHMENTID + " INTEGER PRIMARY KEY, "
            + TASKATTACHMENT_TASKID + " INTEGER, "
            + TASKATTACHMENT_ATTACHMENTLINK + " TEXT, "
            + TASKATTACHMENT_ATTACHMENTTYPE + " TEXT, "
            + "FOREIGN KEY( " + TASKATTACHMENT_TASKID +") REFERENCES " + TABLE_TASKS + "(" + TASK_TASKID +")"
            + ")";

    // Assignment table create statement
    public static final String CREATE_TABLE_ASSIGNMENTS = "CREATE TABLE " + TABLE_ASSIGNMENTS + "( "
            + ASSIGNMENT_ASSIGNMENTID + " INTEGER PRIMARY KEY, "
            + ASSIGNMENT_ASSIGNMENTCOURSEID + " INTEGER, "
            + ASSIGNMENT_ASSIGNMENTNAME + " TEXT, "
            + ASSIGNMENT_ASSIGNMENTDESCRIPTION + " TEXT, "
            + ASSIGNMENT_ASSIGNMENTDUEDATE + " INTEGER, "
            + ASSIGNMENT_ASSIGNMENTDUETIME + " INTEGER, "
            + "FOREIGN KEY( " + ASSIGNMENT_ASSIGNMENTCOURSEID +") REFERENCES " + TABLE_COURSES + "(" + COURSE_ID +")"
            + ")";

    // Assignment_Attachments table create statement
    public static final String CREATE_TABLE_ASSIGNMENT_ATTACHMENTS = "CREATE TABLE " + TABLE_ASSIGNMENT_ATTACHMENTS + "( "
            + ASSIGNMENTATTACHMENT_ATTACHMENTID + " INTEGER PRIMARY KEY, "
            + ASSIGNMENTATTACHMENT_ASSIGNMENTID + " INTEGER, "
            + ASSIGNMENTATTACHMENT_ATTACHMENTLINK + " TEXT, "
            + ASSIGNMENTATTACHMENT_ATTACHMENTTYPE + " TEXT, "
            + "FOREIGN KEY( " + ASSIGNMENTATTACHMENT_ASSIGNMENTID +") REFERENCES " + TABLE_ASSIGNMENTS + "(" + ASSIGNMENT_ASSIGNMENTID +")"
            + ")";

    // Project table create statement
    public static final String CREATE_TABLE_PROJECTS = "CREATE TABLE " + TABLE_PROJECTS + "( "
            + PROJECT_PROJECTID + " INTEGER PRIMARY KEY, "
            + PROJECT_PROJECTCOURSEID + " INTEGER, "
            + PROJECT_PROJECTNAME + " TEXT, "
            + PROJECT_PROJECTDESCRIPTION + " TEXT, "
            + PROJECT_PROJECTTOTALPHASES + " INTEGER, "
            + PROJECT_PROJECTDUEDATE + " INTEGER, "
            + PROJECT_PROJECTDUETIME + " INTEGER, "
            + "FOREIGN KEY( " + PROJECT_PROJECTCOURSEID +") REFERENCES " + TABLE_COURSES + "(" + COURSE_ID +")"
            + ")";

    // Project_Phases table create statement
    public static final String CREATE_TABLE_PROJECT_PHASES = "CREATE TABLE " + TABLE_PROJECT_PHASES + "( "
            + PROJECTPHASES_PROJECTPHASEID + " INTEGER PRIMARY KEY, "
            + PROJECTPHASES_PROJECTID + " INTEGER, "
            + PROJECTPHASES_COURSEID + " INTEGER, "
            + PROJECTPHASES_PROJECTPHASENAME + " TEXT, "
            + PROJECTPHASES_PROJECTPHASEDESCRIPTION + " TEXT, "
            + PROJECTPHASES_PROJECTPHASEDUEDATE + " INTEGER, "
            + PROJECTPHASE_PROJECTPHASEDUETIME + " INTEGER, "
            + "FOREIGN KEY( " + PROJECTPHASES_PROJECTID +") REFERENCES " + TABLE_PROJECTS + "(" + PROJECT_PROJECTID +"), "
            + "FOREIGN KEY( " + PROJECTPHASES_COURSEID +") REFERENCES " + TABLE_COURSES + "(" + COURSE_ID +")"
            + ")";

    // Project_Phase_Attachments table create statement
    public static final String CREATE_TABLE_PROJECT_PHASE_ATTACHMENTS = "CREATE TABLE " + TABLE_PROJECT_PHASES_ATTACHMENTS + "( "
            + PROJECTPHASESATTACHMENT_ATTACHMENTID + " INTEGER PRIMARY KEY, "
            + PROJECTPHASESATTACHMENT_PROJECTID + " INTEGER, "
            + PROJECTPHASESATTACHMENT_POJECTPHASEID + " INTEGER, "
            + PROJECTPHASESATTACHMENT_ATTACHMENTLINK + " TEXT, "
            + PROJECTPHASESATTACHMENT_ATTACHMENTTYPE + " TEXT, "
            + "FOREIGN KEY( " + PROJECTPHASESATTACHMENT_PROJECTID +") REFERENCES " + TABLE_PROJECTS + "(" + PROJECT_PROJECTID +"), "
            + "FOREIGN KEY( " + PROJECTPHASESATTACHMENT_POJECTPHASEID +") REFERENCES " + TABLE_PROJECT_PHASES + "(" + PROJECTPHASES_PROJECTPHASEID +")"
            + ")";
}