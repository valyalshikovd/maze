package backend.academy.labirinth.labirinth.generator;

import backend.academy.labirinth.labirinth.Maze;

public interface StepByStepGenerator {
    boolean hasNext();

    void next();

    Maze getMaze();
}
