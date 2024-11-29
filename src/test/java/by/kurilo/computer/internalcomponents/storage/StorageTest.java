package by.kurilo.computer.internalcomponents.storage;

import by.kurilo.computer.internalcomponents.storage.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StorageTest {

    private Storage storage;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        storage = new Storage(500, "SSD");
    }

    @Test
    public void testWriteDataSuccessful() {
        storage.writeData(100);
        assertTrue(outContent.toString().trim().contains("100GB written to storage. Used space: 100GB"));
    }

    @Test
    public void testWriteDataNotEnoughSpace() {
        storage.writeData(600); // Trying to write more data than the capacity
        assertTrue(outContent.toString().trim().contains("Not enough storage space!"));
    }

    @Test
    public void testFormatStorage() {
        storage.writeData(200);
        storage.formatStorage();
        assertTrue(outContent.toString().trim().contains("Storage formatted. All data erased."));
    }

    @Test
    public void testDisplayInfo() {
        storage.writeData(200);
        storage.displayInfo();
        assertTrue(outContent.toString().trim().contains("Storage: 500GB, Type: SSD, Used: 200GB"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}