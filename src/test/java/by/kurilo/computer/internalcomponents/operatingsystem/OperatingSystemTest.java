package by.kurilo.computer.internalcomponents.operatingsystem;

import by.kurilo.computer.internalcomponents.operatingsystem.OperatingSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OperatingSystemTest {

    private OperatingSystem os;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        os = new OperatingSystem("Windows", "10");
    }

    @Test
    public void testDisplayInfo() {
        os.displayInfo();
        assertTrue(outContent.toString().trim().contains("Operating System: Windows, Version: 10"));
    }

    @Test
    public void testUpdateOS() {
        os.updateOS("11");
        assertTrue(outContent.toString().trim().contains("Operating System updated to version 11"));
    }

    @Test
    public void testRunDiagnostics() {
        os.runDiagnostics();
        assertTrue(outContent.toString().trim().contains("Running system diagnostics..."));
        assertTrue(outContent.toString().trim().contains("Diagnostics completed. No issues found."));
    }

    @Test
    public void testReInstallOperatingSystemWhenNotInstalled() {
        os.deleteOperatingSystem();
        os.reInstallOperatingSystem("Linux", "Ubuntu 22.04");
        assertFalse(outContent.toString().trim().contains("Install operation system for delete her"));
    }

    @Test
    public void testReInstallOperatingSystemWhenAlreadyInstalled() {
        os.reInstallOperatingSystem("Linux", "Ubuntu 22.04");
        assertTrue(outContent.toString().trim().contains("Delete  operating system Windows and install new"));
    }

    @Test
    public void testDeleteOperatingSystem() {
        os.deleteOperatingSystem();
        assertFalse(outContent.toString().contains("Windows"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }
}