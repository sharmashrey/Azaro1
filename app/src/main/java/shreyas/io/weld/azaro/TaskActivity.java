package shreyas.io.weld.azaro;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.LoaderManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.List;

import shreyas.io.weld.azaro.Database.DBHelper;
import shreyas.io.weld.azaro.Model.Course;


public class TaskActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>,View.OnClickListener{

    private static final int REQUEST_READ_CONTACTS = 0;
    private static final String[] DUMMY_CREDENTIALS = new String[]{"foo@example.com:hello", "bar@example.com:world"};
    private TaskActivity.UserLoginTask mAuthTask = null;

    // UI references -create variables for storing message & button objects
    private AutoCompleteTextView mEmailView;
    private EditText mEditCourseName;
    private EditText mEditCourseLocationView;
    DBHelper db;
    private Button mSaveButton;
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        //make message text field & button object
        mEditCourseName = (EditText) findViewById(R.id.EditCourseName);
        mEditCourseLocationView = (EditText) findViewById(R.id.EditCourseLocation);
        mSaveButton = (Button) findViewById(R.id.save_button);

        //btn dt tm pckr
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        //   Retrieve Extras are retrieved on the other side via:
        Intent intent = getIntent();
        String value = intent.getStringExtra("key"); //if it's a string you stored.

        // Create an ArrayAdapter using the string array and a default spinner layout
  /*      Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tasks_array, android.R.layout.select_dialog_multichoice);
        adapter.setDropDownViewResource(android.R.);
        spinner.setAdapter(adapter); // Apply the adapter to the spinner
*/

    }

    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

    //When the send button is clicked
    public void send(View v)
    {
        // ADD TO DATABASE
        db = new DBHelper(getApplicationContext());

        Course input1= new Course();
        input1.setCourseName( mEditCourseName.getText().toString());
        input1.setCourseLocation( mEditCourseLocationView.getText().toString());
        //  input1.setCourseStartTime( Integer.parseInt(mEditCourseStartTime.getText().toString()) );
        //  input1.setCourseEndTime( Integer.parseInt(mEditCourseEndTime.getText().toString()) );
        db.addNewCourse(input1);
        finish();
    }

    private void populateAutoComplete() {}
    private boolean mayRequestContacts() {return false;}
    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {}


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {}
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) { }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;}

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) { }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {}

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(TaskActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }

    private interface ProfileQuery { }

    /*Represents an asynchronous login/registration task used to authenticate the user. */

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {/*  */  return true;}

        @Override
        protected void onPostExecute(final Boolean success) {/*      */  }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}
