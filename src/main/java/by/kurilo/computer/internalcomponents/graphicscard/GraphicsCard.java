package by.kurilo.computer.internalcomponents.graphicscard;

import by.kurilo.computer.interfaces.Displayable;

public class GraphicsCard implements Displayable {
    private String model;
    private int vram;
    private boolean isRendering;

    public GraphicsCard(String model, int vram) {
        this.model = model;
        this.vram = vram;
        this.isRendering = false;
    }

    public void renderGraphics() {
        isRendering = true;
        System.out.println("Rendering graphics with " + model + "...");
        isRendering = false;
        System.out.println("Rendering complete.");
    }

    public void updateDriver() {
        System.out.println("Updating graphics driver for " + model + "...");
    }

    @Override
    public void displayInfo() {
        System.out.println("Graphics Card: " + model + ", VRAM: " + vram + "GB");
    }
}
