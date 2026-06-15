package io.travel.wizard.journal;

import io.travel.enums.WizardResult;
import io.travel.model.JournalEntry;
import io.travel.model.Trip;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class ConfirmAndSaveJournalStep implements IWizardStep {
    @Override
    public WizardResult execute(WizardContext context) {
        WizardResult result = WizardResult.CONTINUE;
        Trip trip = context.getSelectedTrip();
        JournalEntry journalEntry = context.getPendingJournalEntry();

        System.out.println("Title: " + journalEntry.title());
        System.out.println("Body: " + journalEntry.body());
        System.out.println("Date: " + journalEntry.date().toString());
        System.out.println("Mood: " + journalEntry.mood().name());
        System.out.println("Highlights: " + journalEntry.highlights());
        System.out.println("Rating: " + journalEntry.rating());

        System.out.println("Confirm? (Y/N):");
        String confirm = InputHandler.getStringInput();
        if (!confirm.equalsIgnoreCase("Y")) {
            result = WizardResult.ABORT;
        }
        else {
            trip.getJournals().add(journalEntry);
            System.out.println("Journal added!");
        }

        return result;
    }
}
