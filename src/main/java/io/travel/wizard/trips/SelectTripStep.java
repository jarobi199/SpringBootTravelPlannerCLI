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

public class SelectTripStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        int i = 1;
        WizardResult result = WizardResult.ABORT;
        TripService tripService = SpringContext.getBean(TripService.class);
        List<Trip> trips = tripService.findAllTripsByUserId(SessionContext.getCurrentUser().getId());

        if(!trips.isEmpty()) {
            result = WizardResult.CONTINUE;
            for (Trip trip : trips) {
                System.out.println("[" + i + "] " + trip.getName());
                i++;
            }
            System.out.println("Please select a trip:");
            int tripIndex = InputHandler.getIntegerInput() - 1;
            Trip trip = trips.get(tripIndex);

            context.setSelectedTrip(trip);
        }

        return result;
    }
}
