
import java.util.LinkedList;
import java.util.List;

import static sorting.SortUtils.isSorted;
import static sorting.SortUtils.swap;

public class StepCapableBubbleSort implements StepCapableSort {

    private int index = 0;
    private List<List<Integer>> steps;
    private int upperLimit;
    private List<Integer> hightlights;
    private int stepPosition;

    StepCapableBubbleSort(List<Integer> items) {
        steps = new LinkedList<>();
        steps.add(items);
        upperLimit = lastStep().size();
        hightlights = new LinkedList<>();
        stepPosition = 0;
    }


    @Override
    public void executeNextStep() {
        hightlights.clear();
        if (stepPosition > steps.size() - 2) {
            calculeNextStep();
        } else {
            incrementStep();
        }
    }

    private void incrementStep() {
        if (stepPosition < steps.size() - 1) {
            stepPosition++;
        }
    }

    private void calculeNextStep() {
        if (!isSorted(lastStep())) {
            int item = lastStep().get(index);
            int proxItem = lastStep().get(index + 1);
            if (item > proxItem) {
                steps.add(swap(lastStep(), index + 1, index));
                setHighlights(index, index + 1);
            }

            incrementIndex();
        }
    }


    private void setHighlights(int item, int proxItem) {
        hightlights.clear();
        hightlights.add(item);
        hightlights.add(proxItem);
    }

    private void incrementIndex() {
        if (index > upperLimit - 3) {
            index = 0;
        } else {
            index++;
        }
    }


    @Override
    public List<Integer> currentStep() {
        return step(stepPosition);
    }

    @Override
    public List<Integer> highlights() {
        return hightlights;
    }

    @Override
    public List<Integer> lastStep() {
        return steps.get(steps.size() - 1);
    }

    @Override
    public List<Integer> step(int at) {
        return steps.get(at);
    }

    @Override
    public void executePreviousStep() {
        if (stepPosition > 0) {
            stepPosition--;
        }
    }
}
