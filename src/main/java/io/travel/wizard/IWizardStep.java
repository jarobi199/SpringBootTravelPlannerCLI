package io.travel.wizard;

import io.travel.enums.WizardResult;

public interface IWizardStep {
    WizardResult execute(WizardContext context);
}

