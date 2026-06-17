package io.travel.factory;

import io.travel.enums.ItemType;
import io.travel.enums.TransportType;
import io.travel.model.*;
import io.travel.util.InputHandler;

import java.time.LocalDateTime;

public class ItineraryItemFactory {

    public static ItineraryItem create(ItemType itemType, LocalDateTime dateTime) {
        return switch (itemType) {
            case FLIGHT -> createFlightItem(dateTime);
            case HOTEL -> createHotelItem(dateTime);
            case ACTIVITY -> createActivityItem(dateTime);
            case RESTAURANT -> createRestaurantItem(dateTime);
            case TRANSPORT -> createTransportItem(dateTime);
        };
    }

    private static ItineraryItem createFlightItem(LocalDateTime dateTime) {
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
        System.out.println("Enter the name of the confirmation code:");
        String confirmationCode = InputHandler.getStringInput();
        System.out.println("Enter the estimated cost:");
        int estimatedCost = InputHandler.getIntegerInput();

        return new FlightItem(dateTime, ItemType.FLIGHT, estimatedCost, airline, flightNumber, departureAirport,arrivalAirport, arrivalTime, confirmationCode);
    }

    private static ItineraryItem createHotelItem(LocalDateTime dateTime) {
        System.out.println("Enter the name of the hotel:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the address of the hotel:");
        String address = InputHandler.getStringInput();
        System.out.println("Enter the checkout date and time (yyyy-MM-ddTHH:mm:ss):");
        LocalDateTime checkOut = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the name of the confirmation code:");
        String confirmationCode = InputHandler.getStringInput();
        System.out.println("Enter the price of the hotel for one night:");
        int price = InputHandler.getIntegerInput();

        return new HotelItem(dateTime, ItemType.HOTEL, name, address, checkOut, price, confirmationCode);
    }

    private static ItineraryItem createActivityItem(LocalDateTime dateTime) {
        System.out.println("Enter the name of the activity:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the name of the venue:");
        String venue = InputHandler.getStringInput();
        System.out .println("Enter the duration of the activity:");
        int duration = InputHandler.getIntegerInput();
        System.out.println("Enter the estimated cost:");
        int estimatedCost = InputHandler.getIntegerInput();
        System.out.println("Enter the notes of the activity:");
        String notes = InputHandler.getStringInput();

        return new ActivityItem(dateTime, ItemType.ACTIVITY, estimatedCost, name, venue, duration,  notes);
    }

    private static ItineraryItem createRestaurantItem(LocalDateTime dateTime) {
        System.out.println("Enter the name of the restaurant:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the name of the cuisine:");
        String cuisine = InputHandler.getStringInput();
        System.out.println("Enter the number of guests:");
        int numberOfGuests = InputHandler.getIntegerInput();
        System.out .println("Enter the estimated cost per guest:");
        int estimatedCostPerGuest = InputHandler.getIntegerInput();

        return new RestaurantItem(dateTime, ItemType.RESTAURANT, estimatedCostPerGuest, name, cuisine, numberOfGuests);
    }

    private static ItineraryItem createTransportItem(LocalDateTime dateTime) {
        System.out.println("Enter the transport type (TAXI, BUS, TRAIN, FERRY, RENTAL_CAR, RIDESHARE , OTHER):");
        TransportType transportType = TransportType.valueOf(InputHandler.getStringInput());
        System.out.println("Enter the from the location:");
        String fromLocation = InputHandler.getStringInput();
        System.out.println("Enter the to the location:");
        String toLocation = InputHandler.getStringInput();
        System.out.println("Enter the estimated cost:");
        int estimatedCost = InputHandler.getIntegerInput();
        System.out.println("Enter the provider:");
        String provider = InputHandler.getStringInput();
        System.out.println("Enter the notes:");
        String notes = InputHandler.getStringInput();

        return new TransportItem(dateTime, ItemType.TRANSPORT, estimatedCost, transportType, fromLocation, toLocation, provider, notes);
    }

}
