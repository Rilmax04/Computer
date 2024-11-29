package by.kurilo.computer.internalcomponents.operatingsystem;

import by.kurilo.computer.interfaces.Displayable;

public class OperatingSystem implements Displayable {

    private String  name;
    private boolean installOperatingSystem=false;
    private String version;

    public OperatingSystem(String name, String version) {
        setName(name);
        setVersion(version);
        this.installOperatingSystem=true;
    }

    public void updateOS(String newVersion) {
        setVersion(newVersion);
        System.out.println("Operating System updated to version " + newVersion);
    }

    public void runDiagnostics() {
        System.out.println("Running system diagnostics...");
        System.out.println("Diagnostics completed. No issues found.");
    }

    public void displayInfo() {
        System.out.println("Operating System: " + name + ", Version: " + version);
    }

    public void reInstallOperatingSystem(String newName,String newVersion)
    {
        if (!installOperatingSystem)
        {
            setName(newName);
            setVersion(newVersion);
            installOperatingSystem=true;
        }
        else System.out.println("Delete  operating system "+name+" and install new");
    }

    private void setName(String name) {
        this.name=name;
    }
    private void setVersion(String version) {
        this.version=version;
    }

    public void deleteOperatingSystem()
    {
        if (installOperatingSystem)
        {
        this.installOperatingSystem=false;
        this.name="";
        this.version="";
        }
        else System.out.println("Install operation system for delete her");
    }


}
