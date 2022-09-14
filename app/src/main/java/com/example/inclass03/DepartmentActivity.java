package com.example.inclass03;
//Authors
//Group 14
// Joseph Mauney and Khaled Mohamed Ali

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class DepartmentActivity extends AppCompatActivity {

    RadioGroup radioGroupDept;
    RadioButton checkedRadioButton;
    final static public String PROFILE_KEY = "PROFILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departement);
        radioGroupDept = findViewById(R.id.radioGroupeDept);

        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });



        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                checkedRadioButton =(RadioButton) checkedButton();
                if(checkedRadioButton!=null){
                    String department = checkedRadioButton.getText().toString();
                    String name = getIntent().getStringExtra(RegistrationActivity.NAME_KEY);
                    String email = getIntent().getStringExtra(RegistrationActivity.EMAIL_KEY);
                    String id = getIntent().getStringExtra(RegistrationActivity.ID_KEY);
                    Profile profile = new Profile(name,email,id,department);

                    Intent intent = new Intent();
                    intent.putExtra(PROFILE_KEY,profile );
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(DepartmentActivity.this, "Please select a department", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    public View checkedButton(){
        int checkedRadioButtonId = radioGroupDept.getCheckedRadioButtonId();

        RadioButton checkedButton = findViewById(checkedRadioButtonId);

        return checkedButton;
    }
}