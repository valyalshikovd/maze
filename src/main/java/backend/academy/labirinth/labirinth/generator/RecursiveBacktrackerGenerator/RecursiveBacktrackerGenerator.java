package backend.academy.labirinth.labirinth.generator.RecursiveBacktrackerGenerator;

import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

public class RecursiveBacktrackerGenerator implements Generator {

    private final RandomShell random;
    private final CellFactory cellFactory;

    @Inject
    public RecursiveBacktrackerGenerator(RandomShell random, CellFactory cellFactory) {
        this.random = random;
        this.cellFactory = cellFactory;
    }

    @Override
    public Maze generate(int height, int width) {
        int side = random.get(4);
        Coordinate coordinate = switch (side) {
            case 0 -> new Coordinate(random.get(width - 3), 0);
            case 1 -> new Coordinate(width - 3, random.get(height - 3));
            case 2 -> new Coordinate(random.get(width - 3), height - 3);
            case 3 -> new Coordinate(0, random.get(height - 3));
            default -> null;
        };
        return null;
    }

    @Override
    public StepByStepGenerator getStepByStepGenerator(int height, int width) {
        int side = random.get(4);
        Coordinate coordinate = switch (side) {
            case 0 -> new Coordinate(random.get(width - 3), 0);
            case 1 -> new Coordinate(width - 3, random.get(height - 3));
            case 2 -> new Coordinate(random.get(width - 3), height - 3);
            case 3 -> new Coordinate(0, random.get(height - 3));
            default -> null;
        };
        return new RecursiveBacktrackerGeneratorState(width, height, coordinate, null, random, cellFactory);
    }

}
