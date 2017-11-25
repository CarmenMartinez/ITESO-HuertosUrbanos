package com.weharvest2.weharvest20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.weharvest2.weharvest20.beans.Session;
import com.weharvest2.weharvest20.beans.User;

public class ActivityLogin extends AppCompatActivity {

    protected EditText username;
    protected EditText password;
    protected Button signin;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.activity_login_username);
        password = (EditText) findViewById(R.id.activity_login_pwd);
        signin = (Button) findViewById(R.id.activity_login_signin);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_login_signin:
                DatabaseReference userDBR = mDatabase.child("users").child(username.getText().toString());
                userDBR.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        if (user != null) {
                            Toast.makeText(getApplicationContext(),
                                    user.getUsername() + " " + user.getPassword(),
                                    Toast.LENGTH_LONG).show();
                            Session.setUserSession(user);
                            Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "USUARIO NO VALIDO", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
                    }
                });

                /*User user = new User();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.savePreferences(this);*/
                break;

            case R.id.activity_create_account:
                Intent intentCreateAccount = new Intent(this, ActivityCreateAccount.class);
                startActivity(intentCreateAccount);
                finish();
                break;
        }
    }
}
