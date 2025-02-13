package com.example.adproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Loginpage extends AppCompatActivity {
    private EditText edit1, edit2, edit3;
    private RadioGroup radiogroup1;
    private CheckBox check1, check2, check3;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginpage.this,homepage.class);
                startActivity(intent);

            }
        });// Ensure correct layout file

        // Initialize UI components
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        radiogroup1 = findViewById(R.id.radiogroup1);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        button2 = findViewById(R.id.button2);

        // Debugging: Check if button2 is null


        // Handle button click - Navigate to userinfo activity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = edit1.getText().toString();
                String Mail = edit2.getText().toString();
                String Phone = edit3.getText().toString();


                int selectedGenderId = radiogroup1.getCheckedRadioButtonId();
                RadioButton selectedGenderButton = findViewById(selectedGenderId);
                String Gender = selectedGenderButton.getText().toString();




                StringBuilder Occupation = new StringBuilder();
                if (check1.isChecked()) Occupation.append("Student ");
                if (check2.isChecked()) Occupation.append("Working ");
                if (check3.isChecked()) Occupation.append("Freelancer ");

                // Start the next activity (userinfo.java)
                Intent intent = new Intent(Loginpage.this, homepage.class);
                intent.putExtra("name", Name);
                intent.putExtra("email", Mail);
                intent.putExtra("phone", Phone);
                intent.putExtra("gender", Gender);
                intent.putExtra("occupation", Occupation.toString().trim());

                startActivity(intent);  // Navigate to userinfo.java
            }
        });
    }
}

