package by.kurilo.computer.internalcomponents.memory;

import by.kurilo.computer.interfaces.Displayable;

public class Memory implements Displayable {
    private int capacity;
    private String type;
    private boolean isTesting;

    public Memory(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
        this.isTesting = false;
    }

    public void testMemory() {
        isTesting = true;
        System.out.println("Testing memory...");
        isTesting = false;
        System.out.println("Memory test completed successfully.");
    }

    public void upgradeMemory(int additionalCapacity) {
        this.capacity += additionalCapacity;
        System.out.println("Memory upgraded to " + capacity + "GB.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Memory: " + capacity + "GB, Type: " + type);
    }


}
