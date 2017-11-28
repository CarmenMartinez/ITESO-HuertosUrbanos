package com.weharvest2.weharvest20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weharvest2.weharvest20.beans.Event;
import com.weharvest2.weharvest20.beans.Session;

public class ActivityCreateEvent extends AppCompatActivity {

    protected EditText title;
    protected EditText description;
    protected EditText date;
    protected EditText place;
    protected Button createEvent;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("events");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        title = (EditText) findViewById(R.id.activity_create_event_title);
        description = (EditText) findViewById(R.id.activity_create_event_description);
        date = (EditText) findViewById(R.id.activity_create_event_date);
        place = (EditText) findViewById(R.id.activity_create_event_place);
        createEvent = (Button) findViewById(R.id.activity_create_event);

    }

    public void createNewEvent(View view){
        String postId = mDatabase.push().getKey();
        if(title.getText().toString().isEmpty()){
            title.setError("This field cannot be blank");
        }else if(description.getText().toString().isEmpty()){
            description.setError("This field cannot be blank");
        }else if(date.getText().toString().isEmpty()){
            date.setError("This field cannot be blank");
        }else if(place.getText().toString().isEmpty()){
            place.setError("This field cannot be blank");
        }
        else {
            Event event = new Event(Session.getUserSession().getUsername().toString(), title.getText().toString(), description.getText().toString(), date.getText().toString(), place.getText().toString());
            mDatabase.child(postId).setValue(event);
            Intent intent = new Intent(this, ActivityEvents.class);
            startActivity(intent);
            finish();
        }

    }
}