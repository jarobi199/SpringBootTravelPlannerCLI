package io.travel.alert;

import io.travel.enums.TripStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UnreviewedTripStrategy  implements AlertStrategy {
    @Override
    public boolean supports(AlertContext context) {
        return (context.trip() != null) && (context.trip().getStatus().equals(TripStatus.COMPLETED));
    }

    @Override
    public String evaluate(AlertContext context) {
        String message = "";
        if(ChronoUnit.DAYS.between(LocalDate.now(), context.trip().getStartDate()) <= 7) {
            message = "ALERT: There are no journals in this trip! Please write your post-trip reflections before the memories fade!";
        }

        return message;
    }

}
