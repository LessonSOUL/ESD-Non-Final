package com.example.esd;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EmployerRegActivity extends  AppCompatActivity{

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText NLS;
        EditText VOZ;
        EditText Special;
        EditText Login;
        EditText Password;

        Button Register;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_reg_activity);

        NLS = findViewById(R.id.NLS);
        VOZ = findViewById(R.id.VOZ);
        Special = findViewById(R.id.Special);
        Login = findViewById(R.id.Login);
        Password = findViewById(R.id.Password);
        Register = findViewById(R.id.Register);

        dbHelper = new DatabaseHelper(EmployerRegActivity.this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NLS_S = NLS.getText().toString().trim();
                String VOZ_S = VOZ.getText().toString().trim();
                String Special_S = Special.getText().toString().trim();
                String Login_S = Login.getText().toString().trim();
                String Password_S = Password.getText().toString().trim();
                String Group_S = "NULL";
                String MK_S = "Employer";

                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

                contentValues.put(dbHelper.PHONE, Login_S);
                contentValues.put(dbHelper.PASSWORD, Password_S);
                contentValues.put(dbHelper.NLS, NLS_S);
                contentValues.put(dbHelper.VOZ, VOZ_S);
                contentValues.put(dbHelper.Special, Special_S);
                contentValues.put(dbHelper.Grp, Group_S);
                contentValues.put(dbHelper.MK, MK_S);

                database.insert(dbHelper.TABLE_USERS, null, contentValues);

                Intent intent = new Intent(EmployerRegActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy(){
        super .onDestroy();
        dbHelper.close();
    }
}
