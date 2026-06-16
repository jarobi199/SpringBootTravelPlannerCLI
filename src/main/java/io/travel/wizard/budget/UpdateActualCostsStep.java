package io.travel.wizard.budget;

import io.travel.bridge.SpringContext;
import io.travel.enums.WizardResult;
import io.travel.model.*;
import io.travel.service.TripService;
import io.travel.util.InputHandler;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.util.List;

public class UpdateActualCostsStep implements IWizardStep {
    @Override
    public WizardResult execute(WizardContext context) {

        WizardResult result = WizardResult.CONTINUE;
        Trip trip = context.getSelectedTrip();
        List<ItineraryItem> itineraryItems = trip.getItineraries();

        if(!itineraryItems.isEmpty()) {
            String keepGoing = "Y";
            System.out.println();
            System.out.println("UPDATE ACTUAL COSTS:");
            while("Y".equalsIgnoreCase(keepGoing)) {
                int i = 1;
                for (ItineraryItem itineraryItem : itineraryItems) {
                    String label = getLabel(itineraryItem);
                    System.out.println("[" + i + "] " + itineraryItem.getItemType().name() + " - " + label );
                    i++;
                }

                System.out.println("Please select a itinerary item:");
                int selection = InputHandler.getIntegerInput();
                ItineraryItem item = itineraryItems.get(selection - 1);
                System.out.println("Please enter the actual cost:");
                int actualCost = InputHandler.getIntegerInput();
                item.setActualCost(actualCost);

                System.out.println("Continue? Y/N:");
                keepGoing = InputHandler.getStringInput();
            }
        }

        return result;
    }

    private String getLabel(ItineraryItem itineraryItem) {
        String label = "";
        switch (itineraryItem) {
            case HotelItem h ->  label = h.getName();
            case ActivityItem a ->  label = a.getName();
            case FlightItem f ->  label = f.getAirline() + " " + f.getFlightNumber();
            case TransportItem t ->  label = t.getTransportType().name();
            case RestaurantItem r ->  label = r.getName();
            default -> throw new IllegalStateException("Unexpected value: " + itineraryItem);
        }

        return label;
    }
}
