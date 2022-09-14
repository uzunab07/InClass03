package com.example.inclass03;
//Authors
//Group 14
// Joseph Mauney and Khaled Mohamed Ali

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText editTextName,editTextEmail,editTextId;
    String name,email,id;
    TextView textViewDepartment;
    final static public String NAME_KEY ="NAME", EMAIL_KEY = "EMAIL",ID_KEY="ID", PROFILE_KEY = "PROFILE";
    final static public int REQ_CODE = 100;
    Profile returnedProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);




        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextId = findViewById(R.id.editTextId);
        textViewDepartment = findViewById(R.id.textViewDepartment);

        findViewById(R.id.buttonSelect_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = editTextName.getText().toString();
                email = editTextEmail.getText().toString();
                id = editTextId.getText().toString();

                if (id.isEmpty() || name.isEmpty() || email.isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Please Insert the Name/Id/Department", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(RegistrationActivity.this,DepartmentActivity.class);

                    intent.putExtra(NAME_KEY,name);
                    intent.putExtra(EMAIL_KEY,email);
                    intent.putExtra(ID_KEY,id);

                    startActivityForResult(intent,REQ_CODE);
                }


            }
        });
        findViewById(R.id.buttonSubmit_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(RegistrationActivity.this,ProfileActivity.class);
                if(returnedProfile!=null){
                    intent.putExtra(PROFILE_KEY,returnedProfile);
                    startActivity(intent);
                }else {
                    Toast.makeText(RegistrationActivity.this, "Please complete the for before proceeding", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(data!= null && data.hasExtra(DepartmentActivity.PROFILE_KEY)){
                returnedProfile   = (Profile) data.getSerializableExtra(DepartmentActivity.PROFILE_KEY);
                textViewDepartment.setText(returnedProfile.getDepartment());
            }

        }else if(resultCode== RESULT_CANCELED){
            Toast.makeText(this, "onActivityResult: The user cancel without returning any data", Toast.LENGTH_SHORT).show();
        }

    }
}