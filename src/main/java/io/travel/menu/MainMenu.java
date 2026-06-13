package io.travel.menu;

import io.travel.util.InputHandler;
import io.travel.wizard.WizardContext;
import io.travel.wizard.WizardRunner;
import io.travel.wizard.budget.BudgetWizard;
import io.travel.wizard.item.AddItemWizard;
import io.travel.wizard.journal.JournalWizard;
import io.travel.wizard.summary.TripSummaryWizard;
import io.travel.wizard.trips.MyTripsWizard;
import io.travel.wizard.trips.PlanTripWizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainMenu implements IMenu {

    @Autowired
    private WizardRunner wizardRunner;

    @Override
    public void show() {
        int choice;
        do {
            printOptions();
            choice = InputHandler.getIntegerInput();
            switch (choice) {
                case 1 -> wizardRunner.run(new PlanTripWizard(),  new WizardContext());
                case 2 -> wizardRunner.run(new AddItemWizard(), new WizardContext());
                case 3 -> wizardRunner.run(new BudgetWizard(), new WizardContext());
                case 4 -> wizardRunner.run(new JournalWizard(), new WizardContext());
                case 5 -> wizardRunner.run(new TripSummaryWizard(), new WizardContext());
                case 6 -> wizardRunner.run(new MyTripsWizard(), new WizardContext());
            }
        } while (choice != 0);
    }

    @Override
    public void printOptions() {
        System.out.println("[1] Plan a new trip");
        System.out.println("[2] Add itinerary item");
        System.out.println("[3] Review budget");
        System.out.println("[4] Write journal entry");
        System.out.println("[5] Trip summary");
        System.out.println("[6] My trips");
        System.out.println("[0] Quit");
    }
}

