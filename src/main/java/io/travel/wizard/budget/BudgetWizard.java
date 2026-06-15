package io.travel.wizard.budget;

import io.travel.wizard.IWizard;
import io.travel.wizard.IWizardStep;

import java.util.List;

public class BudgetWizard implements IWizard {

    @Override
    public List<IWizardStep> getSteps() {
        return List.of(
                new SelectTripBudgetStep(),
                new DisplayBudgetStep());
    }

}
