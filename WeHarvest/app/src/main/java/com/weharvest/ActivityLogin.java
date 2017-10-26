package com.weharvest;

import com.weharvest.beans.User;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class ActivityLogin extends AppCompatActivity {

    protected EditText username;
    protected EditText password;
    protected Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.activity_login_username);
        password = (EditText) findViewById(R.id.activity_login_password);
        signin = (Button) findViewById(R.id.activity_login_signin);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_login_signin:
                User user = new User();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.savePreferences(this);

                Intent intent = new Intent(this, ActivityMain.class);
                startActivity(intent);
                finish();
                break;
            case R.id.activity_login_create_account:
                Intent intentCreateAccount = new Intent(this, ActivityCreateAccount.class);
                startActivity(intentCreateAccount);
                finish();
                break;

        }
    }
}
