package com.example.calculatorapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class save_me extends AppCompatActivity {

    private DatePicker birthdayDate;
    private EditText name;
    private EditText ageText;
    private Button saveButton;
    private Button setButton;
    private DatePicker datePicker;
    private Button loadButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_me);

        birthdayDate = findViewById(R.id.Datepick);
        ageText = findViewById(R.id.age);
        saveButton = (Button) findViewById(R.id.save);
        setButton = findViewById(R.id.btnSet);
        datePicker = findViewById(R.id.Datepick);
        name = findViewById(R.id.name);
        loadButton = findViewById(R.id.btnLoad);


        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Calendar calendar = Calendar.getInstance();
               Date date = new Date();
               calendar.setTime(date);
               int currentYear = calendar.get(Calendar.YEAR);
               int selectedYear = datePicker.getYear();
               int currentAge = currentYear - selectedYear;
               String ageString = Integer.toString(currentAge);
               ageText.setText(ageString);


            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

             SharedPreferences.Editor editor = sharedPref.edit();
             editor.putString("usersName", name.getText().toString());
             editor.putString("usersAge", ageText.getText().toString());
             editor.commit();

             if (sharedPref.contains("usersName") || sharedPref.contains("usersAge"))
             {
                 Toast.makeText(save_me.this, "Successfully Saved!",
                         Toast.LENGTH_LONG).show();
             }

            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                String names = sharedPref.getString("usersName", "");
                String age = sharedPref.getString("usersAge", "");

                name.setText(names);
                ageText.setText(age);

                Toast.makeText(save_me.this, "Successfully Loaded!",
                        Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onBackPressed() {
//        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("usersName", name.getText().toString());
//        editor.putString("usersAge", ageText.getText().toString());
//        editor.commit();
//
//        setResult(Activity.RESULT_OK);
//        super.onBackPressed();

        Intent intent = new Intent(this, MainActivity.class);
        String usersName = name.getText().toString();
        String age = ageText.getText().toString();

        intent.putExtra("Name", usersName);
        intent.putExtra("Age", age);

        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }


}
