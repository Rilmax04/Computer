package by.kurilo.computer.internalcomponents.graphicscard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GraphicsCardTest {

    private GraphicsCard graphicsCard;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        graphicsCard = new GraphicsCard("NVIDIA RTX 3080", 10);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testRenderGraphics() {
        graphicsCard.renderGraphics();
        String output = outContent.toString();
        assertTrue(output.contains("Rendering graphics with NVIDIA RTX 3080..."));
        assertTrue(output.contains("Rendering complete."));
    }

    @Test
    public void testUpdateDriver() {
        graphicsCard.updateDriver();
        String output = outContent.toString();
        assertTrue(output.contains("Updating graphics driver for NVIDIA RTX 3080..."));
    }

    @Test
    public void testDisplayInfo() {
        graphicsCard.displayInfo();
        String output = outContent.toString();
        assertTrue(output.contains("Graphics Card: NVIDIA RTX 3080, VRAM: 10GB"));
    }
}