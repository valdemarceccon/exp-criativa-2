package sorting;

import java.util.List;

public interface StepCapableSort {
    void executeNextStep();

    List<Integer> highlights();

    List<Integer> lastStep();

    List<Integer> step(int count);
}
