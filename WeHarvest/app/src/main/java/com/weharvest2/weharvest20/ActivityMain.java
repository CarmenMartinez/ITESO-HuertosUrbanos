package com.weharvest2.weharvest20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
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

public class ActivityMain extends ActivityBase
        implements NavigationView.OnNavigationItemSelectedListener {

    protected TextView usuario;
    protected TextView contenido;
    protected TextView titulo;
    protected TextView fecha;
    protected TextView categoria;
    protected FloatingActionButton create;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreateDrawer();

        usuario = (TextView) findViewById(R.id.activity_main_usuario);
        titulo = (TextView) findViewById(R.id.activity_main_titulo);
        contenido = (TextView) findViewById(R.id.activity_main_contenido);
        fecha = (TextView) findViewById(R.id.activity_main_fecha);
        categoria = (TextView) findViewById(R.id.activity_main_categoria);
        create = (FloatingActionButton) findViewById(R.id.activity_main_create);


        DatabaseReference userDBR = mDatabase.child("recipes");
        userDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
                for (DataSnapshot contact : contactChildren) {
                    Recipe recipe = contact.getValue(Recipe.class);
                    Toast.makeText(getApplicationContext(),
                            recipe.getUser() + " " + recipe.getContenido(),
                            Toast.LENGTH_LONG).show();
                    usuario.setText(recipe.getUser());
                    recipe.setContenido(recipe.getContenido());

                }
                /*Recipe recipe = dataSnapshot.getValue(Recipe.class);
                if (recipe != null) {
                    Toast.makeText(getApplicationContext(),
                            user.getUsername() + " " + user.getPassword(),
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    Toast.makeText(getApplicationContext(), "USUARIO NO VALIDO", Toast.LENGTH_LONG).show();
                }*/

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
