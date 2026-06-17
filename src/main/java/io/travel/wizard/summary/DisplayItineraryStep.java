package io.travel.wizard.summary;

import io.github.kusoroadeolu.clique.Clique;
import io.github.kusoroadeolu.clique.components.Table;
import io.github.kusoroadeolu.clique.configuration.TableType;
import io.travel.enums.WizardResult;
import io.travel.model.DayItinerary;
import io.travel.model.ItineraryItem;
import io.travel.model.Trip;
import io.travel.wizard.IWizardStep;
import io.travel.wizard.WizardContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayItineraryStep implements IWizardStep {
    @Override
    public WizardResult execute(WizardContext context) {
        Trip trip = context.getSelectedTrip();
        List<ItineraryItem> itineraryItems = trip.getItineraries();
        List<DayItinerary> dayItineraries = new ArrayList<>();
        Map<LocalDate, List<ItineraryItem>> dayItinerariesMap = new HashMap<>();

        //Map each date (without time) to a list of ItineraryItem objects
        for(ItineraryItem itineraryItem : itineraryItems) {
            if(dayItinerariesMap.containsKey(itineraryItem.getDateTime().toLocalDate())) {
                dayItinerariesMap.get(itineraryItem.getDateTime().toLocalDate()).add(itineraryItem);
            }
            else
            {
                dayItinerariesMap.put(itineraryItem.getDateTime().toLocalDate(), new ArrayList<>(List.of(itineraryItem)));
            }
        }

        //Create list of DayItinerary objects
        for(Map.Entry<LocalDate, List<ItineraryItem>> entry : dayItinerariesMap.entrySet()) {
            LocalDate date = entry.getKey();
            int estimatedTotal = entry.getValue().stream().mapToInt(ItineraryItem::getEstimatedCost).sum();
            DayItinerary dayItinerary = new DayItinerary(date, entry.getValue(), estimatedTotal);
            dayItineraries.add(dayItinerary);
        }

        //Traverse and display results
        System.out.println("ITINERARY ITEMS BY DATE");
        for(DayItinerary dayItinerary : dayItineraries) {
            System.out.println("------------------------------------------------------");
            System.out.println("DATE: " + dayItinerary.date());
            System.out.println("ESTIMATED TOTAL: $" + dayItinerary.estimatedTotal());
            System.out.println("ITINERARY ITEMS: ");
            for(ItineraryItem itineraryItem : dayItinerary.items()) {
                System.out.println("===");
                System.out.println(itineraryItem);
                System.out.println("===");
            }
            System.out.println("------------------------------------------------------");
        }
        System.out.println();

        return WizardResult.CONTINUE;
    }

}
