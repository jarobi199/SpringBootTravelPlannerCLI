package io.travel.model;

import io.travel.enums.ItemType;
import io.travel.enums.TransportType;

import java.time.LocalDateTime;

public class TransportItem extends ItineraryItem{

    private TransportType transportType;
    private String fromLocation;
    private String toLocation;
    private String provider;
    private String notes;
    private int estimatedCost;

    public TransportItem() {
        //No argument constructor
    }

    public TransportItem(LocalDateTime dateTime, ItemType itemType, int estimatedCost, TransportType transportType, String fromLocation, String toLocation, String provider, String notes) {
        super(dateTime, itemType);
        this.estimatedCost = estimatedCost;
        this.transportType = transportType;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.provider = provider;
        this.notes = notes;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int getEstimatedCost() {
        return estimatedCost;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Transport type: " + transportType + "\n" +
                "From location: '" + fromLocation + "\n" +
                "To location: " + toLocation + "\n" +
                "Provider: " + provider + "\n" +
                "Notes: '" + notes;
    }
}
