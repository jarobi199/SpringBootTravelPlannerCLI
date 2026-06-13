package io.travel.model;

import io.travel.enums.TripStatus;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trip {
    @Id
    private String id;
    private String userId;
    private String name;
    private String country;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalBudget;
    private TripStatus status;
    private List<ItineraryItem> itineraries;
    private List<JournalEntry> journals;

    public Trip() {
        this.itineraries = new ArrayList<>();
        this.journals = new ArrayList<>();
    }

    public Trip(String userId, String name, String country, LocalDate startDate, LocalDate endDate, int totalBudget, TripStatus status) {
        this.userId = userId;
        this.name = name;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBudget = totalBudget;
        this.status = status;
        this.itineraries = new ArrayList<>();
        this.journals = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public List<ItineraryItem> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<ItineraryItem> itineraries) {
        this.itineraries = itineraries;
    }

    public List<JournalEntry> getJournals() {
        return journals;
    }

    public void setJournals(List<JournalEntry> journals) {
        this.journals = journals;
    }
}
