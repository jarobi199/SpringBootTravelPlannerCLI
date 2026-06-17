package io.travel.model;

import io.travel.enums.ItemType;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public abstract class ItineraryItem {
    @Id
    protected String id;
    protected LocalDateTime dateTime;
    protected ItemType itemType;
    protected int actualCost;

    public ItineraryItem() {
        //No argument constructor
    }

    public ItineraryItem(LocalDateTime dateTime, ItemType itemType) {
        this.dateTime = dateTime;
        this.itemType = itemType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
        return this.getClass().getSimpleName().toUpperCase().replace("ITEM", " ITEM") + " DETAILS:" + "\n" +
                "Date and time: " + dateTime + "\n" +
                "Item type: " + itemType.name() + "\n" +
                "Actual cost: " + actualCost + "\n";
    }
}
