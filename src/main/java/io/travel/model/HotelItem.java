package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class HotelItem extends ItineraryItem {
    private String name;
    private String address;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double price;
    private String confirmationCode;

    public HotelItem() {
        //No argument constructor
    }

    public HotelItem(int dayNumber, ItemType itemType, String name, String address, LocalDate checkInDate, LocalDate checkOutDate, double price, String confirmationCode) {
        super(dayNumber, itemType);
        this.name = name;
        this.address = address;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
        this.confirmationCode = confirmationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Override
    public double getEstimatedCost() {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate) * price;
    }
}
