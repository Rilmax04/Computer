package by.kurilo.computer.internalcomponents.coolingsystem.impl;

import by.kurilo.computer.internalcomponents.coolingsystem.CoolingSystem;

public class LiquidCooling extends CoolingSystem {
    private int pumpSpeed;

    public LiquidCooling(int fanSpeed, int pumpSpeed) {
        super(fanSpeed);
        this.pumpSpeed = pumpSpeed;
    }

    @Override
    public void coolDown() {
        System.out.println("Liquid cooling system is circulating coolant at " + pumpSpeed + " RPM to reduce temperature...");
    }

    @Override
    public void displayInfo() {
        System.out.println("Liquid Cooling System: Fan Speed: " + fanSpeed + " RPM, Pump Speed: " + pumpSpeed + " RPM");
    }
}
