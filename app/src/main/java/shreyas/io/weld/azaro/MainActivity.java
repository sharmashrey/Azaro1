package shreyas.io.weld.azaro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import java.util.List;

import shreyas.io.weld.azaro.Database.DBHelper;
import shreyas.io.weld.azaro.Model.StudentCourseModel;
import shreyas.io.weld.azaro.Model.StudentTermModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FirstFragment.OnFragmentInteractionListener, CourseFragment.OnListFragmentInteractionListener {

    public int currentfragment = 0;
    // Database Helper
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //db operations
        db = new DBHelper(getApplicationContext());
        //fillup db
         StudentTermModel inputValue1 = new StudentTermModel();
        inputValue1.setTermName("Fall 2015");
        inputValue1.setTermStartDate(20150820);
        inputValue1.setTermEndDate(20151212);
        db.addNewTerm(inputValue1);
        StudentCourseModel inp1= new StudentCourseModel();
        inp1.setCourseId(921);
        inp1.setCourseName("Alladin");
        inp1.setCourseTermId(69);
        db.addNewCourse(inp1);

        StudentCourseModel inp2= new StudentCourseModel();
        inp2.setCourseId(340);
        inp2.setCourseName("Shreyas");
        inp2.setCourseTermId(65);
        db.addNewCourse(inp2);


        List<StudentTermModel> allTermsValues = db.getAllTerms();
        for (StudentTermModel term : allTermsValues) {
            Log.d("Term id", ": " +term.getTermId());
            Log.d("Term Name",": "+term.getTermName());
            Log.d("Term StartDate", ": " + term.getTermStartDate());
            Log.d("Term Name", ": " + term.getTermEndDate());
        }

        List<StudentCourseModel> allCoursesValues = db.getAllCourses();
        for(StudentCourseModel course : allCoursesValues){
            Log.d("CourseId",": "+course.getCourseId());
            Log.d("CourseName",": "+course.getCourseName());
            Log.d("CourseTermId",": "+course.getCourseTermId());
        }
        //db Operations done

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on click of floating button, start new activity
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                if(currentfragment == 1){
                    //launch related activity
                }else if(currentfragment == 2){
                    //launch related activity
                }else if(currentfragment == 3){
                    //launch related activity
                    Intent myIntent = new Intent(MainActivity.this, AddCourseActivity.class);
                    myIntent.putExtra("key", 3); //Optional parameters
                    MainActivity.this.startActivity(myIntent);

                } else {

                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_subject_fragment) {
            // Handle the camera action
            fragment = FirstFragment.newInstance();
            currentfragment = 1;
        } else if (id == R.id.nav_gallery) {
            fragment = SecondFragment.newInstance(null, null);
            currentfragment = 2;
        } else if (id == R.id.nav_slideshow) {
            fragment = CourseFragment.newInstance(6);
            currentfragment = 3;
        } else if (id == R.id.nav_manage) {

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main, fragment).commit();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(StudentCourseModel item) {

    }
}
