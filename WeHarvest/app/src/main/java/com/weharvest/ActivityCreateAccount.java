package com.weharvest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weharvest.beans.User;

public class ActivityCreateAccount extends AppCompatActivity {
    protected EditText username;
    protected EditText password;
    protected EditText confirmPassword;
    protected Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        username = (EditText) findViewById(R.id.activity_create_account_username);
        password = (EditText) findViewById(R.id.activity_create_account_password);
        confirmPassword = (EditText) findViewById(R.id.activity_create_account_confirm_password);
        signup = (Button) findViewById(R.id.activity_create_account_signup);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_create_account_signup:
                //TODO Check password and confirm password
                User user = new User();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.savePreferences(this);

                Intent intentCreateAccount = new Intent(this, ActivityMain.class);
                startActivity(intentCreateAccount);
                finish();
                break;

        }
    }
}
