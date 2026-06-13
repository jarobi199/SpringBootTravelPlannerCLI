package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDateTime;

public class ActivityItem extends ItineraryItem {

    private String name;
    private String venue;
    private LocalDateTime dateTime;
    private int hours;
    private String notes;

    public ActivityItem() {
        //No argument constructor
    }

    public ActivityItem(int dayNumber, ItemType itemType, String name, String venue, LocalDateTime date, int hours, String notes) {
        super(dayNumber, itemType);
        this.name = name;
        this.venue = venue;
        this.dateTime = date;
        this.hours = hours;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int getEstimatedCost() {
        return actualCost;
    }

}
