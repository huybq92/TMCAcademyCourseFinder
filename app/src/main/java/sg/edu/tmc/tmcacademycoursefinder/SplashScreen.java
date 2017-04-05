package sg.edu.tmc.tmcacademycoursefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.CountDownTimer;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creates an Intent to start MainActivity, then destroys itself
        final Intent intent = new Intent(this, MainActivity.class);

        //Set a timer to delay 1,5 SECONDS before moving to MainActivity
        new CountDownTimer(2000,1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                //Start MainActivity when the timer ends
                startActivity(intent);
                finish();
            }
        }.start();

    }
}