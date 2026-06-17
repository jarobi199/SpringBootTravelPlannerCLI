package io.travel.alert;

import io.travel.model.CategoryBreakdown;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;

@Component
public class BudgetOverrunStrategy implements AlertStrategy {
    @Override
    public boolean supports(AlertContext context) {
        return context.budgetSummary() != null;
    }

    @Override
    public String evaluate(AlertContext context) {
        StringBuilder stringBuilder = new StringBuilder();
        if(context.budgetSummary().remaining() < 0) {
            Optional<CategoryBreakdown> largestContributingCategory = context.budgetSummary()
                    .categoryBreakdowns().stream().max(Comparator.comparing(CategoryBreakdown::estimatedCost));
            stringBuilder.append("ALERT! Your budget is over $").append(Math.abs(context.budgetSummary().remaining())).append("!")
                    .append("\n").append("The largest contributing category is ")
                    .append(largestContributingCategory.get().itemType().name()).append(" - $")
                    .append(largestContributingCategory.get().estimatedCost());
        }

        return  stringBuilder.toString();
    }
}
