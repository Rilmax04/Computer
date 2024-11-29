package by.kurilo.computer.externalcomponents.monitor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MonitorTest {

    private Monitor monitor;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        monitor = new Monitor("1920x1080", 60);
    }

    @Test
    public void testTurnOn() {
        monitor.turnOn();
        assertTrue(outContent.toString().trim().contains("Monitor turned ON. Resolution: 1920x1080, Refresh Rate: 60Hz"));
    }

    @Test
    public void testTurnOff() {
        monitor.turnOff();
        assertTrue(outContent.toString().trim().contains("Monitor turned OFF."));
    }

    @Test
    public void testChangeResolution() {
        monitor.changeResolution("2560x1440");
        assertTrue(outContent.toString().trim().contains("Resolution changed to 2560x1440"));
    }

    @Test
    public void testDisplayInfoWhenOff() {
        monitor.displayInfo();
        assertTrue(outContent.toString().trim().contains("Monitor: Resolution: 1920x1080, Refresh Rate: 60Hz, Status: OFF"));
    }

    @Test
    public void testDisplayInfoWhenOn() {
        monitor.turnOn();
        monitor.displayInfo();
        assertTrue(outContent.toString().trim().contains("Monitor: Resolution: 1920x1080, Refresh Rate: 60Hz, Status: ON"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}