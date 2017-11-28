package com.weharvest2.weharvest20;

import android.support.v7.widget.RecyclerView;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.weharvest2.weharvest20.beans.Event;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.weharvest2.weharvest20.beans.Event;
import com.weharvest2.weharvest20.gui.ActivityBase;

import java.util.ArrayList;

public class ActivityEvents extends ActivityBase {

    private RecyclerView recyclerView;
    private EventAdapter adapter;

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
        date = (TextView) findViewById(R.id.activity_events_date);
        place = (TextView) findViewById(R.id.activity_events_place);
        createEvent = (FloatingActionButton) findViewById(R.id.activity_events_create);

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view_activity_seeds);

        DatabaseReference userDBR = mDatabase.child("events");
        userDBR.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                events = new ArrayList<>();
                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
                for (DataSnapshot event : contactChildren) {
                    Event newEvent = event.getValue(Event.class);
                    events.add(newEvent);
                    user.setText(newEvent.getUsername());
                    description.setText(newEvent.getDescription());
                    title.setText(newEvent.getTitle());
                    date.setText(newEvent.getDate());
                    place.setText(newEvent.getPlace());
                }
                if(events.isEmpty()){
                    user.setText("No hay eventos");
                }

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
