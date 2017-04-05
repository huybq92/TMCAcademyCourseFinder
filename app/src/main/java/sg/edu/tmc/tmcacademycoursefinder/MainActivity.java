package sg.edu.tmc.tmcacademycoursefinder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //Views Declaration
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BottomNavigationView navigation;
    private static String course_title;
    private static String course_detail;
    private static String button_link;
    private static String[] courseList = {
            "Diploma in Accounting and Finance",
            "Bachelor of Science (Honours) in Accounting and Finance",
            "Bachelor of Science (Honours) \n International Accounting (Top Up)",
            "Post-Graduate Diploma in Accounting \n – A Preparatory Course for UMKC Master of Science in Accounting (MSA)",
            "Post-Graduate Diploma in Finance \n – A Preparatory Course for UMKC Master of Science in Finance (MSF)",
            "Bachelor of Arts (Honours) in Accounting and Financial Management Studies (Top-up)",
            "Bachelor of Arts (Honours) \n Business and Management (Top-Up)",
            "Bachelor of Arts (Honours) \n Marketing Management (Top-Up)",
            "Bachelor of Arts (Honours) in \n Business Management and Strategy (Top-up)",
            "Bachelor of Arts (Honours) \n International Tourism Management (Top Up)",
            "Higher Diploma in Hospitality and Tourism Management",
            "Higher Diploma in Tourism, Hospitality and Leisure Management",
            "International Diploma in Hospitality",
            "Bachelor of Science (Honours) Computing (Top-up)",
            "Higher Diploma in Infocomm Technology",
            "International Diploma in Information Technology",
            "Higher Diploma in Mass Communication",
            "International Diploma in Mass Communication",
            "Bachelor of Science (Honours) \n Psychology with Counselling (Top-up)",
            "Bachelor of Science (Honours) Psychology (Top-Up)",
            "Graduate Diploma of Psychology",
            "Higher Diploma in Psychology with Counselling"
    };
    private int currentFragmentId = 1; // first fragment when the app first run is 'CourseFragment'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a Toolbar and set toolbar icon
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_tmc);
        toolbar.setTitle("TMC Academy");
        setSupportActionBar(toolbar);

        //Get fragment manager
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        //Add Fragments to the content area
        fragmentTransaction.add(R.id.content, new CourseFragment());
        fragmentTransaction.commit();

        //Create Bottom Navigation Bar and set Listener for Click Event
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Disable Shift-mode of the Bottom Navigation View
        BottomNavigationViewHelper.disableShiftMode(navigation);
    } // onCreate() ends

    @Override
    //This method will be called once this activity comes foreground
    // Here, I use it to refresh the Favorite list aster modifying
    public void onResume(){
        super.onResume();

        //Check if current fragment is Favorite.
        // If yes, replace with a new Favorite fragment
        // If not, ignore
        if (currentFragmentId==2) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content, new FavoriteFragment());
            fragmentTransaction.commit();
        }
    }

    //Return CourseList array
    public static String[] getCourseList () { return courseList; }
    // Set all attributes
    public static void setAllAttributes(String courseTitle, String courseDetail, String courseLink) {
        course_title = courseTitle;
        button_link = courseLink;
        course_detail = courseDetail;
    }

    //Create a listener for Bottom Navigation View
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_course:
                    //Check currentFragment
                    if (!isCurrentFragment(1)) {
                        currentFragmentId = 1;
                        toolbar.setTitle(R.string.toolbar_main_course);
                        //Replace with the new fragment
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content, new CourseFragment());
                        fragmentTransaction.commit();
                    }
                    return true;

                case R.id.navigation_favorite:
                    //Check currentFragment
                    if (!isCurrentFragment(2)) {
                        currentFragmentId = 2;
                        toolbar.setTitle(R.string.toolbar_main_favorite);
                        //Replace with the new fragment
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content, new FavoriteFragment());
                        fragmentTransaction.commit();
                    }
                    return true;

                case R.id.navigation_about:
                    //Check currentFragment
                    if (!isCurrentFragment(3)) {
                        currentFragmentId = 3;
                        toolbar.setTitle(R.string.toolbar_main_about);
                        //Replace with the new fragment
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content, new AboutFragment());
                        fragmentTransaction.commit();
                    }
                    return true;

                case R.id.navigation_contact:
                    //Check currentFragment
                    if (!isCurrentFragment(4)) {
                        currentFragmentId = 4;
                        toolbar.setTitle(R.string.toolbar_main_contact);
                        //Replace with the new fragment
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content, new ContactFragment());
                        fragmentTransaction.commit();
                    }
                    return true;
            }
            return false;
        }

    };

    //Method isCurrentFragment():
    // - Check if the current fragment is the one that user click on the Bottom Navigation View
    private boolean isCurrentFragment(int id) {
        if (id == currentFragmentId) {
            return true;
        } else {
            return false;
        }
    }
}
