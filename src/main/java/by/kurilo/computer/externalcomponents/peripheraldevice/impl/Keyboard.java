package by.kurilo.computer.externalcomponents.peripheraldevice.impl;

import by.kurilo.computer.externalcomponents.peripheraldevice.PeripheralDevice;

public class Keyboard extends PeripheralDevice {
    public Keyboard(String brand, String connectionType) {
        super(brand, connectionType);
    }

    @Override
    public void displayInfo() {
        System.out.println("Keyboard: " + brand + ", Connection: " + connectionType);
    }

    @Override
    public void connect() {
        System.out.println("Keyboard connected via " + connectionType);
    }

    @Override
    public void disconnect() {
        System.out.println("Keyboard disconnected.");
    }
}
