package by.kurilo.computer.externalcomponents.powersupply;

import by.kurilo.computer.externalcomponents.powersupply.PowerSupply;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PowerSupplyTest {

    private PowerSupply powerSupply;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        powerSupply = new PowerSupply(500);
    }

    @Test
    public void testTurnOn() {
        powerSupply.turnOn();
        assertTrue(outContent.toString().trim().contains("Power supply is ON. Providing 500 watts."));
    }

    @Test
    public void testTurnOff() {
        powerSupply.turnOff();
        assertTrue(outContent.toString().trim().contains("Power supply is OFF."));
    }

    @Test
    public void testDisplayInfoWhenOff() {
        powerSupply.displayInfo();
        assertTrue(outContent.toString().trim().contains("Power Supply: 500W, Status: OFF"));
    }

    @Test
    public void testDisplayInfoWhenOn() {
        powerSupply.turnOn();
        powerSupply.displayInfo();
        assertTrue(outContent.toString().trim().contains("Power Supply: 500W, Status: ON"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}