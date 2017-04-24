package sg.edu.tmc.tmcacademycoursefinder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //Views Declaration
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BottomNavigationView navigation;
    private int currentFragmentId = 1; // first fragment when the app starts is 'CourseFragment'

    // Static data
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a Toolbar and set toolbar icon
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_tmc);
        toolbar.setTitle("TMC Academy");
        setSupportActionBar(toolbar); //Set toolbar as Actionbar

        // Instantiate a Bottom Navigation Bar and set Listener for Click Event
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.disableShiftMode(navigation); // Disable Shift-mode of the Bottom Navigation View

        // Get fragment manager from this Activity to manage the changing of fragments
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content, new CourseFragment()); // By default, Course fragment is the first one to show up
        fragmentTransaction.commit();
    } // onCreate() ends

    @Override
    // Refresh the Favorite list after modifying (adding, removing favorite courses)
    public void onResume(){
        super.onResume();

        //Check if current fragment is Favorite.
        // If yes, replace with a new Favorite fragment
        if (currentFragmentId == 2) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content, new FavoriteFragment());
            fragmentTransaction.commit();
        }
    }

    @Override
    // Listener for selecting Items on Bottom Navigation View
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

    // Check if the current fragment is the one that user clicks on the Bottom Navigation View
    private boolean isCurrentFragment(int id) { return id == currentFragmentId; }

    // Get the courseList[]
    public static String[] getCourseList () { return courseList; }

}// Class ends
