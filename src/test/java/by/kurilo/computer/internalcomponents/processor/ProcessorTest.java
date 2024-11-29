package by.kurilo.computer.internalcomponents.processor;

import by.kurilo.computer.internalcomponents.processor.Processor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProcessorTest {

    private Processor processor;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        processor = new Processor("Intel i7", 8, 3.5);
    }

    @Test
    public void testOverclock() {
        processor.overclock(0.5);
        assertTrue(outContent.toString().trim().contains("Processor overclocked to 4.0GHz"));
    }

    @Test
    public void testResetClock() {
        processor.overclock(0.5);  // Overclock first
        processor.resetClock();
        assertTrue(outContent.toString().trim().contains("Processor clock speed reset to default."));
    }

    @Test
    public void testDisplayInfo() {
        processor.displayInfo();
        assertTrue(outContent.toString().trim().contains("Processor: Intel i7, Cores: 8, Speed: 3.5GHz, Overclocked: false"));
    }

    @Test
    public void testOverclockAndDisplayInfo() {
        processor.overclock(1.0);
        processor.displayInfo();
        assertTrue(outContent.toString().trim().contains("Processor: Intel i7, Cores: 8, Speed: 4.5GHz, Overclocked: true"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}