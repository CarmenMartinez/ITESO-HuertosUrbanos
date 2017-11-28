package com.weharvest2.weharvest20;

import android.support.v7.widget.LinearLayoutManager;
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
import java.util.Collections;

public class ActivityEvents extends ActivityBase {

    private RecyclerView recyclerView;
    private EventAdapter adapter;
    protected FloatingActionButton createEvent;
    protected ArrayList<Event> events;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        onCreateDrawer();

        createEvent = (FloatingActionButton) findViewById(R.id.activity_events_create);
        recyclerView = (RecyclerView) findViewById (R.id.recycler_view_activity_events);

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
                Collections.reverse(events);


                adapter = new EventAdapter(getApplicationContext(), events);

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);

                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void createEvent(View view) {
        Intent intent = new Intent(this, ActivityCreateEvent.class);
        startActivity(intent);
    }
}
