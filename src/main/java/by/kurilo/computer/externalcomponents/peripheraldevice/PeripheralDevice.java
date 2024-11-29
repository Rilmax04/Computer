package by.kurilo.computer.externalcomponents.peripheraldevice;

import by.kurilo.computer.interfaces.Displayable;

public abstract class PeripheralDevice implements Displayable {

    protected String brand;
    protected String connectionType;

    public PeripheralDevice(String brand, String connectionType) {
        this.brand = brand;
        this.connectionType = connectionType;
    }

    public abstract void connect();

    public abstract void disconnect();
}
