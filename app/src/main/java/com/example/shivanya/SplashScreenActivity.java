package com.example.shivanya;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {
    ConnectionDetector cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        cd = new ConnectionDetector(getApplicationContext());
        if (cd.isConnectingToInternet()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
//
                        /*if(SharedPreferencesConstants.Password.isEmpty()) {*/
                        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                        //}
                      /*  else
                            {
                                Intent i1 = new Intent(SplashScreenActivity.this, Dashboard.class);
                                startActivity(i1);
                                finish();
                            }*/
                        //                    }
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast.makeText(getApplicationContext(), "please connect to internet", Toast.LENGTH_SHORT).show();
        }


    }

}
