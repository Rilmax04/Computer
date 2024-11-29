package by.kurilo.computer.externalcomponents.peripheraldevice;

import by.kurilo.computer.externalcomponents.peripheraldevice.impl.Keyboard;
import by.kurilo.computer.externalcomponents.peripheraldevice.impl.Mouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PeripheralDeviceTest {

    private PeripheralDevice peripheralDevice;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPeripheralDeviceConnectUSB() {
        peripheralDevice = new Keyboard("Logitech", "USB");
        peripheralDevice.connect();
        assertTrue(outContent.toString().trim().contains("Keyboard connected via USB"));
    }

    @Test
    public void testPeripheralDeviceConnectBluetooth() {
        peripheralDevice = new Mouse("Microsoft", "Bluetooth");
        peripheralDevice.connect();
        assertTrue(outContent.toString().trim().contains("Mouse connected via Bluetooth"));
    }

    @Test
    public void testPeripheralDeviceDisplayInfo() {
        peripheralDevice = new Keyboard("Logitech", "USB");
        peripheralDevice.displayInfo();
        assertTrue(outContent.toString().trim().contains("Keyboard: Logitech, Connection: USB"));
    }

    @Test
    public void testPeripheralDeviceDisconnect() {
        peripheralDevice = new Mouse("Microsoft", "Bluetooth");
        peripheralDevice.disconnect();
        assertTrue(outContent.toString().trim().contains("Mouse disconnected."));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}