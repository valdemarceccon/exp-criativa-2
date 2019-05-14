package sorting;

import java.util.List;

public interface StepCapableSort {
    void executeNextStep();
    void executePreviousStep();

    List<Integer> highlights();

    List<Integer> lastStep();

    List<Integer> currentStep();

    List<Integer> step(int count);

    int loopCount();

    int swapCount();
}
