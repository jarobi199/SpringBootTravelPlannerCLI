package io.travel.model;

import io.travel.enums.ItemType;
import io.travel.enums.TransportType;

import java.time.LocalDateTime;

public class TransportItem extends ItineraryItem{

    private TransportType transportType;
    private String fromLocation;
    private String toLocation;
    private LocalDateTime dateTime;
    private String provider;
    private String notes;

    public TransportItem() {
        //No argument constructor
    }

    public TransportItem(int dayNumber, ItemType itemType, int actualCost, TransportType transportType, String fromLocation, String toLocation, LocalDateTime dateTime, String provider, String notes) {
        super(dayNumber, itemType, actualCost);
        this.transportType = transportType;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
        return actualCost;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Transport type: " + transportType + "\n" +
                "From location: '" + fromLocation + "\n" +
                "To location: " + toLocation + "\n" +
                "Date time: " + dateTime + "\n" +
                "Provider: " + provider + "\n" +
                "Notes: '" + notes + "\n";
    }
}
