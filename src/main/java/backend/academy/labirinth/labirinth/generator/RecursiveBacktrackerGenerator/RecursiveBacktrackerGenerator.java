package backend.academy.labirinth.labirinth.generator.RecursiveBacktrackerGenerator;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.GeneratingStepByStep;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

public class RecursiveBacktrackerGenerator implements GeneratingStepByStep {

    private final RandomShell random;
    private final CellFactory cellFactory;

    @Inject
    public RecursiveBacktrackerGenerator(RandomShell random, CellFactory cellFactory) {
        this.random = random;
        this.cellFactory = cellFactory;
    }

    @Override
    public Maze generate(int height, int width) {
        Coordinate coordinate = getRandomInputCoordinate(height, width, random);
        RecursiveBacktrackerGeneratorState r =
            new RecursiveBacktrackerGeneratorState(width, height, coordinate, null, random, cellFactory);
        while (r.hasNext()) {
            r.next();
        }
        return r.getMaze();
    }

    @Override
    public Maze generate(int height, int width, Coordinate input, Coordinate output) {
        RecursiveBacktrackerGeneratorState r =
            new RecursiveBacktrackerGeneratorState(width, height, input, output, random, cellFactory);
        while (r.hasNext()) {
            r.next();
        }
        return r.getMaze();
    }

    @Override
    public StepByStepGenerator getStepByStepGenerator(int height, int width) {
        Coordinate coordinate = getRandomInputCoordinate(height, width, random);
        return new RecursiveBacktrackerGeneratorState(width, height, coordinate, null, random, cellFactory);
    }

    @Override
    public StepByStepGenerator getStepByStepGenerator(int height, int width, Coordinate input, Coordinate output) {
        return new RecursiveBacktrackerGeneratorState(width, height, input, output, random, cellFactory);
    }

    @Override public String toString() {
        return "Recursive Backtracker Generator (Step By Step)";
    }
}
