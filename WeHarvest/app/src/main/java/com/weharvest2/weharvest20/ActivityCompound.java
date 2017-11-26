package com.weharvest2.weharvest20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.weharvest2.weharvest20.beans.Recipe;
import com.weharvest2.weharvest20.gui.ActivityBase;

import java.util.ArrayList;

/**
 * Created by luisacfl on 26/11/17.
 */

public class ActivityCompound extends ActivityBase{

        private RecyclerView recyclerView;
        private RecipeAdapter adapter;
        private ArrayList<Recipe> recipeList;

    /*public ActivitySeeds(Recipes r){
        recipes=r;
    }*/


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_compound);

            onCreateDrawer();

            recyclerView = (RecyclerView) findViewById (R.id.recycler_view);

            recipeList = new ArrayList<>();



            adapter = new RecipeAdapter(this, recipeList);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);

            recyclerView.setAdapter(adapter);

            //recipeList=recipes.getRecipes();
            prepareRecipes();

        }

        public void prepareRecipes() {
            String user = "luisa";
            String c = "Compound";

            Recipe r = new Recipe(user, "Compound", "Solo plantalas", "12/12/17", c);
            recipeList.add(r);
            Recipe r2 = new Recipe(user, "holsdfasdfaaaaa", "Solo AMA LA FREAKING LECTURA", "12/12/17", c);
            recipeList.add(r2);
            Recipe r3 = new Recipe(user, "hsoiajSDIJADF", "DIVERSION", "12/12/17", c);
            recipeList.add(r3);
            adapter.notifyDataSetChanged();
            /*
            Aquí recibiría la lista en donde estan guardadas las recetas
            y agregaria al arraylist local las que sean iguales a la categoria
            luego ya las imprimiría
            */
        }
}
