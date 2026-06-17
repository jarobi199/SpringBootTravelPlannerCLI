package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDateTime;

public class RestaurantItem extends ItineraryItem {

    private String name;
    private String cuisine;
    private int  numberOfGuests;
    private int estimatedCostPerGuest;

    public RestaurantItem() {
        //No argument constructor
    }

    public RestaurantItem(LocalDateTime dateTime, ItemType itemType,  int estimatedCostPerGuest, String name, String cuisine, int numberOfGuests) {
        super(dateTime, itemType);
        this.estimatedCostPerGuest = estimatedCostPerGuest;
        this.name = name;
        this.cuisine = cuisine;
        this.dateTime = dateTime;
        this.numberOfGuests = numberOfGuests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getEstimatedCostPerGuest() {
        return estimatedCostPerGuest;
    }

    public void setEstimatedCostPerGuest(int estimatedCostPerGuest) {
        this.estimatedCostPerGuest = estimatedCostPerGuest;
    }

    @Override
    public int getEstimatedCost() {
        return numberOfGuests * estimatedCostPerGuest;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Name: " + name + "\n" +
                "Cuisine: " + cuisine + "\n" +
                "Number of guests: " + numberOfGuests + "\n" +
                "Estimated cost per guest: " + estimatedCostPerGuest;
    }
}
