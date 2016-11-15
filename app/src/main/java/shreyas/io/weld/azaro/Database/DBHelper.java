package shreyas.io.weld.azaro.Database;

/**
 * Created by shreyas on 14/11/16.
 */

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

        import java.util.ArrayList;
        import java.util.List;

        import shreyas.io.weld.azaro.Model.StudentCourseModel;
        import shreyas.io.weld.azaro.Model.StudentTermModel;

/**
 * This class will help to in database related activities
 */

public class DBHelper  extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DBHelper";

    public DBHelper(Context context) {
        super(context, DBRelatedConstants.DATABASE_NAME, null, DBRelatedConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(DBRelatedConstants.CREATE_TABLE_TERMS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_COURSES);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_TASKS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_TASK_ATTACHMENTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_ASSIGNMENTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_ASSIGNMENT_ATTACHMENTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_PROJECTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_PROJECT_PHASES);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_PROJECT_PHASE_ATTACHMENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_TERMS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_COURSES);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_TASKS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_TASK_ATTACHMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_ASSIGNMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_ASSIGNMENT_ATTACHMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_PROJECTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_PROJECT_PHASES);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_PROJECT_PHASES_ATTACHMENTS);
        // create new tables
        onCreate(db);
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


    /*  Term table related activity */
    public long addNewTerm(StudentTermModel newTerm) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBRelatedConstants.TERM_TERMNAME, newTerm.getTermName());
        values.put(DBRelatedConstants.TERM_TERMSTARTDATE, newTerm.getTermStartDate());
        values.put(DBRelatedConstants.TERM_TERMENDDATE, newTerm.getTermEndDate());
        // insert row
        long newTermRow = db.insert(DBRelatedConstants.TABLE_TERMS, null, values);
        Log.d(" New Row iD", "New row inserted  in Term table" + newTermRow);

        return newTermRow;

    }

    public StudentTermModel getTerm(int term_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DBRelatedConstants.TABLE_TERMS + " WHERE "
                + DBRelatedConstants.TERM_TERMID + " = " + term_id;

        Log.e(LOG, selectQuery);

        Cursor singleTerm = db.rawQuery(selectQuery, null);

        if (singleTerm != null)
            singleTerm.moveToFirst();

        StudentTermModel outputResult = new StudentTermModel();
        outputResult.setTermId(singleTerm.getInt(singleTerm.getColumnIndex(DBRelatedConstants.TERM_TERMID)));
        outputResult.setTermName(singleTerm.getString(singleTerm.getColumnIndex(DBRelatedConstants.TERM_TERMNAME)));
        outputResult.setTermStartDate(singleTerm.getInt(singleTerm.getColumnIndex(DBRelatedConstants.TERM_TERMSTARTDATE)));
        outputResult.setTermEndDate(singleTerm.getInt(singleTerm.getColumnIndex(DBRelatedConstants.TERM_TERMENDDATE)));

        return  outputResult;


    }

    public List<StudentTermModel> getAllTerms() {
        List<StudentTermModel> outputTermValues = new ArrayList<StudentTermModel>();
        String selectQuery = "SELECT  * FROM " + DBRelatedConstants.TABLE_TERMS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultTermValues = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (resultTermValues.moveToFirst()) {
            do {
                StudentTermModel outputResult = new StudentTermModel();
                outputResult.setTermId(resultTermValues.getInt(resultTermValues.getColumnIndex(DBRelatedConstants.TERM_TERMID)));
                outputResult.setTermName(resultTermValues.getString(resultTermValues.getColumnIndex(DBRelatedConstants.TERM_TERMNAME)));
                outputResult.setTermStartDate(resultTermValues.getInt(resultTermValues.getColumnIndex(DBRelatedConstants.TERM_TERMSTARTDATE)));
                outputResult.setTermEndDate(resultTermValues.getInt(resultTermValues.getColumnIndex(DBRelatedConstants.TERM_TERMENDDATE)));
                outputTermValues.add(outputResult);
            } while (resultTermValues.moveToNext());
        }

        return outputTermValues;
    }


    /*  Course table related activity */
    public long addNewCourse(StudentCourseModel newCourse) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBRelatedConstants.COURSE_TERMID, newCourse.getCourseTermId());
        values.put(DBRelatedConstants.COURSE_COURSENAME, newCourse.getCourseName());
        values.put(DBRelatedConstants.COURSE_COURSELOCATION, newCourse.getCourseLocation());
        values.put(DBRelatedConstants.COURSE_COURSESTARTTIME, newCourse.getCourseStartTime());
        values.put(DBRelatedConstants.COURSE_COURSEENDTIME, newCourse.getCourseEndTime());

        // insert row
        long newCourseRow = db.insert(DBRelatedConstants.TABLE_COURSES, null, values);
        Log.d(" New Row iD", "New row inserted  in Term table" + newCourseRow);

        return newCourseRow;

    }

    public List<StudentCourseModel> getAllCourses() {
        List<StudentCourseModel> outputTermValues = new ArrayList<StudentCourseModel>();

        String selectQuery = "SELECT  * FROM " + DBRelatedConstants.TABLE_COURSES;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultCourseValues = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (resultCourseValues.moveToFirst()) {
            do {
                StudentCourseModel outputResult = new StudentCourseModel();
                outputResult.setCourseId(resultCourseValues.getInt(resultCourseValues.getColumnIndex(DBRelatedConstants.COURSE_ID)));
                outputResult.setCourseTermId(resultCourseValues.getInt(resultCourseValues.getColumnIndex(DBRelatedConstants.COURSE_TERMID)));
                outputResult.setCourseName(resultCourseValues.getString(resultCourseValues.getColumnIndex(DBRelatedConstants.COURSE_COURSENAME)));
                outputResult.setCourseLocation(resultCourseValues.getString(resultCourseValues.getColumnIndex(DBRelatedConstants.COURSE_COURSELOCATION)));
                outputResult.setCourseStartTime(resultCourseValues.getInt(resultCourseValues.getColumnIndex(DBRelatedConstants.COURSE_COURSESTARTTIME)));
                outputResult.setCourseEndTime(resultCourseValues.getInt(resultCourseValues.getColumnIndex(DBRelatedConstants.COURSE_COURSEENDTIME)));
                outputTermValues.add(outputResult);
            } while (resultCourseValues.moveToNext());
        }

        return outputTermValues;
    }

}