package com.example.esd;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{

    DatabaseHelper dbHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        EditText login_line;
        EditText pass_line;
        Button login_button;

        login_line = findViewById(R.id.login_line);
        pass_line = findViewById(R.id.pass_line);
        login_button = findViewById(R.id.login_button);

        dbHelper = new DatabaseHelper(LoginActivity.this);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Login_S = login_line.getText().toString().trim();
                String Password_S = pass_line.getText().toString().trim();

                SQLiteDatabase database = dbHelper.getReadableDatabase();

                cursor = database.query(dbHelper.TABLE_USERS, null, null, null, null, null, null);

                if (cursor.moveToFirst()){
                    int phoneIndex = cursor.getColumnIndex(dbHelper.PHONE);
                    int passwordIndex = cursor.getColumnIndex(dbHelper.PASSWORD);
                    do{
                        if (Login_S.equals(cursor.getString(phoneIndex))) {
                            if (Password_S.equals(cursor.getString(passwordIndex))) {
                                Intent intent = new Intent(LoginActivity.this, HistoryActivity.class);
                                startActivity(intent);
                                break;
                            } else {
                                Toast.makeText(LoginActivity.this, R.string.err_input_pass, Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, R.string.err_input_login, Toast.LENGTH_LONG).show();
                        }
                    } while (cursor.moveToNext());
                }

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
