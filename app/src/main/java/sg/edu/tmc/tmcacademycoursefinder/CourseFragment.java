package sg.edu.tmc.tmcacademycoursefinder;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CourseFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.course_content, container, false);
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        //Set listener for the buttons
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        return view;
    }

    // Handle button's clicks
    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(getActivity(), CourseDisciplineList.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(getActivity(), CourseInstitutionList.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                break;
        }
    }
}// Class ends