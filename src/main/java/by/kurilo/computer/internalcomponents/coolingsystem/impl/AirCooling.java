package by.kurilo.computer.internalcomponents.coolingsystem.impl;

import by.kurilo.computer.internalcomponents.coolingsystem.CoolingSystem;

public class AirCooling extends CoolingSystem {
    private int numberOfFans;

    public AirCooling(int fanSpeed, int numberOfFans) {
        super(fanSpeed);
        this.numberOfFans = numberOfFans;
    }

    @Override
    public void coolDown() {
        System.out.println("Air cooling system with " + numberOfFans + " fans is reducing temperature...");
    }

    @Override
    public void displayInfo() {
        System.out.println("Air Cooling System: " + numberOfFans + " fans, Fan Speed: " + fanSpeed + " RPM");
    }

}
