package ui;

import processing.core.PApplet;

import java.awt.*;

public abstract class Button {
    private static boolean mouseReleased;
    protected final PApplet processing;
    protected final Rectangle buttonSize;
    protected Runnable onClick;

    public Button(final PApplet processing, final Rectangle buttonSize) {
        this.processing = processing;
        this.buttonSize = buttonSize;
        this.onClick = () -> {
        };
    }

    public abstract void draw();

    public static void mouseReleased() {
        Button.mouseReleased = true;
    }

    private boolean isMouseOver() {
        int x1 = buttonSize.x;
        int y1 = buttonSize.y;
        int x2 = x1 + buttonSize.width;
        int y2 = y1 + buttonSize.height;
        return isBetween(x1, processing.mouseX, x2) && isBetween(y1, processing.mouseY, y2);
    }

    protected void executeEventIfOnBounds() {
        if (isMouseOver() && Button.mouseReleased) {
            onClick.run();
            Button.mouseReleased = false;
        }
    }

    private boolean isBetween(int val1, int val2, int val3) {
        return val2 >= val1 && val2 <= val3;
    }
}
