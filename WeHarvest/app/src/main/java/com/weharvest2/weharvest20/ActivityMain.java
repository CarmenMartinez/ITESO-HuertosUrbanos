package com.weharvest2.weharvest20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.weharvest2.weharvest20.beans.User;
import com.weharvest2.weharvest20.gui.ActivityBase;

public class ActivityMain extends ActivityBase
        implements NavigationView.OnNavigationItemSelectedListener {

    protected TextView usuario;
    protected TextView contenido;
    protected TextView titulo;
    protected TextView fecha;
    protected TextView categoria;
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

        DatabaseReference userDBR = mDatabase.child("posts");
        userDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user != null) {
                    Toast.makeText(getApplicationContext(),
                            user.getUsername() + " " + user.getPassword(),
                            Toast.LENGTH_LONG).show();
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

    }
}
