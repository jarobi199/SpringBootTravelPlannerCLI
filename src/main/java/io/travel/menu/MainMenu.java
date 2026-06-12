package io.travel.menu;

import io.travel.util.InputHandler;

public class MainMenu implements IMenu {
    @Override
    public void show() {
        int choice;
        do {
            printOptions();
            choice = InputHandler.getIntegerInput();
            switch (choice) {
              //TODO: Add code here
            }
        }
        while (choice != 0);
    }

    @Override
    public void printOptions() {
        System.out.println("[1] Plan a new trip");
        System.out.println("[2] Add itinerary item");
        System.out.println("[3] Review budget");
        System.out.println("[4] Write journal entry");
        System.out.println("[5] Trip summary");
        System.out.println("[6] My trips");
        System.out.println("[0] Quit");
    }
}

