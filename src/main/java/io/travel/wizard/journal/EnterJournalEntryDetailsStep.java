package io.travel.wizard.journal;

import io.travel.enums.Mood;
import io.travel.enums.WizardResult;
import io.travel.model.JournalEntry;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.time.LocalDateTime;
import java.util.List;

public class EnterJournalEntryDetailsStep implements IWizardStep {
    @Override
    public WizardResult execute(WizardContext context) {
        System.out.println("Enter the title:");
        String title = InputHandler.getStringInput();
        System.out.println("Enter the body:");
        String body = InputHandler.getStringInput();
        System.out.println("Enter the date and time (yyyy-MM-ddTHH:mm:ss)");
        LocalDateTime dateTime = LocalDateTime.parse(InputHandler.getStringInput());
        System.out.println("Enter the mood (AMAZING, GOOD, NEUTRAL, TIRED, DISAPPOINTED):");
        Mood mood = Mood.valueOf(InputHandler.getStringInput());
        System.out.println("Enter up to 3 highlights separated by a comma (e.g. Good day, upbeat):");
        List<String> highlights = List.of(InputHandler.getStringInput().split(","));
        System.out.println("Enter a rating from 1-5:");
        int rating = InputHandler.getIntegerInput();

        JournalEntry journalEntry = new JournalEntry(title, body, dateTime, mood, highlights, rating);
        context.setPendingJournalEntry(journalEntry);
        return  WizardResult.CONTINUE;
    }
}
