package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class HotelItem extends ItineraryItem {
    private String name;
    private String address;
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;
    private int price;
    private String confirmationCode;

    public HotelItem() {
        //No argument constructor
    }

    public HotelItem(int dayNumber, ItemType itemType, String name, String address, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, int price, String confirmationCode) {
        super(dayNumber, itemType);
        this.name = name;
        this.address = address;
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
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

    public LocalDateTime checkInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDate(LocalDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    public LocalDateTime getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(LocalDateTime checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Override
    public int getEstimatedCost() {
        return Math.toIntExact(ChronoUnit.DAYS.between(checkInDateTime, checkOutDateTime) * price);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Check-in date and time:" + checkInDateTime + "\n" +
                "Check-out date and time: " + checkOutDateTime + "\n" +
                "Price: " + price + "\n" +
                "Confirmation code: " + confirmationCode + "\n";
    }
}
