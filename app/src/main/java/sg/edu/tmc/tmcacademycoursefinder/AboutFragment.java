package sg.edu.tmc.tmcacademycoursefinder;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.net.NetworkInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class AboutFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Initiate Views
        View view = inflater.inflate(R.layout.about_content, container, false);
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);
        Button button5 = (Button) view.findViewById(R.id.button5);

        //Set listener for the buttons
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

        return view;
    }

    //Open a web page of specified URL
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        //Using Intent Chooser to allow user to choose a web browser to open the webpage if there are more than 2 browsers
        Intent intentChooser = Intent.createChooser(intent, "Open webpage using...");
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intentChooser);
        }
    }

    //Listener to handle button's clicks
    @Override
    public void onClick(View view)
    {
        //Check Internet connection
        if (!isNetworkAvailable()) {
            Toast.makeText(getActivity().getApplicationContext(),"No Internet Connection !", Toast.LENGTH_SHORT).show();
        } else {
            switch (view.getId()) {
                case R.id.button1:
                    openWebPage(getResources().getString(R.string.about_link_history));
                    break;
                case R.id.button2:
                    openWebPage(getResources().getString(R.string.about_link_welcome));
                    break;
                case R.id.button3:
                    openWebPage(getResources().getString(R.string.about_link_vision));
                    break;
                case R.id.button4:
                    openWebPage(getResources().getString(R.string.about_link_why));
                    break;
                case R.id.button5:
                    openWebPage(getResources().getString(R.string.about_link_more));
                    break;
            }
        }
    } //onClick()

    //This method will check the state of the Internet connection.
    //If the network is available, return true. Otherwise, return false
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
