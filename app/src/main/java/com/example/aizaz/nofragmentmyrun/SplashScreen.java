package com.example.aizaz.nofragmentmyrun;


import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 0;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Button pro= (Button) findViewById(R.id.proceed);

        gps = new GPSTracker(this);
        // check if GPS enabled
        if(gps.canGetLocation()){

            // Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        }else{

            gps.showSettingsAlert();

        }

        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(gps.canGetLocation()){
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();

                    //   Toast.makeText(getApplicationContext(), "proBTN", Toast.LENGTH_LONG).show();
                }else{

                    gps.showSettingsAlert();
                    gps.canGetLocation=true;
                }




            }
        });

    }
    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }

}