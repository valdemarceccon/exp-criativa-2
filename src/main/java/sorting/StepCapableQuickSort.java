package sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StepCapableQuickSort implements StepCapableSort {

    private int index = 0;
    private List<List<Integer>> steps;
    private List<Integer> hightlights;
    private int pivot;

    StepCapableQuickSort(List<Integer> items) {
        steps = new LinkedList<>();
        steps.add(shuffle(items));
        hightlights = new LinkedList<>();
        pivot = steps.size() - 1;
    }

    private List<Integer> shuffle(List<Integer> items) {
        List<Integer> result = new LinkedList<>(items);
        final Random random = new Random();

        for (int index = 0, length = result.size(); index < length; index++) {
            final int randomIndex = random.nextInt(length);
            result = swap(result, index, randomIndex);
        }

        return result;
    }

    @Override
    public void executeNextStep() {
    }

    private boolean isSorted() {
        List<Integer> lastStep = lastStep();
        for (int index = 0, lastItemIndex = lastStep.size() - 1; index < lastItemIndex; index++) {
            Integer integer = lastStep.get(index);
            Integer nextValue = lastStep.get(index + 1);
            if (integer > nextValue)
                return false;
        }
        return true;
    }

    private List<Integer> swap(List<Integer> sourceList, final int idxA, final int idxB) {
        List<Integer> nextStep = new LinkedList<>(sourceList);
        nextStep.set(idxA, sourceList.get(idxB));
        nextStep.set(idxB, sourceList.get(idxA));
        return nextStep;
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
    public List<Integer> step(int count) {
        return steps.get(count);
    }
}
