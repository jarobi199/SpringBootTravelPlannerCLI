package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDateTime;

public class FlightItem extends ItineraryItem {

    private String airline;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime arrivalDateTime;
    private String confirmationCode;
    private int estimatedCost;

    public FlightItem() {
        //No argument constructor
    }

    public FlightItem(LocalDateTime departureDateTime, ItemType itemType, int estimatedCost, String airline, String flightNumber, String departureAirport, String arrivalAirport,
                      LocalDateTime arrivalDateTime, String confirmationCode) {
        super(departureDateTime, itemType);
        this.estimatedCost = estimatedCost;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.arrivalDateTime = arrivalDateTime;
        this.confirmationCode = confirmationCode;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Override
    public int getEstimatedCost() {
        return estimatedCost;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Airline: '" + airline + "\n" +
                "Flight number: '" + flightNumber + "\n" +
                "Departure airport: " + departureAirport + "\n" +
                "Arrival airport: " + arrivalAirport + "\n" +
                "Departure date and time: " + dateTime + "\n" +
                "Arrival date and  time: " + arrivalDateTime + "\n" +
                "Confirmation code: " + confirmationCode;
    }

}
