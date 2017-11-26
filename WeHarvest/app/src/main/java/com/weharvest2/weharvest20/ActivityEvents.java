package com.weharvest2.weharvest20;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.weharvest2.weharvest20.beans.Event;
import com.weharvest2.weharvest20.beans.Recipe;
import com.weharvest2.weharvest20.gui.ActivityBase;

import java.util.ArrayList;

public class ActivityEvents extends ActivityBase {

    protected TextView user;
    protected TextView title;
    protected TextView description;
    protected TextView date;
    protected TextView place;
    protected FloatingActionButton createEvent;
    protected ArrayList<Event> events;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        user  = (TextView) findViewById(R.id.activity_events_user);
        title = (TextView) findViewById(R.id.activity_events_title);
        description = (TextView) findViewById(R.id.activity_events_description);
        date = (TextView) findViewById(R.id.activity_events_description);
        place = (TextView) findViewById(R.id.activity_events_place);

        DatabaseReference userDBR = mDatabase.child("events");
        userDBR.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                events = new ArrayList<>();
                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
                for (DataSnapshot event : contactChildren) {
                    Event newEvent = event.getValue(Event.class);
                    events.add(newEvent);
                }

                user.setText(events.get(1).getUsername());
                description.setText(events.get(1).getDescription());
                title.setText(events.get(1).getTitle());
                date.setText(events.get(1).getDate());
                place.setText(events.get(1).getPlace());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
            }
        });
        onCreateDrawer();
    }

    public void createEvent(View view) {
        Intent intent = new Intent(this, ActivityCreateEvent.class);
        startActivity(intent);
    }
}
