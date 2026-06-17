package io.travel.model;

import io.travel.enums.ItemType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class HotelItem extends ItineraryItem {
    private String name;
    private String address;
    private LocalDateTime checkOutDateTime;
    private int price;
    private String confirmationCode;

    public HotelItem() {
        //No argument constructor
    }

    public HotelItem( LocalDateTime checkInDateTime, ItemType itemType, String name, String address, LocalDateTime checkOutDateTime, int price, String confirmationCode) {
        super(checkInDateTime, itemType);
        this.name = name;
        this.address = address;
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
        return Math.toIntExact(ChronoUnit.DAYS.between(dateTime, checkOutDateTime) * price);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Check-in date and time: " + dateTime + "\n" +
                "Check-out date and time: " + checkOutDateTime + "\n" +
                "Price: " + price + "\n" +
                "Confirmation code: " + confirmationCode;
    }
}
