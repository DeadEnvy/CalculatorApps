package com.example.calculatorapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button next;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button factorial;

    public EditText name;
    public EditText age;
    private EditText num1;
    private EditText num2;
    private EditText result;

    private Float number1;
    private Float number2;
    private Float resultNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        multiply = findViewById(R.id.multiply);
        subtract = findViewById(R.id.subtract);
        divide = findViewById(R.id.divide);
        factorial = findViewById(R.id.factorial);
        next = findViewById(R.id.next);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        result = findViewById(R.id.result);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (num1 == null || num2 == null)
                {
                    num1.setText("");
                    num2.setText("");
                }
                else {
                    number1 = Float.parseFloat(num1.getText().toString());
                    number2 = Float.parseFloat(num2.getText() + "");
                    resultNumber = number1 + number2;

                    result.setText(resultNumber.toString());
                }
            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 == null || num2 == null)
                {
                    num1.setText("");
                    num2.setText("");
                }
                else {
                    number1 = Float.parseFloat(num1.getText() + "");
                    number2 = Float.parseFloat(num2.getText() + "");
                    resultNumber = number1 - number2;

                    result.setText(resultNumber.toString());
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 == null || num2 == null)
                {
                    num1.setText("");
                    num2.setText("");
                }
                else {
                    number1 = Float.parseFloat(num1.getText().toString());
                    number2 = Float.parseFloat(num2.getText() + "");
                    resultNumber = number1 * number2;

                    result.setText(resultNumber.toString());
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1 == null || num2 == null)
                {
                    num1.setText("");
                    num2.setText("");
                }
                else {
                    number1 = Float.parseFloat(num1.getText() + "");
                    number2 = Float.parseFloat(num2.getText() + "");
                    resultNumber = number1 / number2;

                    result.setText(resultNumber.toString());
                }
            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    number1 = Float.parseFloat(num1.getText() + "");
                    int i = 1;
                    float factorials = number1;


                    for (i = 1; i < number1; i++)
                    {
                       factorials = factorials * i;
                    }

                    resultNumber = factorials;
                    result.setText(resultNumber.toString());



            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, save_me.class);
                startActivityForResult(i, 1);
            }
        });



    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        SharedPreferences sp = getSharedPreferences("userInfo", 0);
//        String  usersName = sp.getString("usersName", "");
//        String  usersAge = sp.getString("usersAge", "");
//
//        name.setText(usersName);
//        age.setText(usersAge);

        if(resultCode == RESULT_OK)
        {
            String new_name = data.getStringExtra("Name");
            String new_age = data.getStringExtra("Age");
            name.setText(new_name);
            age.setText(new_age);
        }

    }
}
