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
import java.util.Calendar;
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
                Calendar calendar = Calendar.getInstance();

                int thisYear = calendar.get(Calendar.YEAR);
                int thisMonth = calendar.get(Calendar.MONTH);
                int thisDay = calendar.get(Calendar.DAY_OF_MONTH);

                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
                for (DataSnapshot event : contactChildren) {
                    Event newEvent = event.getValue(Event.class);
                    String eventDate = newEvent.getDate();
                    int eventYear = Integer.parseInt(eventDate.substring(6));
                    int eventMonth = Integer.parseInt(eventDate.substring(3,5));
                    int eventDay = Integer.parseInt(eventDate.substring(0,2));
                    if (thisYear < eventYear || (thisYear == eventYear && thisMonth < eventMonth)
                            || (thisYear == eventYear && thisMonth == eventMonth && thisDay == eventDay))
                        events.add(newEvent);

                }
                Collections.reverse(events);
                Collections.sort(events, new EventsComparator());

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
