package backend.academy.labirinth.labirinth.generator;

import backend.academy.labirinth.labirinth.Coordinate;

public interface GeneratingStepByStep extends Generator {

    StepByStepGenerator getStepByStepGenerator(int height, int width);

    StepByStepGenerator getStepByStepGenerator(int height, int width, Coordinate input, Coordinate output);
}
