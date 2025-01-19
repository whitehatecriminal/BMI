package com.example.bmi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText wt, ht;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wt = findViewById(R.id.wt);
        ht = findViewById(R.id.ht);
        btn = findViewById(R.id.btnresult);
        result = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double wet = Double.parseDouble(wt.getText().toString());
                double het = Double.parseDouble(ht.getText().toString());

                //Calculating BMI

                double BMI = wet /(het*het);

                //Determinne BMI category

                String cat;
                if (BMI<18.5){
                    cat = "Underweight";
                    result.setTextColor(Color.parseColor("#FF0000"));
                } else if (BMI>= 18.5 && BMI<=24.9){
                    cat = "Normal";
                    result.setTextColor(Color.parseColor("#00FF00"));
                } else if (BMI >= 25 && BMI <= 29.9) {
                    cat = "Overweight";
                    result.setTextColor(Color.parseColor("#FFFF00"));
                } else {
                    cat = "Obese";
                    result.setTextColor(Color.parseColor("#FF4500"));
                }

                result.setText("Your BMI is: " + String.format("%.2f",BMI) + " and you are " + cat + " ");
            }
        });

    }
}