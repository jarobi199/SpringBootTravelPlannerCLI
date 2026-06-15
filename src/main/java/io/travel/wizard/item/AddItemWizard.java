package io.travel.wizard.item;

import io.travel.wizard.IWizard;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.trips.SelectTripStep;

import java.util.List;

public class AddItemWizard implements IWizard {
    @Override
    public List<IWizardStep> getSteps() {
        return List.of(
                new SelectTripStep(),
                new SelectDayStep(),
                new EnterItemDetailsStep(),
                new ConfirmAndSaveItemStep()
        );
    }
}
