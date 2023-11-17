package com.example.esd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button start_button_std;
        Button start_button_emp;
        Button start_button_reg;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button_std = findViewById(R.id.start_button_std);
        start_button_emp = findViewById(R.id.start_button_emp);
        start_button_reg = findViewById(R.id.start_button_reg);

        start_button_std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        start_button_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        start_button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onDestroy(){
        super .onDestroy();
    }
}