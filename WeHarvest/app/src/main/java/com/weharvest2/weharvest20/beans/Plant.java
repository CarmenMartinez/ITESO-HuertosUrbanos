package com.weharvest2.weharvest20.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class Plant implements Parcelable{
    private int idPlant;
    private String plantName;
    private String period;
    ArrayList<Month> months;
    private String description;

    public Plant(){

    }

    public Plant(int idPlant, String plantName, String period, ArrayList<Month> months, String description) {
        this.idPlant = idPlant;
        this.plantName = plantName;
        this.period = period;
        this.months = months;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Plant(Parcel in) {
        idPlant = (Integer) in.readValue(Integer.class.getClassLoader());
        plantName = in.readString();
        period = in.readString();
        months = in.createTypedArrayList(Month.CREATOR);
        description = in.readString();
    }

    public static final Creator<Plant> CREATOR = new Creator<Plant>() {
        @Override
        public Plant createFromParcel(Parcel in) {
            return new Plant(in);
        }

        @Override
        public Plant[] newArray(int size) {
            return new Plant[size];
        }
    };

    public ArrayList<Month> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<Month> months) {
        this.months = months;
    }

    public int getIdPlant() {

        return idPlant;
    }

    public void setIdPlant(int idPlant) {
        this.idPlant = idPlant;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idPlant);
        dest.writeString(plantName);
        dest.writeString(period);
        dest.writeTypedList(months);
        dest.writeString(description);
    }
}
