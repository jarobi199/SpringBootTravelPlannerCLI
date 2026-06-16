package io.travel.alert;

import io.travel.enums.ItemType;
import org.springframework.stereotype.Component;

import java.util.Map;
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
            Optional<Map.Entry<ItemType, Integer>> largestContributingCategory = context.budgetSummary()
                    .categoryBreakdown()
                    .entrySet().stream().max(Map.Entry.comparingByValue());
            stringBuilder.append("ALERT! Your budget is over $ ").append(Math.abs(context.budgetSummary().remaining())).append("!")
                    .append("\n").append("The largest contributing category is ")
                    .append(largestContributingCategory.get().getKey().name()).append(" - $")
                    .append(largestContributingCategory.get().getValue());
        }

        return  stringBuilder.toString();
    }
}
