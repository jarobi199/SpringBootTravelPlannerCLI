package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDateTime;

public class FlightItem extends ItineraryItem {

    private String airline;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String confirmationCode;

    public FlightItem() {
        //No argument constructor
    }

    public FlightItem(int dayNumber, ItemType itemType, String airline, String flightNumber, String departureAirport, String arrivalAirport,
                      LocalDateTime departureTime, LocalDateTime arrivalTime, String confirmationCode) {
        super(dayNumber, itemType);
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.confirmationCode = confirmationCode;
    }

    @Override
    public double getEstimatedCost() {
        return actualCost;
    }

}
