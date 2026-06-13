package io.travel.wizard.trips;

import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class ConfirmTripStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        Trip trip = context.getSelectedTrip();
        WizardResult result = WizardResult.CONTINUE;

        System.out.println("TRIP DETAILS:");
        System.out.println("Name: " + trip.getName());
        System.out.println("Country: " + trip.getCountry());
        System.out.println("Start date: " + trip.getStartDate());
        System.out.println("End date: " + trip.getEndDate());
        System.out.println("Budget: $" + trip.getTotalBudget());
        System.out.println("Status: " + trip.getStatus().name());
        System.out.println();

        System.out.println("Confirm? (Y/N):");
        String confirm = InputHandler.getStringInput();
        if (!confirm.equalsIgnoreCase("Y")) {
            result = WizardResult.ABORT;
        }

        return result;
    }

}
