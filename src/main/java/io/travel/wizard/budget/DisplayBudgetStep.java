package io.travel.wizard.budget;

import io.github.kusoroadeolu.clique.Clique;
import io.github.kusoroadeolu.clique.components.Table;
import io.github.kusoroadeolu.clique.configuration.TableType;
import io.travel.enums.ItemType;
import io.travel.enums.WizardResult;
import io.travel.model.BudgetSummary;
import io.travel.model.ItineraryItem;
import io.travel.model.Trip;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.util.HashMap;
import java.util.Map;

public class DisplayBudgetStep  implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        WizardResult result = WizardResult.CONTINUE;
        Trip trip = context.getSelectedTrip();
        int estimatedCostTotal = trip.getItineraries().stream().mapToInt(ItineraryItem::getEstimatedCost).sum();
        int actualCostTotal = trip.getItineraries().stream().mapToInt(ItineraryItem::getActualCost).sum();
        int remaining = trip.getTotalBudget() - estimatedCostTotal;
        Map<ItemType, Integer> categoryBreakdown = new HashMap<>();
        for (ItemType itemType : ItemType.values()) {
            int categoryTotal = trip.getItineraries().stream().filter(itineraryItem -> itemType.equals(itineraryItem.getItemType())).mapToInt(ItineraryItem::getEstimatedCost).sum();
            categoryBreakdown.put(itemType, categoryTotal);
        }

        BudgetSummary budgetSummary = new BudgetSummary(trip.getTotalBudget(), actualCostTotal, remaining, categoryBreakdown);

        Table table = Clique.table(TableType.BOX_DRAW)
                .headers("ESTIMATED TOTAL BUDGET", "ACTUAL TOTAL COSTS", "REMAINING ESTIMATED BUDGET")
                        .row("$" + budgetSummary.estimatedTotal(), "$" + budgetSummary.actualCost(), "$" + remaining);
        table.render();

        System.out.println();
        System.out.println("CATEGORY BREAKDOWN");
        Table categoryBreakdownTable = Clique.table(TableType.BOX_DRAW).headers("ITEM TYPE", "ESTIMATED COST");
        for(Map.Entry<ItemType, Integer> entry : categoryBreakdown.entrySet()) {
            categoryBreakdownTable.row(entry.getKey().name(), "$" + entry.getValue());
        }
        categoryBreakdownTable.render();

        context.setBudgetSummary(budgetSummary);
        return result;
    }
}