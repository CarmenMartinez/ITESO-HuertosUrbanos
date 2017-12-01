package com.weharvest2.weharvest20.database;

import com.weharvest2.weharvest20.beans.Month;
import com.weharvest2.weharvest20.beans.Plant;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luisacfl on 27/11/17.
 */

public class DBManager {
    private static ArrayList<Month> monthList = new ArrayList<>();
    private static ArrayList<Plant> plantList = new ArrayList<>();
    private static ArrayList<Integer[]> relationsList = new ArrayList<>();


    private DataBaseHandler dh;
    private ControlRelationships cr;
    private ControlMonth cm;
    private ControlPlant cp;

    String mode;

    HashMap<Integer, ArrayList<Integer>> relations = new HashMap<>();
    HashMap<Month, ArrayList<Plant>> relationsMonthPlant = new HashMap<>();

    //HashMap<Plant, ArrayList<Month>> relationsPlantMonth = new HashMap<>();

    //plant.setMonths(cm.getAllMonthsByPlant(plant.getPlantName(), dh));

    public DBManager(DataBaseHandler dh, String mode){
        this.dh = dh;
        this.mode = mode;
        cm = new ControlMonth(dh);
        cp = new ControlPlant(dh);
        cr = new ControlRelationships(dh, mode);

        monthList = cm.getMonths();
        plantList = cp.getPlants();
        relationsList = cr.getAllRelationships(dh);
        fillRelationsOnHashMap();

        setPlantListOfMonth();
        setMonthListOfPlant();
    }

    public void fillRelationsOnHashMap(){
        ArrayList<Integer> plants;
        int intRelationsValue;
        for(int i=0; i<relationsList.size(); i++){
            if(relations.get(relationsList.get(i)[0])!=null) {
                plants = relations.get(relationsList.get(i)[0]);
            }
            else {
                plants = new ArrayList<Integer>();
            }
            plants.add(relationsList.get(i)[1]);
            intRelationsValue= (Integer)relationsList.get(i)[0];
            relations.put(relationsList.get(i)[0], plants);
        }
    }
    //cm.getMonthById(intRelationsValue, dh)
    public void setPlantListOfMonth(){
        /*if (monthList == null) {
            fillRelationsOnHashMap();
        }*/
        ArrayList<Plant> plants = new ArrayList<>();
        //Recorre el hashmap de las relaciones en donde la llave es el mes
        for(int i=0; i<relations.size(); i++){
            //recorre el array list que es el value del hashmap que se creó
            for(int j=0; j<relations.get(monthList.get(i).getIdMonth()).size(); j++){
                //Checa si existe  no la llave y asigna el arraylist, si no, lo crea
                //if(relationsMonthPlant.get(monthList.get(i))!=null){

                //agrega la planta a la lista
                plants.add(cp.getPlantById(relations.get(monthList.get(i).getIdMonth()).get(j)));
            }
            //agrega el valor al nuevo hash map
            relationsMonthPlant.put(monthList.get(i), plants);
            plants = new ArrayList<Plant>();
        }

    }

    public void setMonthListOfPlant(){
        for(int i=0; i< plantList.size(); i++){
            plantList.get(i).setMonths(getMonthListFromPlant(plantList.get(i)));
        }
    }
    public ArrayList<Month> getMonthListFromPlant(Plant p) {
        //HashMap<Month, ArrayList<Plant>> rMP = relationsMonthPlant;
        ArrayList<Month> months = new ArrayList<>();
        for(Month key : relationsMonthPlant.keySet()){
            //recorre todas las listas de cada mes
            for(int i=0; i<relationsMonthPlant.get(key).size(); i++){
                if(relationsMonthPlant.get(key).get(i).getPlantName().equals(p.getPlantName())){
                    months.add(key);
                    break;
                }
            }
        }
        return months;
    }
    public ArrayList<Plant> getPlantListFromMonth(Month m){
        HashMap<Month, ArrayList<Plant>> rMP = relationsMonthPlant;
        ArrayList<Plant> plants;
        plants=rMP.get(m);
        return plants;

    }
    public ArrayList<Plant> getPlantList(){
        return plantList;
    }

    public Month getMonthById(int idMonth){
        return cm.getMonthById(idMonth);
    }

    public Month getMonthByName(String name){
        for(int i=0; i<monthList.size(); i++){
            if(monthList.get(i).getMonthName().equals(name)){
                return monthList.get(i);
            }
        }
        return null;
    }

    public Plant getPlantByName(String name){
        for(int i=0; i<plantList.size(); i++){
            if(plantList.get(i).getPlantName().equals(name)){
                return plantList.get(i);
            }
        }
        return null;
    }

}
