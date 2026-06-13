package io.travel.wizard.trips;

import io.travel.bridge.SpringContext;
import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.service.TripService;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class SaveTripStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        Trip trip = context.getSelectedTrip();
        TripService tripService = SpringContext.getBean(TripService.class);

        tripService.saveTrip(trip);
        System.out.println("Trip saved successfully!\n");
        return WizardResult.CONTINUE;
    }

}
