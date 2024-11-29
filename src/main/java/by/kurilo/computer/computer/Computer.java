package by.kurilo.computer.computer;

import by.kurilo.computer.internalcomponents.coolingsystem.impl.AirCooling;
import by.kurilo.computer.internalcomponents.graphicscard.GraphicsCard;
import by.kurilo.computer.internalcomponents.memory.Memory;
import by.kurilo.computer.externalcomponents.monitor.Monitor;
import by.kurilo.computer.internalcomponents.operatingsystem.OperatingSystem;
import by.kurilo.computer.externalcomponents.powersupply.PowerSupply;
import by.kurilo.computer.internalcomponents.processor.Processor;
import by.kurilo.computer.internalcomponents.storage.Storage;

public class Computer {
    private Processor processor;
    private Memory memory;
    private Storage storage;
    private GraphicsCard graphicsCard;
    private OperatingSystem os;
    private AirCooling airCooling;
    private PowerSupply powerSupply;
    private Monitor monitor;

    public Computer(Processor processor,
                    Memory memory,
                    Storage storage, GraphicsCard graphicsCard, OperatingSystem os,
                    AirCooling airCooling, PowerSupply powerSupply, Monitor monitor) {
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.os = os;
        this.airCooling = airCooling;
        this.powerSupply = powerSupply;
        this.monitor = monitor;
    }

    public void boot() {
        powerSupply.turnOn();
        monitor.turnOn();
        System.out.println("Booting the computer...");
        os.displayInfo();
    }

    public void shutdown() {
        System.out.println("Shutting down the computer...");
        monitor.turnOff();
        powerSupply.turnOff();
    }

    public void runBenchmark() {
        System.out.println("Running performance benchmark...");
        processor.overclock(0.5);
        memory.testMemory();
        graphicsCard.renderGraphics();
        airCooling.coolDown();
        processor.resetClock();
        System.out.println("Benchmark completed.");
    }

    public void displayConfiguration() {
        processor.displayInfo();
        memory.displayInfo();
        storage.displayInfo();
        graphicsCard.displayInfo();
        os.displayInfo();
        airCooling.displayInfo();
        powerSupply.displayInfo();
        monitor.displayInfo();
    }
}
