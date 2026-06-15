package io.travel.wizard.item;

import io.travel.wizard.IWizard;
import io.travel.wizard.IWizardStep;

import java.util.List;

public class AddItemWizard implements IWizard {
    @Override
    public List<IWizardStep> getSteps() {
        return List.of(
                new SelectTripItemStep(),
                new SelectDayStep(),
                new EnterItemDetailsStep(),
                new ConfirmAndSaveItemStep()
        );
    }
}
