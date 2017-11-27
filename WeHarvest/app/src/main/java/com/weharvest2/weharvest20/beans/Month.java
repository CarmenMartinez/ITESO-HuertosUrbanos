package com.weharvest2.weharvest20.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class Month implements Parcelable{
    private int idMonth;
    private String monthName;

    private ArrayList<Plant> plants;

    public Month(){

    }
    public Month(int idMonth, String monthName, ArrayList<Plant> plants) {
        this.idMonth = idMonth;
        this.monthName = monthName;
        this.plants = plants;
    }

    protected Month(Parcel in) {
        idMonth = (Integer) in.readValue(Integer.class.getClassLoader());
        monthName = in.readString();
        plants = in.createTypedArrayList(Plant.CREATOR);
    }

    public static final Creator<Month> CREATOR = new Creator<Month>() {
        @Override
        public Month createFromParcel(Parcel in) {
            return new Month(in);
        }

        @Override
        public Month[] newArray(int size) {
            return new Month[size];
        }
    };

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public int getIdMonth() {

        return idMonth;
    }

    public void setIdMonth(int idMonth) {
        this.idMonth = idMonth;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idMonth);
        dest.writeString(this.monthName);

        dest.writeTypedList(this.plants);
    }
}
