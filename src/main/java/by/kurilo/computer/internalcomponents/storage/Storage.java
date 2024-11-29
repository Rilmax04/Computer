package by.kurilo.computer.internalcomponents.storage;

import by.kurilo.computer.interfaces.Displayable;

public class Storage implements Displayable {
    private int capacity;
    private String type;
    private int usedSpace;

    public Storage(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
        this.usedSpace = 0;
    }

    public void writeData(int size) {
        if (usedSpace + size > capacity) {
            System.out.println("Not enough storage space!");
        } else {
            usedSpace += size;
            System.out.println(size + "GB written to storage. Used space: " + usedSpace + "GB");
        }
    }

    public void formatStorage() {
        usedSpace = 0;
        System.out.println("Storage formatted. All data erased.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Storage: " + capacity + "GB, Type: " + type + ", Used: " + usedSpace + "GB");
    }
}
