package com.weharvest2.weharvest20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weharvest2.weharvest20.beans.Plant;

import java.util.ArrayList;

/**
 * Created by luisacfl on 30/11/17.
 */

public class SinglePlantAdapter extends RecyclerView.Adapter<SinglePlantAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Plant> plantList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, period, months, description;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.plant_title);
            months = (TextView) view.findViewById(R.id.months_to_sow);
            period = (TextView)view.findViewById(R.id.period);
            description = (TextView)view.findViewById(R.id.description);
        }
    }

    public SinglePlantAdapter(Context mContext, ArrayList<Plant> plantList){
        this.mContext = mContext;
        this.plantList =plantList;
    }

    @Override
    public SinglePlantAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_card_view, parent, false);

        return new SinglePlantAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SinglePlantAdapter.MyViewHolder holder, int position) {
        Plant plant = plantList.get(position);
        String monthStrings = "";
        //ControlMonth cm = new ControlMonth(plant.getPlantName(), dh);
        holder.title.setText(plant.getPlantName());
        holder.period.setText(plant.getPeriod());
        if(plant.getMonths()==null){
            holder.months.setText("No months");
        }
        else {
            for (int i = 0; i < plant.getMonths().size(); i++) {
                monthStrings += plant.getMonths().get(i).getMonthName() + ", ";
            }
            holder.months.setText(monthStrings.substring(0, monthStrings.length() - 2));
        }
        holder.description.setText(plant.getDescription());
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }
}