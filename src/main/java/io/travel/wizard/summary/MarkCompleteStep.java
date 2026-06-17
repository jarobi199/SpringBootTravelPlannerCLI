package io.travel.wizard.summary;

import io.travel.bridge.SpringContext;
import io.travel.enums.TripStatus;
import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.service.TripService;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class MarkCompleteStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        WizardResult result = WizardResult.CONTINUE;
        Trip trip = context.getSelectedTrip();
        TripService tripService = SpringContext.getBean(TripService.class);

        if(TripStatus.ACTIVE.equals(trip.getStatus())) {
            System.out.println("This trip is active. Would you like to mark it as completed? (Y/N):");
            String selection = InputHandler.getStringInput();
            if("Y".equalsIgnoreCase(selection)) {
                trip.setStatus(TripStatus.COMPLETED);
                tripService.saveTrip(trip);
            }
        }
        return result;
    }
}
