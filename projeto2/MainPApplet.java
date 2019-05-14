
import processing.core.PApplet;
import processing.event.MouseEvent;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainPApplet extends PApplet {

    private DrawSort sortPanel;
    private ControlPanel controlPanel;


    @Override
    public void settings() {
        size(1500, 900);
    }

    @Override
    public void setup() {
        final int sortAreaWidth = 1000;
        final int sortAreaHeight = 800;

        final int sortAreaX = this.width - sortAreaWidth;
        final int sortAreaY = this.height - sortAreaHeight;

        final Rectangle sortArea = new Rectangle(sortAreaX, sortAreaY, sortAreaWidth, sortAreaHeight);
        List<Integer> items = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        LinkedList<Integer> shuffledItems = new LinkedList<>(items);
        Collections.shuffle(shuffledItems);
        sortPanel = new DrawSort(this, shuffledItems, sortArea);
        controlPanel = new ControlPanel(this, sortPanel);

        frameRate(100);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        EventBus.getInstance().mouseReleased(event);
    }

    @Override
    public void draw() {
        background(0xFFFFFF00);
        sortPanel.drawNextStep();
        controlPanel.draw();
    }
}
