package io.travel.wizard.summary;

import io.travel.wizard.IWizard;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.budget.DisplayBudgetStep;
import io.travel.wizard.trips.SelectTripStep;

import java.util.List;

public class TripSummaryWizard implements IWizard {
    @Override
    public List<IWizardStep> getSteps() {
        return List.of(
                new SelectTripStep(),
                new DisplayItineraryStep(),
                new DisplayBudgetStep(),
                new DisplayJournalStep(),
                new MarkCompleteStep()
        );
    }
}
