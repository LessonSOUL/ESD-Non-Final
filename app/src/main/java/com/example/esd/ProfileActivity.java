package com.example.esd;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        TextView profile_name;
        TextView profile_voz;
        TextView profile_phone;
        TextView profile_mk;

        profile_name = findViewById(R.id.profile_name);
        profile_voz = findViewById(R.id.profile_voz);
        profile_phone = findViewById(R.id.profile_phone);
        profile_mk = findViewById(R.id.profile_mk);

        dbHelper = new DatabaseHelper(ProfileActivity.this);

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        cursor = database.query(dbHelper.TABLE_USERS, null, null, null, null, null, null);

        if (cursor.moveToFirst()){
            int phoneIndex = cursor.getColumnIndex(dbHelper.PHONE);
            int NLSIndex = cursor.getColumnIndex(dbHelper.NLS);
            int VOZIndex = cursor.getColumnIndex(dbHelper.VOZ);
            int MKIndex = cursor.getColumnIndex(dbHelper.MK);

            profile_name.setText(cursor.getString(NLSIndex));
            profile_voz.setText(cursor.getString(VOZIndex));
            profile_phone.setText(cursor.getString(phoneIndex));
            profile_mk.setText(cursor.getString(MKIndex));

        }

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
                ;
            }
        });

        button_list_documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ListDocumentsActivity.class);
                startActivity(intent);
            }
        });

        button_list_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        button_list_need.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ListNeedActivity.class);
                startActivity(intent);
            }
        });

        button_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy(){
        super .onDestroy();
        dbHelper.close();
        cursor.close();
    }
}
