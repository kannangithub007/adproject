/*
package com.example.adproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class profileFragment extends Fragment {

    private TextView UserInfo2;
    private static final String PREF_NAME = "UserInfo";
    // ✅ Required empty constructor for Fragment recreation
    public profileFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        UserInfo2 = view.findViewById(R.id.UserInfo2);

        // Load and display saved data from SharedPreferences
        loadDataFromSharedPreferences();

        return view;
    }

    // Method to load data from SharedPreferences
    private void loadDataFromSharedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "No Name");
        String email = sharedPreferences.getString("email", "No Email");
        String gender = sharedPreferences.getString("gender", "No Gender");
        String occupation = sharedPreferences.getString("occupation", "No Occupation");
        String phone = sharedPreferences.getString("phone", "No Phone");

        // Display the data in the TextView
        String displayText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Occupation: " + occupation + "\n" +
                "Phone: " + phone;

        UserInfo2.setText(displayText);

    }
}*/

package com.example.adproject;  // Make sure this matches your package name

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class profileFragment extends Fragment {  // ✅ Ensure it's a standalone public class

    private TextView UserInfo2;
    private static final String PREF_NAME = "UserInfo";

    public profileFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        UserInfo2 = view.findViewById(R.id.UserInfo2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadDataFromSharedPreferences();
    }

    private void loadDataFromSharedPreferences() {
        if (getActivity() == null) return;

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "No Name");
        String email = sharedPreferences.getString("email", "No Email");
        String gender = sharedPreferences.getString("gender", "No Gender");
        String occupation = sharedPreferences.getString("occupation", "No Occupation");
        String phone = sharedPreferences.getString("phone", "No Phone");

        String displayText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Occupation: " + occupation + "\n" +
                "Phone: " + phone;

        UserInfo2.setText(displayText);
    }
}

