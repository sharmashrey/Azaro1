package shreyas.io.weld.azaro;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import shreyas.io.weld.azaro.Database.DBHelper;
import shreyas.io.weld.azaro.Model.Course;
import shreyas.io.weld.azaro.Model.Project;
import shreyas.io.weld.azaro.Model.Task;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FirstFragment.OnFragmentInteractionListener, CourseFragment.OnListFragmentInteractionListener,
                    TaskFragment.OnListFragmentInteractionListener, ProjectFragment.OnListFragmentInteractionListener{

    public int currentfragment = 0;
    // Database Helper
    DBHelper db;
    private String m_Text = ""; //text for inner fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //db operations
        db = new DBHelper(getApplicationContext());
        //fillup db

        //DUMP DATABASE
        //context.deleteDatabase(db);


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
                    //

                }else if(currentfragment == 2){
                    Intent myIntent = new Intent(MainActivity.this, TaskActivity.class);
                    myIntent.putExtra("key", 2); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }else if(currentfragment == 3){
                    //launch related activity
                    Intent myIntent = new Intent(MainActivity.this, AddCourseActivity.class);
                    myIntent.putExtra("key", 3); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }else if(currentfragment == 4){
                    Intent myIntent = new Intent(MainActivity.this, ProjectActivity.class);
                    myIntent.putExtra("key", 4); //Optional parameters
                    MainActivity.this.startActivity(myIntent);

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
        if (id == R.id.nav_dashboard_fragment) {
            // Stay on Homepage
        }
        else if (id == R.id.nav_task_fragment) {
            fragment = TaskFragment.newInstance(2);
            currentfragment = 2;
        }
        else if (id == R.id.nav_course) {
            fragment = CourseFragment.newInstance(3);
            currentfragment = 3;
        }
        else if (id == R.id.nav_project) {
            fragment = ProjectFragment.newInstance(4);
            currentfragment = 4;
        }

        else if (id == R.id.nav_navigation) {

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
    public void onListFragmentInteraction(final Course item) {

        //first show an alert dialog to edit/delete. on delete click call delete method. on edit click
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
        builderSingle.setIcon(R.drawable.ic_speaker_dark);
        builderSingle.setTitle("Edit Course "+ item.getCourseName());

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.dialog_item_layout);

        arrayAdapter.add("Update");
        arrayAdapter.add("Delete");

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); }
                });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);
                        if(strName.equalsIgnoreCase("Update") ){
                        final AlertDialog.Builder builderInner = new AlertDialog.Builder(MainActivity.this);
                            final EditText input = new EditText(MainActivity.this);
                            final EditText input2 = new EditText(MainActivity.this);

                            builderInner.setMessage(strName);
                        builderInner.setTitle("Update Relevant Info");


                        // Set up the Edit Text Containing Information
                            input.setInputType(InputType.TYPE_CLASS_TEXT);
                            builderInner.setView(input);
                            input2.setInputType(InputType.TYPE_CLASS_TEXT);
                            builderInner.setView(input2);

                            final EditText input3 = new EditText(MainActivity.this);

                           // EditText mEditCourseName = (EditText) findViewById(R.id.EditCourseNameDialogueBx);

                            // Set up the buttons
                        builderInner.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                m_Text = input.getText().toString();
                                m_Text = input2.getText().toString();
                            }
                        });


                        builderInner.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(
                                            DialogInterface dialog,
                                            int which) {
                                        dialog.dismiss();
                                    }
                                });
                        builderInner.show();
                    }else{  // Delete selected , implement it
                            db.deleteCourse(item);
                        }


                    }
                });
        builderSingle.show();
        //for alert dialogue

        //this is the item which was clicked.
        //display all info in an alert dialog in edit texts. but button save. on click of that button
        //call updatestudentcourse method and pass the new updated student course object
        //
    }
    @Override
    public void onListFragmentInteraction(Task item) {
    }

    @Override
    public void onListFragmentInteraction(Project item) {
    }
}
