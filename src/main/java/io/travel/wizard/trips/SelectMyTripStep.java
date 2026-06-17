package io.travel.wizard.trips;

import io.travel.authentication.SessionContext;
import io.travel.bridge.SpringContext;
import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.service.TripService;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.util.List;

public class SelectMyTripStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        int i = 1;
        WizardResult result = WizardResult.CONTINUE;
        TripService tripService = SpringContext.getBean(TripService.class);
        List<Trip> trips = tripService.findAllTripsByUserId(SessionContext.getCurrentUser().getId());

        if(!trips.isEmpty()) {
            for (Trip trip : trips) {
                System.out.println("[" + i + "] " + trip.getName() + " (" + trip.getStatus().name() + ")");
                i++;
            }
            System.out.println("[0] Back");
            System.out.println("Please select a trip or select 0 to go back to the main menu:");
            int selection = InputHandler.getIntegerInput();

            if(selection == 0) {
                result = WizardResult.ABORT;
            }
            else
            {
                Trip trip = trips.get(selection -1);
                context.setSelectedTrip(trip);
            }
        }

        return result;
    }
}
