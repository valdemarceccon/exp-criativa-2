package sorting;

import java.util.LinkedList;
import java.util.List;

import static sorting.SortUtils.isSorted;
import static sorting.SortUtils.swap;

public class StepCapableHeapSort implements StepCapableSort {

    private int index;
    private List<List<Integer>> steps;
    private int upperLimit;
    private List<Integer> hightlights;
    private int stepPosition;
    private boolean heapDone = false;

    StepCapableHeapSort(List<Integer> items) {
        steps = new LinkedList<>();
        steps.add(items);
        upperLimit = lastStep().size();
        hightlights = new LinkedList<>();
        stepPosition = 0;
        index = items.size() / 2 - 1;
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
            steps.add(sort(lastStep()));

            incrementIndex();
        }
    }

    private List<Integer> sort(List<Integer> list) {
        List<Integer> retorno = new LinkedList<>(list);
        int n = list.size();

        if (index >= 0 && !heapDone) {
            retorno = heapify(retorno, n, index);
        } else {
            retorno = swap(retorno, 0, index);
            retorno = heapify(retorno, index, 0);
        }

        hightlights.clear();
        hightlights.add(index);

        return retorno;
    }

    private List<Integer> heapify(List<Integer> list, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        List<Integer> retorno = new LinkedList<>(list);

        if (l < n && retorno.get(l) > retorno.get(largest))
            largest = l;

        if (r < n && retorno.get(r) > retorno.get(largest))
            largest = r;

        if (largest != i) {
            int swap = retorno.get(i);
            retorno.set(i, retorno.get(largest));
            retorno.set(largest, swap);

            swap(retorno, i, largest);

            retorno = heapify(retorno, n, largest);
        }

        return retorno;
    }

    private void setHighlights(int item, int proxItem) {
        hightlights.clear();
        hightlights.add(item);
        hightlights.add(proxItem);
    }

    private void incrementIndex() {
        index--;

        if (index < 0 && !isSorted(lastStep())) {
            index = lastStep().size() - 1;
            heapDone = true;
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
