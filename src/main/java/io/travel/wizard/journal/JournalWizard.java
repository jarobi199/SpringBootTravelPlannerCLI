package io.travel.wizard.journal;

import io.travel.wizard.IWizard;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.trips.SaveTripStep;
import io.travel.wizard.trips.SelectTripStep;

import java.util.List;

public class JournalWizard implements IWizard {

    @Override
    public List<IWizardStep> getSteps() {
        return List.of(
                new SelectTripStep(),
                new EnterJournalEntryDetailsStep(),
                new ConfirmAndSaveJournalStep(),
                new SaveTripStep()
        );
    }

}
