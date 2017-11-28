package com.weharvest2.weharvest20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weharvest2.weharvest20.beans.Event;
import com.weharvest2.weharvest20.beans.Recipe;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Event> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, place, month, day, date;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.event_name);
            place = (TextView) view.findViewById(R.id.event_place);
            month = (TextView) view.findViewById(R.id.month);
            day = (TextView)view.findViewById(R.id.day);
            date = (TextView)view.findViewById(R.id.event_date);
        }
    }

    public EventAdapter(Context mContext, ArrayList<Event> eventList){
        this.mContext = mContext;
        this.eventList =eventList;
    }

    @Override
    public EventAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);

        return new MyViewHolder(itemView);
    }

    public String getMonthName(String numMonth){
        switch(numMonth){
            case "01":
                return "JAN";

            case "02":
                return "FEB";

            case "03":
                return "MAR";

            case "04":
                return "APR";

            case "05":
                return "MAY";

            case "06":
                return "JUN";

            case "07":
                return "JUL";

            case "08":
                return "AUG";

            case "09":
                return "SEP";

            case "10":
                return "OCT";

            case "11":
                return "NOV";

            case "12":
                return "DEC";

            default:
                return "NO MONTH";
        }
    }

    @Override
    public void onBindViewHolder(EventAdapter.MyViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.title.setText(event.getTitle());
        holder.place.setText(event.getPlace());
        holder.date.setText(event.getDate());

        //CHECAR COMO SE VA A OBTENER MES Y DIA
        holder.month.setText(getMonthName(event.getDate().substring(6,7)));
        holder.day.setText(event.getDate().substring(9,10));

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}