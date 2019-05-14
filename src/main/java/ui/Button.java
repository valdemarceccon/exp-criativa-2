package ui;

import main.EventBus;
import main.MouseEventListener;
import processing.core.PApplet;
import processing.event.MouseEvent;

import java.awt.*;

public abstract class Button implements MouseEventListener {
    protected final PApplet processing;
    protected final Rectangle buttonSize;
    protected Runnable onClick;

    public Button(final PApplet processing, final Rectangle buttonSize) {
        this.processing = processing;
        this.buttonSize = buttonSize;
        EventBus.getInstance().subscribe(this);
    }

    public abstract void draw();

    private boolean isMouseOver(MouseEvent event) {
        int x1 = buttonSize.x;
        int y1 = buttonSize.y;
        int x2 = x1 + buttonSize.width;
        int y2 = y1 + buttonSize.height;
        return isBetween(x1, event.getX(), x2) && isBetween(y1, event.getY(), y2);
    }

    private boolean isBetween(int val1, int val2, int val3) {
        return val2 >= val1 && val2 <= val3;
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (isMouseOver(event)) {
            onClick.run();
        }
    }

    public void setOnClick(Runnable onClick) {
        this.onClick = onClick;
    }
}
