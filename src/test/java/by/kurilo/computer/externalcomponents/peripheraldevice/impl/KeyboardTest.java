package by.kurilo.computer.externalcomponents.peripheraldevice.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class KeyboardTest {

    private Keyboard keyboard;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testKeyboardConnectionUSB() {
        keyboard = new Keyboard("Logitech", "USB");
        keyboard.connect();
        assertTrue(outContent.toString().trim().contains("Keyboard connected via USB"));
    }

    @Test
    public void testKeyboardConnectionBluetooth() {
        keyboard = new Keyboard("Microsoft", "Bluetooth");
        keyboard.connect();
        assertTrue(outContent.toString().trim().contains("Keyboard connected via Bluetooth"));
    }

    @Test
    public void testDisplayInfo() {
        keyboard = new Keyboard("Logitech", "USB");
        keyboard.displayInfo();
        assertTrue(outContent.toString().trim().contains("Keyboard: Logitech, Connection: USB"));
    }

    @Test
    public void testDisconnect() {
        keyboard = new Keyboard("Microsoft", "Bluetooth");
        keyboard.disconnect();
        assertTrue(outContent.toString().trim().contains("Keyboard disconnected."));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}
