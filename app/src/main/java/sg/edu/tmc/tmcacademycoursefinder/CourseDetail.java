package sg.edu.tmc.tmcacademycoursefinder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class CourseDetail extends AppCompatActivity implements View.OnClickListener {
    //Views Declaration
    private SharedPreferences sharedPreferences;
    private CoordinatorLayout coordinatorLayout;
    private FloatingActionButton fab;
    private Toolbar toolBar;
    private Button button;
    private TextView course_title_view;
    private TextView course_detail_view;
    private static String course_title;
    private static String course_detail;
    private static String button_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_detail);

        //Get the CoordinatorLayout object
        // This object will be used for snackbar to prevent it from covering the Floating Action Button
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);

        //Get the Floating Action Button object and set listener to thi class
        // ( Floating Action Button is a sub-view of CoordinatorLayout )
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        //Get the shared preferences file named 'MyPrefs'
        sharedPreferences = getDefaultSharedPreferences(this);
        //Check if the course is already saved.
        // If so, set isSaved=true and icon to ic_navigation_favorite.
        // Otherwise, isSaved=false and set icon to heart_outline
        if (sharedPreferences.contains(course_title)) {
            fab.setImageResource(R.drawable.ic_navigation_favorite);
        } else { //If not
            fab.setImageResource(R.drawable.heart_outline);
        }

        // Get the toolbar and set properties
        toolBar = (Toolbar) findViewById(R.id.toolbar_course_detail);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Get the TextViews and set text
        course_title_view = (TextView) findViewById(R.id.course_title);
        course_detail_view = (TextView) findViewById(R.id.course_detail);
        course_title_view.setText(course_title);
        course_detail_view.setText(course_detail);

        // Get the button and set listener to this class
        button = (Button) findViewById(R.id.course_detail_button);
        button.setOnClickListener(this);
    }

    //Open a web page of specified URL
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        //Using Intent Chooser to allow user to choose a web browser to open the webpage if there are more than 2 browsers
        Intent intentChooser = Intent.createChooser(intent, "Open webpage using...");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intentChooser);
        }
    }

    // Set all attributes
    public static void setAllAttributes(String courseTitle, String courseDetail, String courseLink) {
        course_title = courseTitle;
        button_link = courseLink;
        course_detail = courseDetail;
    }

    //Listener to handle button's clicks
    @Override
    public void onClick(View view)
    {
        switch(view.getId()) {
            case R.id.course_detail_button:
                //Check Internet connection
                if (!isNetworkAvailable()) {
                    Snackbar.make(coordinatorLayout, "No Internet connection!", Snackbar.LENGTH_SHORT).show();
                } else {
                    openWebPage(button_link);
                }
                break;
            case R.id.fab:
                //Check if the course is already saved
                // If already, remove it from SharedPreferences to unsave
                if (sharedPreferences.contains(course_title)) {
                    SharedPreferences.Editor editor = sharedPreferences.edit(); //get editor
                    editor.remove(course_title); //remove key/value
                    editor.commit(); //apply change
                    fab.setImageResource(R.drawable.heart_outline);// change icon to favorite
                    Snackbar.make(coordinatorLayout, "Unsaved", Snackbar.LENGTH_SHORT).show();
                } else { //If not, add to SharedPreferences to save to favorites
                    SharedPreferences.Editor editor = sharedPreferences.edit(); //get editor
                    editor.putBoolean(course_title, true);// add a new key/value. The value doesn't matter
                    editor.commit();// apply change
                    fab.setImageResource(R.drawable.ic_navigation_favorite); //change icon to un-favorite
                    Snackbar.make(coordinatorLayout, "Saved successfully", Snackbar.LENGTH_SHORT).show();
                }
                break;
        }
    } //onClick() ends

    //This method will check the state of Internet connection.
    //If available, return true. Otherwise, return false
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    // Cause the UP button of the Toolbar act as Back button
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return(super.onOptionsItemSelected(item));
    }
}
