package io.travel.model;

import java.time.LocalDate;
import java.util.List;

public record DayItinerary(LocalDate date, List<ItineraryItem> items, int estimatedTotal) {}
