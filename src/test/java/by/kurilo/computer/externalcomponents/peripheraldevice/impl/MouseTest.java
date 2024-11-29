package by.kurilo.computer.externalcomponents.peripheraldevice.impl;

import by.kurilo.computer.externalcomponents.peripheraldevice.impl.Mouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MouseTest {

    private Mouse mouse;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testConnectUSB() {
        mouse = new Mouse("Logitech", "USB");
        mouse.connect();
        assertTrue(outContent.toString().trim().contains("Mouse connected via USB"));
    }

    @Test
    public void testConnectBluetooth() {
        mouse = new Mouse("Microsoft", "Bluetooth");
        mouse.connect();
        assertTrue(outContent.toString().trim().contains("Mouse connected via Bluetooth"));
    }

    @Test
    public void testDisconnect() {
        mouse = new Mouse("Logitech", "USB");
        mouse.disconnect();
        assertTrue(outContent.toString().trim().contains("Mouse disconnected."));
    }

    @Test
    public void testDisplayInfo() {
        mouse = new Mouse("Logitech", "USB");
        mouse.displayInfo();
        assertTrue(outContent.toString().trim().contains("Mouse: Logitech, Connection: USB"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}