package com.rellis.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void goToRegister(View view){
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

        startActivity(intent);
    }

    public void goToManage(View view){

        //Create an Intent in order to launch
        Intent intent = new Intent(getApplicationContext(), ManageActivity.class);

        startActivity(intent);
    }
    public void tryLogin(View view) {

        //SharedPrefer
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.rellis.sharedpreferences", Context.MODE_PRIVATE);

        EditText UsernameEditText = (EditText) findViewById(R.id.emailText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordText);

        String username = UsernameEditText.getText().toString();
        String passwordEntered = passwordEditText.getText().toString();

        String passwordStored = sharedPreferences.getString(username, "");

        Log.i("Infor", "Username is: " + username);
        Log.i("Info", "Password entered is: " + passwordEntered);
        Log.i("Info", "password stored in: " + passwordStored);

        if (passwordStored.equals(passwordEntered)) {
            Toast.makeText(MainActivity.this, "Is your Mother single?", Toast.LENGTH_SHORT).show();
            goToManage(view);
        }

        else {
            Toast.makeText(MainActivity.this, "that's wrong dumby", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.rellis.sharedpreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("cubemaster365@gmail.com", "password").apply();
    }
}
