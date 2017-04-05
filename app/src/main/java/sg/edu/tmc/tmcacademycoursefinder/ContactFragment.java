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
import android.widget.EditText;
import android.widget.Toast;

public class ContactFragment extends Fragment implements OnClickListener {

    //Variables
    EditText input_inquiry,input_mobile, input_email, input_name;
    Button btn_mail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_content, container, false);

        //Get EditText objects
        input_name = (EditText) view.findViewById(R.id.input_name);
        input_email = (EditText) view.findViewById(R.id.input_email);
        input_mobile = (EditText) view.findViewById(R.id.input_mobile);
        input_inquiry = (EditText) view.findViewById(R.id.input_inquiry);

        //Get button object
        btn_mail = (Button) view.findViewById(R.id.btn_mail);
        btn_mail.setOnClickListener(this);

        return view;
    }

    //Listener to handle button's clicks
    @Override
    public void onClick(View view) {
         switch (view.getId()) {
             case R.id.btn_mail:
                 String mailto = "mailto:huybq.1992@gmail.com" +
                         "?cc=" + "huybq.1992@gmail.com" +
                         "?subject=" + Uri.encode("Inquiry") +
                         "&body=" + "Dear TMC academy," +
                                    "\nI would like to receive more information about courses that your dear academy provide." +
                                    "\nThis is my contact detail." +
                                    "\n\nName:" + Uri.encode(input_name.getText().toString()) +
                                    "\nEmail:" + Uri.encode(input_email.getText().toString()) +
                                    "\nMobile:" + Uri.encode(input_mobile.getText().toString()) +
                                    "\nInquiry:" + Uri.encode(input_inquiry.getText().toString()) +
                                    "\n\nThank you!" +
                                    "\n\nYour sincerely,";

                 Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                 emailIntent.setData(Uri.parse(mailto));
                 //Using Intent Chooser to allow user to choose a web browser to open the webpage if there are more than 2 browsers
                 Intent intentChooser = Intent.createChooser(emailIntent, "Send email using...");
                 if (emailIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                     startActivity(intentChooser);
                 }
                 break;
             case R.id.button2:
                 break;
         }
    }//onClick()
}
