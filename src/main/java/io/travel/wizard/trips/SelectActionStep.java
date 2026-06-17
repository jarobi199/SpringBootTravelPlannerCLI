package io.travel.wizard.trips;

import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class SelectActionStep  implements IWizardStep {
    @Override
    public WizardResult execute(WizardContext context) {
        Trip trip = context.getSelectedTrip();
        System.out.println("TRIP: " +  trip.getName() + " (" + trip.getStatus().name() + ")");
        System.out.println();
        System.out.println("[1] View full summary");
        System.out.println("[2] Edit trip name or dates");
        System.out.println("[3] Cancel trip");
        System.out.println("[4] Delete trip");
        System.out.println("Please select an action to apply:");

        int choice = InputHandler.getIntegerInput();
        context.setSelectedAction(choice);

        return WizardResult.CONTINUE;
    }
}
