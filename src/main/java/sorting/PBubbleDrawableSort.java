package sorting;

import processing.core.PApplet;

import java.awt.*;

public class PBubbleDrawableSort implements DrawableSort {

    private final PApplet processing;
    private final Rectangle drawableBounds;
    private int borderColor;
    private int highlight;
    private StepCapableSort sort;
    private boolean paused = false;

    public PBubbleDrawableSort(final PApplet processing, final java.util.List<Integer> items, final Rectangle drawableBounds) {
        this.processing = processing;
        this.drawableBounds = drawableBounds;

        initDefaultValues();
        sort = new StepCapableBubbleSort(items);
    }

    private void initDefaultValues() {
        this.borderColor = 0x000000;
        this.highlight = 0;
    }

    @Override
    public void drawNextStep() {
        processing.background(255);
        drawBorder();
        draw();
        nextStep();
    }

    private void drawBorder() {
        processing.stroke(this.borderColor);
        processing.fill(255);
        drawOffSettedRectangle(0, 0, drawableBounds.width, drawableBounds.height);
    }

    private void draw() {
        processing.stroke(0, 0, 255);

        for (int itemIndex = 0, itemsLength = sort.lastStep().size(); itemIndex < itemsLength; itemIndex++) {
            int xScale = drawableBounds.width / itemsLength;
            int yScale = drawableBounds.height / itemsLength;
            int width = drawableBounds.width / itemsLength;
            int item = sort.lastStep().get(itemIndex) * yScale;
            highlightRectangle(itemIndex);
            drawOffSettedRectangle(itemIndex * xScale, drawableBounds.height - item, width, item);
        }
//        float[] sample = new float[items.length];
//
//        for (int i = 0; i < sample.length; i++) {
//            sample[i] = PApplet.sin(processing.TWO_PI*i/items.length);
//        }

        // TODO valdemar: This playback is really poorly done. Research a better way.
        // Create the audiosample based on the data, set framerate to play 200 oscillations/second
//        AudioSample audioSample = new AudioSample(processing, sample, 200 * sample.length);

        // Play the sample in a loop (but don't make it too loud)
//        audioSample.amp(0.2f);
//        audioSample.play();
    }

    private void highlightRectangle(Integer index) {
        processing.fill(0, 255, 0);
        if (sort.highlights().contains(index))
            processing.fill(255, 0, 0);
    }

    private void drawOffSettedRectangle(int originX, int originY, int width, int height) {
        int x1Offset = drawableBounds.x + originX;
        int y1Offset = drawableBounds.y + originY;
        processing.rect(x1Offset, y1Offset, width, height);
    }

    private void nextStep() {
        if (!paused)
            sort.executeNextStep();
    }

    @Override
    public void drawPreviousStep() {

    }

    @Override
    public void pause() {
        this.paused = true;

    }

    @Override
    public void play() {
        this.paused = false;
    }
}
