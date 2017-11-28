package com.weharvest2.weharvest20;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weharvest2.weharvest20.beans.Recipe;
import com.weharvest2.weharvest20.beans.Session;
import com.weharvest2.weharvest20.beans.User;
import com.weharvest2.weharvest20.gui.ActivityBase;

import java.sql.Date;
import java.sql.Time;

import static android.R.attr.password;

public class ActivityCreateRecipe extends ActivityBase {

    protected Spinner spinner;
    protected Button button;
    protected EditText title;
    protected EditText content;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("recipes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        onCreateDrawer();

        title = (EditText) findViewById(R.id.activity_create_recipe_title);
        content = (EditText) findViewById(R.id.activity_create_recipe_content);

        spinner = (Spinner) findViewById(R.id.activity_create_recipe_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_recipes, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void createNewRecipe(View v){
        try {
            if (title.getText().toString().equals(""))
                title.setError("This field cannot be blank");//TODO cambiar texto por string
            else if (content.getText().toString().equals(""))
                content.setError("Please make a body to the publication");//TODO cambiar texto por string
            else {
                String postId = mDatabase.push().getKey();
                Recipe recipe = new Recipe(Session.getUserSession().getUsername(), title.getText().toString(), content.getText().toString(), "26/09/1996", spinner.getSelectedItem().toString());
                //TODO check the activity.
                //Options: ActivityRecipes or ActivityMain
                Intent intent = new Intent(this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        }
        catch(Exception e) {

        }

    }

}
