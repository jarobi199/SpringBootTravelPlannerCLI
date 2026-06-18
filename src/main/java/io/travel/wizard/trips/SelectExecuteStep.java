package io.travel.wizard.trips;

import io.travel.bridge.SpringContext;
import io.travel.enums.TripStatus;
import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.service.TripService;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.time.LocalDate;

public class SelectExecuteStep implements IWizardStep {

    private final TripService tripService = SpringContext.getBean(TripService.class);

    @Override
    public WizardResult execute(WizardContext context) {
        int selection = context.getSelectedAction();
        Trip trip = context.getSelectedTrip();

        return switch (selection) {
            case 1 -> viewTripSummary();
            case 2 -> editTripNameAndDates(trip);
            case 3 -> cancelTrip(trip);
            case 4 -> deleteTrip(trip);
            default -> throw new IllegalStateException("Unexpected value: " + selection);
        };
    }

    public WizardResult viewTripSummary() {
        System.out.println("I would display a trip summary here but it is too complicated with this wizard/step architecture.");
        return WizardResult.CONTINUE;
    }

    public WizardResult deleteTrip(Trip trip) {
        WizardResult result = WizardResult.ABORT;
        if(!trip.getJournals().isEmpty()) {
            tripService.deleteTrip(trip);
            System.out.println("Trip has been deleted!");
        }
        else
        {
            System.out.println("This trip does not have any journal entries! Are you sure you want to delete this trip?");
            String selection = InputHandler.getStringInput();
            if ("Y".equalsIgnoreCase(selection)) {
                tripService.deleteTrip(trip);
                System.out.println("Trip has been deleted!");
            }
        }
        return result;
    }

    public WizardResult cancelTrip(Trip trip) {
        WizardResult result = WizardResult.ABORT;
        if(TripStatus.PLANNED.equals(trip.getStatus())) {
            trip.setStatus(TripStatus.CANCELLED);
            tripService.saveTrip(trip);
            System.out.println("Trip has been cancelled!");
            result = WizardResult.CONTINUE;
        }

        return result;
    }

    public WizardResult editTripNameAndDates(Trip trip) {
        System.out.println("Enter the new trip name:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the new start date (yyyy-mm-dd):");
        LocalDate startDate = InputHandler.getDateInput();
        System.out.println("Enter the new end date (yyyy-mm-dd):");
        LocalDate endDate = InputHandler.getDateInput();

        trip.setStartDate(startDate);
        trip.setEndDate(endDate);
        trip.setName(name);

        tripService.saveTrip(trip);
        System.out.println("Trip has been edited!");

        return WizardResult.CONTINUE;
    }
}
