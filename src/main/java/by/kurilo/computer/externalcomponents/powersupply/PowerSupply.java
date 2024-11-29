package by.kurilo.computer.externalcomponents.powersupply;

import by.kurilo.computer.interfaces.Displayable;

public class PowerSupply implements Displayable {
    private int powerOutput;
    private boolean isOn;

    public PowerSupply(int powerOutput) {
        this.powerOutput = powerOutput;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Power supply is ON. Providing " + powerOutput + " watts.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Power supply is OFF.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Power Supply: " + powerOutput + "W, Status: " + (isOn ? "ON" : "OFF"));
    }
}
