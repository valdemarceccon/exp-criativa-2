package main;

import processing.core.PApplet;
import processing.core.PShape;
import sorting.DrawableSort;
import sorting.PBubbleDrawableSort;
import ui.Control;

import java.awt.Rectangle;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainPApplet extends PApplet {

    private DrawableSort bubbleSort;
    private PShape playButtonShape;
    private Map<Control, PShape> controles;

    @Override
    public void settings() {
        size(1500, 900);
    }

    @Override
    public void setup() {
        final int sortAreaWidth = 1000;
        final int sortAreaX = this.width - sortAreaWidth;
        final int sortAreaHeight = 800;
        final int sortAreaY = this.height - sortAreaHeight;
        final Rectangle sortArea = new Rectangle(sortAreaX, sortAreaY, sortAreaWidth, sortAreaHeight);
        List<Integer> items = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        bubbleSort = new PBubbleDrawableSort(this, items, sortArea);

        loadControl();

        frameRate(100);
    }

    private void loadControl() {
        controles = new HashMap<>();
        for (Control control : Control.values()) {
            controles.put(control, loadShape(control.getPath()));
        }
    }

    @Override
    public void draw() {
        bubbleSort.drawNextStep();
        drawControl();
    }

    private void drawControl() {

        final int w = 50;
        final int h = 50;
        final int spacing = 10;
        final int originX = 10;
        final int originY = 10;

        final List<PShape> shapesControls = new ArrayList<>(controles.values());
        for (int index = 0, size = shapesControls.size(); index < size; index++) {
            final PShape pShape = shapesControls.get(index);

            final int xOffset = index*w + (index == 0 ? 0 : spacing);
            final int yOffset = 0;

            shape(pShape, originX + xOffset, originY + yOffset, w, h);
        }

    }
}
