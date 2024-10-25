package backend.academy.labirinth.labirinth.generator.growingThreeGenerator;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.generator.GeneratingStepByStep;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

public class GrowingThreeMazeGenerator implements Generator{

    private final RandomShell random;

    @Inject
    public GrowingThreeMazeGenerator(RandomShell random) {
        this.random = random;
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
        return new GrowingThreeMazeState(height, width, coordinate, null, random).generateMaze();
    }

    @Override
    public Maze generate(int height, int width, Coordinate input, Coordinate output) {
        return new GrowingThreeMazeState(height, width, input, output, random).generateMaze();
    }

    @Override public String toString() {
        return "Growing Three Maze Generator (Step By Step)";
    }

}
