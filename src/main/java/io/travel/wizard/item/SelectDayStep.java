package io.travel.wizard.item;

import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.time.temporal.ChronoUnit;

public class SelectDayStep implements IWizardStep {
    @Override
    public WizardResult execute(WizardContext context) {
        WizardResult result = WizardResult.CONTINUE;
        Trip trip = context.getSelectedTrip();
        System.out.println("Trip start date: " + trip.getStartDate());
        System.out.println("Trip end date: " + trip.getEndDate());
        System.out.println("Select a day represented by a number within the trip duration (example: 1):");
        int dayNumber = InputHandler.getIntegerInput();

        long duration = ChronoUnit.DAYS.between(trip.getStartDate(), trip.getEndDate());
        if (dayNumber > duration) {
            result = WizardResult.ABORT;
        } else {
            context.setSelectedDayNumber(dayNumber);
        }

        return result;
    }
}
