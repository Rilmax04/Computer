package by.kurilo.computer.externalcomponents.monitor;

import by.kurilo.computer.interfaces.Displayable;

public class Monitor implements Displayable {
    private String resolution;
    private int refreshRate; // Hz
    private boolean isOn;

    public Monitor(String resolution, int refreshRate) {
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Monitor turned ON. Resolution: " + resolution + ", Refresh Rate: " + refreshRate + "Hz");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Monitor turned OFF.");
    }

    public void changeResolution(String newResolution) {
        this.resolution = newResolution;
        System.out.println("Resolution changed to " + newResolution);
    }

    @Override
    public void displayInfo() {
        System.out.println("Monitor: Resolution: " + resolution + ", Refresh Rate: " + refreshRate + "Hz, Status: " + (isOn ? "ON" : "OFF"));
    }
}
