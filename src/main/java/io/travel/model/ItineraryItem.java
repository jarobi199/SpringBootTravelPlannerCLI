package io.travel.model;

import io.travel.enums.ItemType;
import org.springframework.data.annotation.Id;

public abstract class ItineraryItem {
    @Id
    protected String id;
    protected int dayNumber;
    protected ItemType itemType;
    protected int actualCost;

    public ItineraryItem() {
        //No argument constructor
    }

    public ItineraryItem(int dayNumber, ItemType itemType) {
        this.dayNumber = dayNumber;
        this.itemType = itemType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getActualCost() {
        return actualCost;
    }

    public void setActualCost(int actualCost) {
        this.actualCost = actualCost;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public abstract int getEstimatedCost();

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toUpperCase() + " DETAILS:" + "\n" +
                "Day number: " + dayNumber + "\n" +
                "Item type: " + itemType.name() + "\n" +
                "Actual cost: " + actualCost + "\n";
    }
}
