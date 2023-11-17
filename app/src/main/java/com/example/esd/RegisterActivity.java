package com.example.esd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button reg_std;
        Button reg_emp;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        reg_std = findViewById(R.id.reg_std);
        reg_emp = findViewById(R.id.reg_emp);

        reg_std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, StudentRegActivity.class);
                startActivity(intent);
            }
        });

        reg_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, EmployerRegActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy(){
        super .onDestroy();
    }
}
