package com.weharvest2.weharvest20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.weharvest2.weharvest20.beans.Recipe;
import com.weharvest2.weharvest20.gui.ActivityBase;

import java.util.ArrayList;
import java.util.Collections;

public class ActivityMain extends ActivityBase
        implements NavigationView.OnNavigationItemSelectedListener {

    protected FloatingActionButton create;
    protected ArrayList<Recipe> recipes;
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreateDrawer();

        create = (FloatingActionButton) findViewById(R.id.activity_main_create);
        recyclerView = (RecyclerView) findViewById (R.id.recycler_view_activity_main);


        DatabaseReference userDBR = mDatabase.child("recipes");
        userDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipes = new ArrayList<>();
                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
                for (DataSnapshot recipe : contactChildren) {
                    Recipe newRecipe = recipe.getValue(Recipe.class);
                    //AGREGAR AL ARRAYLIST
                    recipes.add(newRecipe);
                }

                Collections.reverse(recipes);

                adapter = new RecipeAdapter(getApplicationContext(), recipes);

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

    public void createRecipe(View view) {
        Intent intent = new Intent(this, ActivityCreateRecipe.class);
        startActivity(intent);
    }
}
