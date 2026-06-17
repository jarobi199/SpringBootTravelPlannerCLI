package io.travel.wizard;

import io.travel.model.BudgetSummary;
import io.travel.model.ItineraryItem;
import io.travel.model.JournalEntry;
import io.travel.model.Trip;

import java.time.LocalDateTime;

public class WizardContext {
    private Trip selectedTrip;
    private LocalDateTime dateTime;
    private ItineraryItem pendingItem;
    private JournalEntry pendingJournalEntry;
    private BudgetSummary budgetSummary;

    public Trip getSelectedTrip() {
        return selectedTrip;
    }

    public void setSelectedTrip(Trip selectedTrip) {
        this.selectedTrip = selectedTrip;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ItineraryItem getPendingItem() {
        return pendingItem;
    }

    public void setPendingItem(ItineraryItem pendingItem) {
        this.pendingItem = pendingItem;
    }

    public JournalEntry getPendingJournalEntry() {
        return pendingJournalEntry;
    }

    public void setPendingJournalEntry(JournalEntry pendingJournalEntry) {
        this.pendingJournalEntry = pendingJournalEntry;
    }

    public BudgetSummary getBudgetSummary() {
        return budgetSummary;
    }

    public void setBudgetSummary(BudgetSummary budgetSummary) {
        this.budgetSummary = budgetSummary;
    }
}
