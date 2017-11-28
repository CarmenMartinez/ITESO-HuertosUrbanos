package com.weharvest2.weharvest20;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class ActivityGround extends ActivityBase {
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private ArrayList<Recipe> recipes;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground);

        onCreateDrawer();

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view_activity_ground);

        DatabaseReference userDBR = mDatabase.child("recipes");
        userDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipes = new ArrayList<>();
                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
                for (DataSnapshot recipe : contactChildren) {
                    Recipe newRecipe = recipe.getValue(Recipe.class);
                    //AGREGAR AL ARRAYLIST
                    if (newRecipe.getCategory().toString().equals("Ground"))
                        recipes.add(newRecipe);
                }

                Collections.reverse(recipes);

                adapter = new RecipeAdapter(getApplicationContext(), recipes);
                //adapter = new RecipeAdapter(this, recipeList);

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


        /*
        Aquí recibiría la lista en donde estan guardadas las recetas
        y agregaria al arraylist local las que sean iguales a la categoria
        luego ya las imprimiría
         */

    }

}
