package io.travel.alert;

public class BudgetOverrunStrategy implements AlertStrategy {
    @Override
    public boolean supports(AlertContext context) {
        return context.budgetSummary() != null;
    }

    @Override
    public String evaluate(AlertContext context) {
        String result = "";
        //TODO: Add code here;
        return  result;
    }
}
