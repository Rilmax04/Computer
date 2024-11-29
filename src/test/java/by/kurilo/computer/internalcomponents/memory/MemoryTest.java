package by.kurilo.computer.internalcomponents.memory;

import by.kurilo.computer.internalcomponents.memory.Memory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MemoryTest {

    private Memory memory;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        memory = new Memory(16, "DDR4");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testConstructor() {
        assertNotNull(memory);
    }

    @Test
    public void testDisplayInfoOutput() {
        memory.displayInfo();
        assertTrue(outContent.toString().trim().contains("Memory: 16GB, Type: DDR4"));
    }

    @Test
    public void testMemoryTestOutput() {
        memory.testMemory();
        assertTrue(outContent.toString().trim().contains("Testing memory..."));
        assertTrue(outContent.toString().trim().contains("Memory test completed successfully."));
    }

    @Test
    public void testUpgradeMemory() {
        memory.upgradeMemory(16);
        assertTrue(outContent.toString().trim().contains("Memory upgraded to 32GB."));
        memory.displayInfo();
        assertTrue(outContent.toString().trim().contains("Memory: 32GB, Type: DDR4"));
    }

    @Test
    public void testEdgeCaseZeroCapacityUpgrade() {
        memory.upgradeMemory(0);
        assertTrue(outContent.toString().trim().contains("Memory upgraded to 16GB."));
    }

    @Test
    public void testNegativeCapacityUpgrade() {
        memory.upgradeMemory(-4);
        assertTrue(outContent.toString().trim().contains("Memory upgraded to 12GB."));
        memory.displayInfo();
        assertTrue(outContent.toString().trim().contains("Memory: 12GB, Type: DDR4"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}