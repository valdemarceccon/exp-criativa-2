
import processing.core.PApplet;
import processing.core.PShape;
import processing.event.MouseEvent;

import java.awt.*;

public class ToggleButton implements MouseEventListener {
    private IconButton button1;
    private IconButton button2;
    private IconButton current;

    public ToggleButton(PApplet processing, Rectangle area) {
        this.button1 = new IconButton(processing, area);
        this.button2 = new IconButton(processing, area);
        this.current = button1;
        EventBus.getInstance().unsubscribe(button1, button2);
        EventBus.getInstance().subscribe(this);
    }

    public void setButton1(PShape shape,final Runnable run) {
        button1.setButtonShape(shape);
        button1.setOnClick(new Runnable() {
          public void run() {
            if (ToggleButton.this.current == button1)
                onClick(run);
        }
        });
    }

    private void toggle() {
        current = current == button1 ? button2 : button1;
    }

    public void setButton2(PShape shape, Runnable run) {
        button2.setButtonShape(shape);
        button2.setOnClick(() -> {
            if (this.current == button2)
                onClick(run);
        });
    }

    private void onClick(Runnable run) {
        toggle();
        run.run();
    }

    public void draw() {
        current.draw();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        current.mouseReleased(event);
    }
}
