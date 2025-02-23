package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * this checks if a city is in the list
     * for the first phase it will be empty
     * @param city
     */
    public boolean hasCity(City city) {
        // Compare new city name and province name to existing cities so that we are not checking for
        // an exact instance of an object
        for(int i = 0; i < cities.size(); i++) {
            City cityX = cities.get(i);
            if (cityX.getCityName().compareTo(city.getCityName()) == 0 &&
                    cityX.getProvinceName().compareTo(city.getProvinceName()) == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * this deletes a city from the list
     * for the first phase it will be empty
     * @param city
     *      This is a city to delete from the list which is of type {@link City}.
     *@throws IllegalArgumentException if city is not in the list.
     */
    public void deleteCity(City city) {
        if (this.hasCity(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This function returns the number of cities that are in the list.
     * @return
     *      The number of cities in the list.
     */
    public int countCities() {
        return cities.size();
    }



}
