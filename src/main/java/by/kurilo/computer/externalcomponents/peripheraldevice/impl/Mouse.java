package by.kurilo.computer.externalcomponents.peripheraldevice.impl;

import by.kurilo.computer.externalcomponents.peripheraldevice.PeripheralDevice;

public class Mouse extends PeripheralDevice {
    public Mouse(String brand, String connectionType) {
        super(brand, connectionType);
    }

    @Override
    public void displayInfo() {
        System.out.println("Mouse: " + brand + ", Connection: " + connectionType);
    }

    @Override
    public void connect() {
        System.out.println("Mouse connected via " + connectionType);
    }

    @Override
    public void disconnect() {
        System.out.println("Mouse disconnected.");
    }
}
