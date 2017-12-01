package com.weharvest2.weharvest20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weharvest2.weharvest20.beans.Plant;
import com.weharvest2.weharvest20.database.ControlMonth;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Plant> plantList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, period, months;

        public MyViewHolder(View view){
            super(view);
            //id = (TextView) view.findViewById(R.id.id);
            title = (TextView) view.findViewById(R.id.title);
            period = (TextView) view.findViewById(R.id.period);
            months = (TextView)view.findViewById(R.id.months);
        }
    }

    public PlantAdapter(Context mContext, ArrayList<Plant> plantList){
        this.mContext = mContext;
        this.plantList =plantList;
    }

    @Override
    public PlantAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_plant, parent, false);

        return new PlantAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlantAdapter.MyViewHolder holder, int position) {
        Plant plant = plantList.get(position);
        String monthStrings = "Month: ";
        //ControlMonth cm = new ControlMonth(plant.getPlantName(), dh);
        holder.title.setText(plant.getPlantName());
        holder.period.setText(plant.getPeriod());
        if(plant.getMonths()==null){
            holder.months.setText("");
        }
        else {
            for (int i = 0; i < plant.getMonths().size(); i++) {
                monthStrings += plant.getMonths().get(i).getMonthName() + ", ";
            }
            holder.months.setText(monthStrings.substring(0, monthStrings.length() - 2));
        }
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }
}
