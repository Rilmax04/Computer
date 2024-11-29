package by.kurilo.computer.internalcomponents.coolingsystem.impl;

import by.kurilo.computer.internalcomponents.coolingsystem.impl.AirCooling;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AirCoolingTest {

    private AirCooling airCooling;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {

        airCooling = new AirCooling(1200, 3);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testConstructor() {

        assertNotNull(airCooling);
    }

    @Test
    public void testCoolDownOutput() {
        airCooling.coolDown();
        assertTrue(outContent.toString().trim().contains("Air cooling system with 3 fans is reducing temperature..."));
    }

    @Test
    public void testDisplayInfoOutput() {
        airCooling.displayInfo();
        assertTrue(outContent.toString().trim().contains("Air Cooling System: 3 fans, Fan Speed: 1200 RPM"));
    }

    @Test
    public void testEdgeCaseZeroFans() {
        AirCooling zeroFanCooling = new AirCooling(1500, 0);
        zeroFanCooling.coolDown();
        assertTrue(outContent.toString().trim().contains("Air cooling system with 0 fans is reducing temperature..."));
    }

    @Test
    public void testNegativeFanSpeed() {
        AirCooling negativeSpeedCooling = new AirCooling(-500, 2);
        negativeSpeedCooling.displayInfo();
        assertTrue(outContent.toString().trim().contains("Fan Speed: -500 RPM"));
    }

    @Test
    public void testMultipleFans() {
        AirCooling manyFansCooling = new AirCooling(1400, 10);
        manyFansCooling.coolDown();
        assertTrue(outContent.toString().trim().contains("Air cooling system with 10 fans is reducing temperature..."));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}