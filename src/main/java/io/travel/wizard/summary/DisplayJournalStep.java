package io.travel.wizard.summary;

import io.github.kusoroadeolu.clique.Clique;
import io.github.kusoroadeolu.clique.components.Table;
import io.github.kusoroadeolu.clique.configuration.TableType;
import io.travel.enums.WizardResult;
import io.travel.model.JournalEntry;
import io.travel.model.Trip;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class DisplayJournalStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        Trip trip = context.getSelectedTrip();

        Table table =  Clique.table(TableType.BOX_DRAW).headers("TITLE", "BODY", "DATE","MOOD", "HIGHLIGHTS", "RATING");
        for(JournalEntry journalEntry : trip.getJournals()) {
            table.row(journalEntry.title(), journalEntry.body(), journalEntry.date().toString(),
                    journalEntry.mood().toString(), journalEntry.highlights().toString(), String.valueOf(journalEntry.rating()));
        }
        table.render();

        return WizardResult.CONTINUE;
    }
}
