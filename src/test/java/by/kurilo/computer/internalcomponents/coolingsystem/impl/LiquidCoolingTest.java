package by.kurilo.computer.internalcomponents.coolingsystem.impl;

import by.kurilo.computer.internalcomponents.coolingsystem.impl.LiquidCooling;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LiquidCoolingTest {

    private LiquidCooling liquidCooling;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDisplayInfo() {
        liquidCooling = new LiquidCooling(1500, 3000);
        liquidCooling.displayInfo();
        assertTrue(outContent.toString().trim().contains("Liquid Cooling System: Fan Speed: 1500 RPM, Pump Speed: 3000 RPM"));
    }

    @Test
    public void testCoolDown() {
        liquidCooling = new LiquidCooling(2000, 3500);
        liquidCooling.coolDown();
        assertTrue(outContent.toString().trim().contains("Liquid cooling system is circulating coolant at 3500 RPM to reduce temperature..."));
    }

    @Test
    public void testEdgeCaseLowFanSpeed() {
        liquidCooling = new LiquidCooling(0, 2500);
        liquidCooling.displayInfo();
        assertTrue(outContent.toString().trim().contains("Fan Speed: 0 RPM"));
    }

    @Test
    public void testEdgeCaseLowPumpSpeed() {
        liquidCooling = new LiquidCooling(1200, 0);
        liquidCooling.coolDown();
        assertTrue(outContent.toString().trim().contains("Liquid cooling system is circulating coolant at 0 RPM"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}