package sorting;

import java.util.List;

public interface SteppabledSort {
    void executeNextStep();

    List<Integer> highlights();

    List<Integer> lastStep();

    List<Integer> step(int count);
}
