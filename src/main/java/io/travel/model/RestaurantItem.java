package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDateTime;

public class RestaurantItem extends ItineraryItem {

    private String name;
    private String cuisine;
    private LocalDateTime dateTime;
    private int  numberOfGuests;
    private int estimatedCostPerGuest;

    public RestaurantItem() {
        //No argument constructor
    }

    public RestaurantItem(int dayNumber, ItemType itemType,  int actualCost, String name, String cuisine, LocalDateTime dateTime, int numberOfGuests, int estimatedCostPerGuest) {
        super(dayNumber, itemType, actualCost);
        this.name = name;
        this.cuisine = cuisine;
        this.dateTime = dateTime;
        this.numberOfGuests = numberOfGuests;
        this.estimatedCostPerGuest = estimatedCostPerGuest;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
}
