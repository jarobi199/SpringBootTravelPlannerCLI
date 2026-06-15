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

    public FlightItem(int dayNumber, ItemType itemType, int actualCost, String airline, String flightNumber, String departureAirport, String arrivalAirport,
                      LocalDateTime departureTime, LocalDateTime arrivalTime, String confirmationCode) {
        super(dayNumber, itemType, actualCost);
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Override
    public int getEstimatedCost() {
        return actualCost;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Airline: '" + airline + "\n" +
                "Flight number: '" + flightNumber + "\n" +
                "Departure airport: " + departureAirport + "\n" +
                "Arrival airport: " + arrivalAirport + "\n" +
                "Departure time: " + departureTime + "\n" +
                "Arrival time: " + arrivalTime + "\n" +
                "Confirmation code: " + confirmationCode+ "\n";
    }

}
