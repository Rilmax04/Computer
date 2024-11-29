package by.kurilo.computer.user;

import by.kurilo.computer.computer.Computer;
import by.kurilo.computer.internalcomponents.coolingsystem.impl.AirCooling;
import by.kurilo.computer.internalcomponents.graphicscard.GraphicsCard;
import by.kurilo.computer.internalcomponents.memory.Memory;
import by.kurilo.computer.externalcomponents.monitor.Monitor;
import by.kurilo.computer.internalcomponents.operatingsystem.OperatingSystem;
import by.kurilo.computer.externalcomponents.powersupply.PowerSupply;
import by.kurilo.computer.internalcomponents.processor.Processor;
import by.kurilo.computer.internalcomponents.storage.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserTest {

    private User user;
    private Computer computer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        Processor processor = new Processor("Intel", 8, 3.5);
        Memory memory = new Memory(16, "DDR4");
        Storage storage = new Storage(1000, "SSD");
        GraphicsCard graphicsCard = new GraphicsCard("NVIDIA", 8);
        OperatingSystem os = new OperatingSystem("Windows", "10");
        AirCooling airCooling = new AirCooling(1200, 2);
        PowerSupply powerSupply = new PowerSupply(500);
        Monitor monitor = new Monitor("1920x1080", 60);

        computer = new Computer(processor, memory, storage, graphicsCard, os, airCooling, powerSupply, monitor);
        user = new User("John");
    }

    @Test
    public void testUseComputer() {
        user.useComputer(computer);
        assertTrue(outContent.toString().trim().contains("John is using the computer."));
    }

    @Test
    public void testUseComputerBoot() {
        user.useComputer(computer);
        assertTrue(outContent.toString().trim().contains("Booting the computer..."));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}