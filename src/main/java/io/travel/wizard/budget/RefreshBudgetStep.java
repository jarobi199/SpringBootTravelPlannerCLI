package io.travel.wizard.budget;

import io.travel.alert.AlertContext;
import io.travel.alert.AlertManager;
import io.travel.bridge.SpringContext;
import io.travel.enums.WizardResult;
import io.travel.service.TripService;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.util.List;

public class RefreshBudgetStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        AlertManager alertManager = SpringContext.getBean(AlertManager.class);
        DisplayBudgetStep displayBudgetStep = new DisplayBudgetStep();
        displayBudgetStep.execute(context);

        TripService tripService = SpringContext.getBean(TripService.class);
        tripService.saveTrip(context.getSelectedTrip());

        //Alerts
        List<String> alerts = alertManager.evaluate(new AlertContext(context.getSelectedTrip(), context.getBudgetSummary()));
        alerts.forEach(System.out::println);

        return WizardResult.CONTINUE;
    }

}
