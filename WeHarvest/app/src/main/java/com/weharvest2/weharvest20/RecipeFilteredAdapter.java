package com.weharvest2.weharvest20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weharvest2.weharvest20.beans.Recipe;

import java.util.ArrayList;

/**
 * Created by fernando on 30/11/17.
 */

public class RecipeFilteredAdapter extends RecyclerView.Adapter<RecipeFilteredAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Recipe> recipeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, username, date, category;

        public MyViewHolder(View view){
            super(view);
            username = (TextView) view.findViewById(R.id.username);
            date = (TextView) view.findViewById(R.id.date);
            title = (TextView)view.findViewById(R.id.title);
            description = (TextView)view.findViewById(R.id.description);
            category = (TextView) view.findViewById(R.id.category);
        }
    }

    public RecipeFilteredAdapter(Context mContext, ArrayList<Recipe> recipeList){
        this.mContext = mContext;
        this.recipeList =recipeList;
    }

    @Override
    public RecipeFilteredAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe_filtered, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeFilteredAdapter.MyViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.title.setText(recipe.getRecipeTitle());
        holder.description.setText(recipe.getDescription());
        holder.username.setText("@"+recipe.getUser());
        holder.date.setText(recipe.getDate());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}