package by.kurilo.computer.internalcomponents.processor;

import by.kurilo.computer.interfaces.Displayable;

public class Processor implements Displayable {
    private String model;
    private int cores;
    private double clockSpeed;
    private boolean isOverclocked;

    public Processor(String model, int cores, double clockSpeed) {
        this.model = model;
        this.cores = cores;
        this.clockSpeed = clockSpeed;
        this.isOverclocked = false;
    }

    public void overclock(double increment) {
        this.clockSpeed += increment;
        this.isOverclocked = true;
        System.out.println("Processor overclocked to " + clockSpeed + "GHz");
    }

    public void resetClock() {
        this.clockSpeed = 3.5;  // Assume default clock speed
        this.isOverclocked = false;
        System.out.println("Processor clock speed reset to default.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Processor: " + model
                + ", Cores: " + cores
                + ", Speed: " + clockSpeed
                + "GHz, Overclocked: " + isOverclocked);
    }


}
