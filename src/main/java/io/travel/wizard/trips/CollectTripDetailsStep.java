package io.travel.wizard.trips;

import io.travel.authentication.SessionContext;
import io.travel.enums.TripStatus;
import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.time.LocalDate;

public class CollectTripDetailsStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        System.out.println("Enter the name of the trip:");
        String name = InputHandler.getStringInput();
        System.out.println("Enter the country:");
        String country = InputHandler.getStringInput();
        System.out.println("Enter the start date (yyyy-mm-dd):");
        LocalDate startDate = InputHandler.getDateInput();
        System.out.println("Enter the end date (yyyy-mm-dd):");
        LocalDate endDate = InputHandler.getDateInput();
        System.out.println("Enter the budget:");
        int budget = InputHandler.getIntegerInput();

        TripStatus tripStatus = TripStatus.PLANNED;
        if(startDate.isBefore(LocalDate.now()) || (startDate.isEqual(LocalDate.now()))) {
            tripStatus = TripStatus.ACTIVE;
        }
        Trip trip = new Trip(SessionContext.getCurrentUser().getId(), name, country, startDate, endDate, budget, tripStatus);
        context.setSelectedTrip(trip);

        return WizardResult.CONTINUE;
    }

}
