package by.kurilo.computer.computer;

import by.kurilo.computer.internalcomponents.coolingsystem.impl.AirCooling;
import by.kurilo.computer.internalcomponents.graphicscard.GraphicsCard;
import by.kurilo.computer.internalcomponents.memory.Memory;
import by.kurilo.computer.externalcomponents.monitor.Monitor;
import by.kurilo.computer.internalcomponents.operatingsystem.OperatingSystem;
import by.kurilo.computer.externalcomponents.powersupply.PowerSupply;
import by.kurilo.computer.internalcomponents.processor.Processor;
import by.kurilo.computer.internalcomponents.storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComputerTest {

    private Computer computer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {

        Processor processor = new Processor("Intel i7", 8, 3.5);
        Memory memory = new Memory(16, "DDR4");
        Storage storage = new Storage(512, "SSD");
        GraphicsCard graphicsCard = new GraphicsCard("NVIDIA GTX", 8);
        OperatingSystem os = new OperatingSystem("Windows", "10");
        AirCooling airCooling = new AirCooling(1200, 3);
        PowerSupply powerSupply = new PowerSupply(650);
        Monitor monitor = new Monitor("1920x1080", 60);


        computer = new Computer(processor, memory, storage, graphicsCard, os, airCooling, powerSupply, monitor);


        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testBoot() {
        assertDoesNotThrow(() -> computer.boot());
    }

    @Test
    void testShutdown() {
        assertDoesNotThrow(() -> computer.shutdown());
    }

    @Test
    void testRunBenchmark() {
        assertDoesNotThrow(() -> computer.runBenchmark());
    }

    @Test
    void testDisplayConfiguration() {
        assertDoesNotThrow(() -> computer.displayConfiguration());
    }
}