package io.travel.wizard.item;

import io.travel.enums.WizardResult;
import io.travel.model.Trip;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SelectDateTimeStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        WizardResult result = WizardResult.CONTINUE;
        System.out.println("Enter the date and time(yyyy-MM-ddTHH:mm:ss):");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(InputHandler.getStringInput());
            context.setDateTime(dateTime);
        }
        catch (Exception e)
        {
            result = WizardResult.ABORT;
        }

        return result;
    }

}
