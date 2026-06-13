package io.travel.wizard;

import io.travel.model.BudgetSummary;
import io.travel.model.ItineraryItem;
import io.travel.model.JournalEntry;
import io.travel.model.Trip;

public class WizardContext {
    private Trip selectedTrip;
    private int selectedDayNumber;
    private ItineraryItem pendingItem;
    private JournalEntry pendingJournalEntry;
    private BudgetSummary budgetSummary;

    public Trip getSelectedTrip() {
        return selectedTrip;
    }

    public void setSelectedTrip(Trip selectedTrip) {
        this.selectedTrip = selectedTrip;
    }

    public int getSelectedDayNumber() {
        return selectedDayNumber;
    }

    public void setSelectedDayNumber(int selectedDayNumber) {
        this.selectedDayNumber = selectedDayNumber;
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
