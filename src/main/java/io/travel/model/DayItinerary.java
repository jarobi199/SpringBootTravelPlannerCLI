package io.travel.model;

import java.time.LocalDate;
import java.util.List;

public record DayItinerary(int dayNumber, LocalDate date, List<ItineraryItem> items, int estimatedTotal) {}
