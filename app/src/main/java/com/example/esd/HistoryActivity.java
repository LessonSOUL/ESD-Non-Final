package com.example.esd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends  AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        Button button_profile;
        Button button_list_documents;
        Button button_list_history;
        Button button_list_need;
        Button button_setting;

        button_profile = findViewById(R.id.button_profile);
        button_list_documents = findViewById(R.id.button_list_documents);
        button_list_history = findViewById(R.id.button_list_history);
        button_list_need = findViewById(R.id.button_list_need);
        button_setting = findViewById(R.id.button_setting);

        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        button_list_documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, ListDocumentsActivity.class);
                startActivity(intent);
            }
        });

        button_list_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
            }
        });

        button_list_need.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, ListNeedActivity.class);
                startActivity(intent);
            }
        });

        button_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onDestroy(){
        super .onDestroy();
    }
}
