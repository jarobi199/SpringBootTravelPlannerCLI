package io.travel.wizard.trips;

import io.travel.wizard.IWizard;
import io.travel.wizard.IWizardStep;

import java.util.List;

public class MyTripsWizard implements IWizard {
    @Override
    public List<IWizardStep> getSteps() {
        return List.of(
                new SelectMyTripStep(),
                new SelectActionStep()
        );
    }
}
