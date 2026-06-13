package io.travel.wizard;

import io.travel.enums.WizardResult;
import org.springframework.stereotype.Component;

@Component
public class WizardRunner {

    public void run(IWizard wizard, WizardContext context) {
        for (IWizardStep step : wizard.getSteps()) {
            WizardResult result = step.execute(context);
            if (result == WizardResult.ABORT) {
                System.out.println("Wizard cancelled.");
                return;
            }
        }
    }
}