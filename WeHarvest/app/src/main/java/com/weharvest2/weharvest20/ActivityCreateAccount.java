package com.weharvest2.weharvest20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weharvest2.weharvest20.beans.User;

public class ActivityCreateAccount extends AppCompatActivity {
    protected EditText username;
    protected EditText password;
    protected EditText confirmPassword;
    protected EditText email;
    protected Button signup;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        username = (EditText) findViewById(R.id.activity_create_account_username);
        password = (EditText) findViewById(R.id.activity_create_account_password);
        confirmPassword = (EditText) findViewById(R.id.activity_create_account_confirm_password);
        email = (EditText) findViewById(R.id.activity_create_account_email);
        signup = (Button) findViewById(R.id.activity_create_account_signup);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_create_account_signup:
                //TODO Check password and confirm password
                String userId = mDatabase.push().getKey();

                User user = new User(username.getText().toString(), password.getText().toString(), email.getText().toString());
                user.savePreferences(this);

                mDatabase.child(userId).setValue(user);
                Intent intentCreateAccount = new Intent(this, ActivityMain.class);
                startActivity(intentCreateAccount);
                finish();
                break;

        }
    }
}
