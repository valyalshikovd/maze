package backend.academy.labirinth.labirinth;

import java.util.List;

public interface StepByStepGenerator {
    boolean hasNext();

    void next();

    Maze getMaze();
}
