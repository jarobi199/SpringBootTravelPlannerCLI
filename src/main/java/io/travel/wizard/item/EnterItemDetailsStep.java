package io.travel.wizard.item;

import io.travel.enums.ItemType;
import io.travel.enums.WizardResult;
import io.travel.factory.ItineraryItemFactory;
import io.travel.model.ItineraryItem;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

public class EnterItemDetailsStep implements IWizardStep {

    @Override
    public WizardResult execute(WizardContext context) {
        WizardResult result = WizardResult.CONTINUE;
        System.out.println("Select the item type (FLIGHT, HOTEL, ACTIVITY, RESTAURANT, TRANSPORT)");
        ItemType itemType = ItemType.valueOf(InputHandler.getStringInput());
        ItineraryItem itineraryItem = ItineraryItemFactory.create(itemType, context.getDateTime());
        context.setPendingItem(itineraryItem);

        return result;
    }

}
