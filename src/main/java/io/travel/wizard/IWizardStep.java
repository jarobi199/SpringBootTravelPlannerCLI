package io.travel.wizard;

public interface IWizardStep {
    WizardResult execute(WizardContext context);
}

