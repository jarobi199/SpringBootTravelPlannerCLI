package io.travel.alert;

import io.travel.enums.TripStatus;

public class UpcomingTripStrategy implements AlertStrategy {
    @Override
    public boolean supports(AlertContext context) {
        return (context.trip() != null) && (context.trip().getStatus().equals(TripStatus.PLANNED));
    }

    @Override
    public String evaluate(AlertContext context) {
        String message = "";
        if(context.trip().getJournals().isEmpty()) {
            message = "ALERT: Your upcoming trip is scheduled within the next 7 days! Please review your itinerary and bookings.";
        }

        return message;
    }
}


