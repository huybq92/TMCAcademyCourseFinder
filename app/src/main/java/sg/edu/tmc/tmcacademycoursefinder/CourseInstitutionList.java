package sg.edu.tmc.tmcacademycoursefinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseInstitutionList extends AppCompatActivity implements OnChildClickListener {
    //Variable Declaration
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_institution);

        // Get the Expandable List View object $ set Listener
        expListView = (ExpandableListView) findViewById(R.id.listView);
        expListView.setOnChildClickListener(this);

        // Get the toolbar and set properties
        toolBar = (Toolbar) findViewById(R.id.toolbar_course_institution);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Preparing list data
        prepareListData();

        // Setting list adapter
        expListView.setAdapter(new ExpandableListAdapter(this, listDataHeader, listDataChild));
    }

    // Preparing the list of data
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getResources().getString(R.string.course_institution_tmc));
        listDataHeader.add(getResources().getString(R.string.course_institution_northampton));
        listDataHeader.add(getResources().getString(R.string.course_institution_gloucestershire));
        listDataHeader.add(getResources().getString(R.string.course_institution_greenwich));

        // Adding child data
        List<String> tmc = new ArrayList<String>();
        tmc.add(MainActivity.getCourseList()[0]);
        tmc.add(MainActivity.getCourseList()[1]);
        tmc.add(MainActivity.getCourseList()[3]);
        tmc.add(MainActivity.getCourseList()[4]);
        tmc.add(MainActivity.getCourseList()[10]);
        tmc.add(MainActivity.getCourseList()[11]);
        tmc.add(MainActivity.getCourseList()[12]);
        tmc.add(MainActivity.getCourseList()[14]);
        tmc.add(MainActivity.getCourseList()[15]);
        tmc.add(MainActivity.getCourseList()[16]);
        tmc.add(MainActivity.getCourseList()[17]);
        tmc.add(MainActivity.getCourseList()[18]);
        tmc.add(MainActivity.getCourseList()[20]);
        tmc.add(MainActivity.getCourseList()[21]);

        List<String> northampton = new ArrayList<String>();
        northampton.add(MainActivity.getCourseList()[2]);
        northampton.add(MainActivity.getCourseList()[6]);
        northampton.add(MainActivity.getCourseList()[7]);
        northampton.add(MainActivity.getCourseList()[9]);
        northampton.add(MainActivity.getCourseList()[19]);

        List<String> gloucestershire = new ArrayList<String>();
        gloucestershire.add(MainActivity.getCourseList()[5]);
        gloucestershire.add(MainActivity.getCourseList()[8]);

        List<String> greenwich = new ArrayList<String>();
        greenwich.add(MainActivity.getCourseList()[13]);

        listDataChild.put(listDataHeader.get(0), tmc); // Header, Child data
        listDataChild.put(listDataHeader.get(1), northampton);
        listDataChild.put(listDataHeader.get(2), gloucestershire);
        listDataChild.put(listDataHeader.get(3), greenwich);
    } //prepareListData() ends

    // Listener for clicks on List Items
    // Implemented from OnChildClickListener class
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        //Get the course name that user clicked
        String selectedCourse = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

        // Check the course name to get Course ID
        // - Search through the CourseList array and compare course names (compare STRING)
        // - If match the selectedCourse, get the index of CourseList array, which is also the course ID
        // - Then break the for loop
        for (int i=0; i < MainActivity.getCourseList().length; i++) {
            if (selectedCourse.equals(MainActivity.getCourseList()[i])) {
                String course_title = selectedCourse;
                String course_detail = "";
                String course_link = "";
                switch (i) {
                    case 0:
                        course_detail = getResources().getString(R.string.course_detail0);
                        course_link = getResources().getString(R.string.course_link0);
                        break;
                    case 1:
                        course_detail = getResources().getString(R.string.course_detail1);
                        course_link = getResources().getString(R.string.course_link1);
                        break;
                    case 2:
                        course_detail = getResources().getString(R.string.course_detail2);
                        course_link = getResources().getString(R.string.course_link2);
                        break;
                    case 3:
                        course_detail = getResources().getString(R.string.course_detail3);
                        course_link = getResources().getString(R.string.course_link3);
                        break;
                    case 4:
                        course_detail = getResources().getString(R.string.course_detail4);
                        course_link = getResources().getString(R.string.course_link4);
                        break;
                    case 5:
                        course_detail = getResources().getString(R.string.course_detail5);
                        course_link = getResources().getString(R.string.course_link5);
                        break;
                    case 6:
                        course_detail = getResources().getString(R.string.course_detail6);
                        course_link = getResources().getString(R.string.course_link6);
                        break;
                    case 7:
                        course_detail = getResources().getString(R.string.course_detail7);
                        course_link = getResources().getString(R.string.course_link7);
                        break;
                    case 8:
                        course_detail = getResources().getString(R.string.course_detail8);
                        course_link = getResources().getString(R.string.course_link8);
                        break;
                    case 9:
                        course_detail = getResources().getString(R.string.course_detail9);
                        course_link = getResources().getString(R.string.course_link9);
                        break;
                    case 10:
                        course_detail = getResources().getString(R.string.course_detail10);
                        course_link = getResources().getString(R.string.course_link10);
                        break;
                    case 11:
                        course_detail = getResources().getString(R.string.course_detail11);
                        course_link = getResources().getString(R.string.course_link11);
                        break;
                    case 12:
                        course_detail = getResources().getString(R.string.course_detail12);
                        course_link = getResources().getString(R.string.course_link12);
                        break;
                    case 13:
                        course_detail = getResources().getString(R.string.course_detail13);
                        course_link = getResources().getString(R.string.course_link13);
                        break;
                    case 14:
                        course_detail = getResources().getString(R.string.course_detail14);
                        course_link = getResources().getString(R.string.course_link14);
                        break;
                    case 15:
                        course_detail = getResources().getString(R.string.course_detail15);
                        course_link = getResources().getString(R.string.course_link15);
                        break;
                    case 16:
                        course_detail = getResources().getString(R.string.course_detail16);
                        course_link = getResources().getString(R.string.course_link16);
                        break;
                    case 17:
                        course_detail = getResources().getString(R.string.course_detail17);
                        course_link = getResources().getString(R.string.course_link17);
                        break;
                    case 18:
                        course_detail = getResources().getString(R.string.course_detail18);
                        course_link = getResources().getString(R.string.course_link18);
                        break;
                    case 19:
                        course_detail = getResources().getString(R.string.course_detail19);
                        course_link = getResources().getString(R.string.course_link19);
                        break;
                    case 20:
                        course_detail = getResources().getString(R.string.course_detail20);
                        course_link = getResources().getString(R.string.course_link20);
                        break;
                    case 21:
                        course_detail = getResources().getString(R.string.course_detail21);
                        course_link = getResources().getString(R.string.course_link21);
                        break;
                } //switch(i) ends

                //Set attributes to 'CourseDetail' class
                CourseDetail.setAllAttributes(course_title,course_detail,course_link);
            }
        }
        //Launch 'CourseDetail' activity
        Intent intent = new Intent(this, CourseDetail.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        return false;
    } //onChildClick() ends

    @Override
    // UP button of the Toolbar acts as Back button
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return(super.onOptionsItemSelected(item));
    }
}
