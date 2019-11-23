package com.example.shivanya;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class BirthDayMsg extends AppCompatActivity {
           RadioButton radioButton;
            LinearLayout linearlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_day_msg);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));
            }
        });
        radioButton = (RadioButton)findViewById(R.id.radioButton);

        linearlayout=(LinearLayout) findViewById(R.id.linearlayout);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(radioButton.isChecked())
                {

                    System.out.println("checked");
                    // is checked
                    linearlayout.setVisibility(View.VISIBLE);
                }
                else
                {
                    linearlayout.setVisibility(View.INVISIBLE);

                    // not checked
                }
            }
        });
    }

}
