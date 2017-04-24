package sg.edu.tmc.tmcacademycoursefinder;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class FavoriteFragment extends Fragment implements OnChildClickListener {
    //Variable Declarations
    private Map<String, ?> allPrefsKey;
    private SharedPreferences sharedPreferences;
    private ExpandableListView expListView;
    private List<String> listDataHeader, saved_course;
    private HashMap<String, List<String>> listDataChild;
    private Toolbar toolBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_content, container, false);

        // Get the Expandable List View object & set Listener
        expListView = (ExpandableListView) view.findViewById(R.id.listView);
        expListView.setOnChildClickListener(this);

        //Get shared preferences
        sharedPreferences = getDefaultSharedPreferences(this.getActivity());
        // Get all saved courses from SharedPreferences
        allPrefsKey = sharedPreferences.getAll();
        saved_course = new ArrayList<>();
        for (Map.Entry<String, ?> entry : allPrefsKey.entrySet()) {
            saved_course.add(entry.getKey());
        }

        // Preparing list data
        prepareListData(saved_course);

        // Setting list adapter
        expListView.setAdapter(new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild));

        return view;
    }

    // Preparing the list of data
    private void prepareListData(List<String> data) {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getResources().getString(R.string.favorite_saved_course));

        listDataChild.put(listDataHeader.get(0), data); // Header, Child data
    } //prepareListData() ends

    // Listener for clicks on List Items
    // Implemented from OnChildClickListener class
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        //Get the course name that user clicked
        String selectedCourse = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

        // Check the course name to get Course ID
        // - Search through the CourseList array
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

                //Assign values to static attributes of 'CourseDetail' class
                CourseDetail.setAllAttributes(course_title,course_detail,course_link);
            }
        }
        //Launch 'CourseDetail' activity
        Intent intent = new Intent(getActivity(), CourseDetail.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        return false;
    } //onChildClick() ends
}
