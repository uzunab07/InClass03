package com.example.inclass03;
//Authors
//Group 14
// Joseph Mauney and Khaled Mohamed Ali

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewName,textViewEmail,textViewId,textViewDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Profile profile = (Profile) getIntent().getSerializableExtra(RegistrationActivity.PROFILE_KEY);
        textViewName =  findViewById(R.id.textViewName);
        textViewEmail =  findViewById(R.id.textViewEmail);
        textViewId =  findViewById(R.id.textViewId);
        textViewDept =  findViewById(R.id.textViewDepte);

        textViewName.setText(profile.getName());
        textViewDept.setText(profile.getDepartment());
        textViewId.setText(profile.getId());
        textViewEmail.setText(profile.getEmail());
    }
}