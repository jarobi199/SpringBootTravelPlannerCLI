package io.travel.wizard.item;

import io.travel.bridge.SpringContext;
import io.travel.enums.WizardResult;
import io.travel.model.ItineraryItem;
import io.travel.model.Trip;
import io.travel.service.TripService;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class ConfirmAndSaveItemStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        Trip trip = context.getSelectedTrip();
        ItineraryItem itineraryItem = context.getPendingItem();
        TripService tripService = SpringContext.getBean(TripService.class);
        WizardResult result = WizardResult.CONTINUE;

        System.out.println(itineraryItem);
        System.out.println();
        System.out.println("Confirm? (Y/N):");
        String confirm = InputHandler.getStringInput();

        if (!confirm.equalsIgnoreCase("Y")) {
            result = WizardResult.ABORT;
        }
        else
        {
            trip.getItineraries().add(itineraryItem);
            tripService.saveTrip(trip);
            System.out.println("Item saved successfully!\n");
        }

        return result;
    }

}
