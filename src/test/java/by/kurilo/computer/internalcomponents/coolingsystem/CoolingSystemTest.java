package by.kurilo.computer.internalcomponents.coolingsystem;

import by.kurilo.computer.internalcomponents.coolingsystem.impl.LiquidCooling;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoolingSystemTest {

    private LiquidCooling liquidCooling;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        liquidCooling = new LiquidCooling(1200, 2500);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDisplayInfoOutput() {
        liquidCooling.displayInfo();
        assertTrue(outContent.toString().trim().contains("Liquid Cooling System: Fan Speed: 1200 RPM, Pump Speed: 2500 RPM"));
    }

    @Test
    public void testCoolDownOutput() {
        liquidCooling.coolDown();
        assertTrue(outContent.toString().trim().contains("Liquid cooling system is circulating coolant at 2500 RPM to reduce temperature..."));
    }

    @Test
    public void testIncreaseFanSpeed() {
        liquidCooling.increaseFanSpeed(300);
        assertTrue(outContent.toString().trim().contains("Fan speed increased to 1500 RPM"));
    }

    @Test
    public void testDecreaseFanSpeed() {
        liquidCooling.decreaseFanSpeed(200);
        assertTrue(outContent.toString().trim().contains("Fan speed decreased to 1000 RPM"));
    }

    @Test
    public void testNegativeFanSpeed() {
        liquidCooling.decreaseFanSpeed(1300);
        assertTrue(outContent.toString().trim().contains("Fan speed decreased to -100 RPM"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
