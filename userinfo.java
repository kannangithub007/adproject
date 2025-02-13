package com.example.adproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class userinfo extends AppCompatActivity {
    private TextView textviewDisplay;
    private ImageButton arrbutton;

    // SharedPreferences name
    private static final String PREF_NAME = "UserInfo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        arrbutton = findViewById(R.id.arrbutton);
        textviewDisplay = findViewById(R.id.textViewDisplay);
        arrbutton.setOnClickListener(view -> {
            Intent intent = new Intent(userinfo.this, homepage.class);
            startActivity(intent);
        });

        // Get the data passed from the front page
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");
        String occupation = getIntent().getStringExtra("occupation");
        String phone = getIntent().getStringExtra("phone");

        // Display the data in the TextView
        String displayText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Occupation: " + occupation + "\n" +
                "Phone: " + phone;

        textviewDisplay.setText(displayText);

        // Save data to SharedPreferences
        saveDataToSharedPreferences(name, email, gender, occupation, phone);

        // Button to go to the homepage
        /*button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userinfo.this, homepage.class);
                startActivity(intent);
            }
        });*/
    }

    // Save data to SharedPreferences
    private void saveDataToSharedPreferences(String name, String email, String gender, String occupation, String phone) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("gender", gender);
        editor.putString("occupation", occupation);
        editor.putString("phone", phone);
        editor.apply();  // Save asynchronously
    }
}