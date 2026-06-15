package io.travel.factory;

import io.travel.enums.ItemType;
import io.travel.enums.TransportType;
import io.travel.model.*;
import io.travel.util.InputHandler;

import java.time.LocalDateTime;

public class ItineraryItemFactory {

    public static ItineraryItem create(ItemType itemType) {
        System.out.println("Enter the day number:");
        int dayNumber = InputHandler.getIntegerInput();
        System.out.println("Enter the actual cost:");
        int actualCost = InputHandler.getIntegerInput();

        return switch (itemType) {
            case FLIGHT -> createFlightItem(dayNumber, actualCost);
            case HOTEL -> createHotelItem(dayNumber, actualCost);
            case ACTIVITY -> createActivityItem(dayNumber, actualCost);
            case RESTAURANT -> createRestaurantItem(dayNumber, actualCost);
            case TRANSPORT -> createTransportItem(dayNumber, actualCost);
        };
    }

    private static ItineraryItem createFlightItem(int dayNumber, int actualCost) {
        System.out.println("Enter the name of the airline:");
        String airline = InputHandler.getStringInput();
        System.out.println("Enter the name of the flight number:");
        String flightNumber = InputHandler.getStringInput();
        System.out.println("Enter the name of the departure airport:");
        String departureAirport = InputHandler.getStringInput();
        System.out.println("Enter the name of the arrival airport:");
        String arrivalAirport = InputHandler.getStringInput();
        System.out.println("Enter the arrival time (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime arrivalTime = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the departure time (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime departureTime = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the name of the confirmation code:");
        String confirmationCode = InputHandler.getStringInput();

        return new FlightItem(dayNumber, ItemType.FLIGHT, actualCost, airline, flightNumber, departureAirport,arrivalAirport, departureTime, arrivalTime, confirmationCode);
    }

    private static ItineraryItem createHotelItem(int dayNumber, int actualCost) {
        System.out.println("Enter the name of the hotel:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the address of the hotel:");
        String address = InputHandler.getStringInput();
        System.out.println("Enter the check-in date and time  (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime checkIn = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the checkout date and time (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime checkOut = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the name of the confirmation code:");
        String confirmationCode = InputHandler.getStringInput();

        return new HotelItem(dayNumber, ItemType.HOTEL, actualCost, name, address, checkIn, checkOut,  actualCost, confirmationCode);
    }

    private static ItineraryItem createActivityItem(int dayNumber, int actualCost) {
        System.out.println("Enter the name of the activity:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the name of the venue:");
        String venue = InputHandler.getStringInput();
        System.out.println("Enter the date and time  (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime dateTime = LocalDateTime.parse(InputHandler.getStringInput());
        System.out .println("Enter the duration of the activity:");
        int duration = InputHandler.getIntegerInput();
        System.out.println("Enter the estimated cost:");
        int estimatedCost = InputHandler.getIntegerInput();
        System.out.println("Enter the notes of the activity:");
        String notes = InputHandler.getStringInput();
        System.out.println("Enter the name of the confirmation code:");
        String confirmationCode = InputHandler.getStringInput();

        return new ActivityItem(dayNumber, ItemType.ACTIVITY, actualCost, name, venue, dateTime, duration,  notes);
    }

    private static ItineraryItem createRestaurantItem(int dayNumber, int actualCost) {
        System.out.println("Enter the name of the restaurant:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the name of the cuisine:");
        String cuisine = InputHandler.getStringInput();
        System.out.println("Enter the date and time  (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime dateTime = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the number of guests:");
        int numberOfGuests = InputHandler.getIntegerInput();
        System.out .println("Enter the estimated cost for guests:");
        int estimatedCost = InputHandler.getIntegerInput();

        return new RestaurantItem(dayNumber, ItemType.RESTAURANT, actualCost, name, cuisine, dateTime, numberOfGuests,  estimatedCost);
    }

    private static ItineraryItem createTransportItem(int dayNumber, int actualCost) {
        System.out.println("Enter the transport type (TAXI, BUS, TRAIN, FERRY, RENTAL_CAR, RIDESHARE , OTHER):");
        TransportType transportType = TransportType.valueOf(InputHandler.getStringInput());
        System.out.println("Enter the from the location:");
        String fromLocation = InputHandler.getStringInput();
        System.out.println("Enter the to the location:");
        String toLocation = InputHandler.getStringInput();
        System.out.println("Enter the scheduled  date and time  (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime dateTime = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the estimated cost:");
        int estimatedCost = InputHandler.getIntegerInput();
        System.out.println("Enter the provider:");
        String provider = InputHandler.getStringInput();
        System.out.println("Enter the notes:");
        String notes = InputHandler.getStringInput();

        return new TransportItem(dayNumber, ItemType.TRANSPORT, actualCost, transportType, fromLocation, toLocation, dateTime, provider, notes);
    }

}
