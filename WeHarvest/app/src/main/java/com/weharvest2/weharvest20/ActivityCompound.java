package com.weharvest2.weharvest20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by luisacfl on 26/11/17.
 */

public class ActivityCompound extends ActivityBase{

    private RecyclerView recyclerView;
    private RecipeFilteredAdapter adapter;
    private ArrayList<Recipe> recipes;
    protected TextView empty;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound);

        onCreateDrawer();

        empty = (TextView) findViewById(R.id.activity_compound_textview);
        recyclerView = (RecyclerView) findViewById (R.id.recycler_view_activity_compound);

        DatabaseReference userDBR = mDatabase.child("recipes");
        userDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipes = new ArrayList<>();
                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
                for (DataSnapshot recipe : contactChildren) {
                    Recipe newRecipe = recipe.getValue(Recipe.class);
                    //AGREGAR AL ARRAYLIST
                    if (newRecipe.getCategory().toString().equals("Compound"))
                        recipes.add(newRecipe);
                }


                Collections.reverse(recipes);

                if (!recipes.isEmpty()) {
                    adapter = new RecipeFilteredAdapter(getApplicationContext(), recipes);

                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);

                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    empty.setText("");
                    empty.setVisibility(View.GONE);
                } else
                    empty.setText("Create Compound recipes to see them here!");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
            }
        });


    }
}
