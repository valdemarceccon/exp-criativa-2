package ui;

import processing.core.PApplet;
import processing.sound.SqrOsc;
import sorting.StepCapableBubbleSort;
import sorting.StepCapableHeapSort;
import sorting.StepCapableSort;

import java.awt.*;

import static processing.core.PApplet.map;

public class DrawSort {

    private final PApplet processing;
    private final Rectangle drawableBounds;
    private final SqrOsc sinOsc;
    private final StepCapableSort heapSort;
    private final StepCapableSort bubbleSort;
    private StepCapableSort selectedSort;
    private int borderColor;
    private boolean paused = true;
    private int stepDisplayed = 0;


    public DrawSort(final PApplet processing, final java.util.List<Integer> items, final Rectangle drawableBounds) {
        this.processing = processing;
        this.drawableBounds = drawableBounds;
        sinOsc = new SqrOsc(processing);
        sinOsc.freq(0);
        initDefaultValues();
        heapSort = new StepCapableHeapSort(items);
        bubbleSort = new StepCapableBubbleSort(items);

        selectedSort = bubbleSort;
    }

    public void selectHeapSort() {
        this.selectedSort = this.heapSort;
    }

    public void selectBubbleSort() {
        this.selectedSort = this.bubbleSort;
    }

    private void initDefaultValues() {
        this.borderColor = 0x000000;
    }

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

        for (int itemIndex = 0, itemsLength = selectedSort.lastStep().size(); itemIndex < itemsLength; itemIndex++) {
            int xScale = drawableBounds.width / itemsLength;
            int yScale = drawableBounds.height / itemsLength;
            int width = drawableBounds.width / itemsLength;
            int item = getStepValue(itemIndex) * yScale;
            highlightRectangle(itemIndex);
            drawOffSettedRectangle(itemIndex * xScale, drawableBounds.height - item, width, item);
        }

        playSound();
    }

    private Integer getStepValue(int itemIndex) {
        if (paused) return selectedSort.currentStep().get(itemIndex);
        return selectedSort.lastStep().get(itemIndex);
    }

    private void playSound() {
        if (!selectedSort.highlights().isEmpty()) {
            Integer indexToPlay = selectedSort.highlights().get(0);
            float mappedValue = map(indexToPlay, 1, 100, 100, 1000);
            this.sinOsc.freq(mappedValue);
        }
    }

    private void highlightRectangle(Integer index) {
        processing.fill(0, 255, 0);
        if (heapSort.highlights().contains(index))
            processing.fill(255, 0, 0);
    }

    private void drawOffSettedRectangle(int originX, int originY, int width, int height) {
        int x1Offset = drawableBounds.x + originX;
        int y1Offset = drawableBounds.y + originY;
        processing.rect(x1Offset, y1Offset, width, height);
    }

    private void nextStep() {
        if (!paused)
            selectedSort.executeNextStep();
    }

    public void drawPreviousStep() {

    }

    public void pause() {
        this.paused = true;
    }

    public void play() {
        this.paused = false;
    }

    public void mute() {
        this.sinOsc.stop();
    }

    public void unmute() {
        this.sinOsc.play();
    }

    public void stepDown() {
        pause();
        selectedSort.executePreviousStep();
    }

    public void stepUp() {
        pause();
        selectedSort.executeNextStep();
    }
}
