package com.example.lab8;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertAll( "Testing deletion of city",
                ()-> assertFalse(list.hasCity(city)),
                ()-> assertThrows(IllegalArgumentException.class, ()->{list.deleteCity(city);})
        );

    }

    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(0, list.countCities());
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertEquals(1, list.countCities());
        list.deleteCity(city);
        assertEquals(0, list.countCities());
    }



}
