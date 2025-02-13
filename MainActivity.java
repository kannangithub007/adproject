package com.example.adproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find the button by ID
        Button button = findViewById(R.id.button);

        // Set click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate from MainActivity to LoginPage
                Intent intent = new Intent(MainActivity.this,Loginpage.class);
                startActivity(intent);
            }
        });
    }
}
