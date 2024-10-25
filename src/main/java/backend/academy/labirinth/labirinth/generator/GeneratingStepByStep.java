package backend.academy.labirinth.labirinth.generator;

public interface GeneratingStepByStep extends Generator {

    StepByStepGenerator getStepByStepGenerator(int height, int width);
}
