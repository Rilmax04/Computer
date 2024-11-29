package by.kurilo.computer.internalcomponents.coolingsystem;

import by.kurilo.computer.interfaces.Displayable;

public abstract class CoolingSystem implements Displayable {

    protected int fanSpeed;

    public CoolingSystem(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public abstract void coolDown();

    public void increaseFanSpeed(int increment) {
        fanSpeed += increment;
        System.out.println("Fan speed increased to " + fanSpeed + " RPM");
    }

    public void decreaseFanSpeed(int decrement) {
        fanSpeed -= decrement;
        System.out.println("Fan speed decreased to " + fanSpeed + " RPM");
    }

    @Override
    public abstract void displayInfo();

}
