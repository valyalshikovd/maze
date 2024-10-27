package backend.academy.labirinth.labirinth.generator.growingThreeGenerator;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

/**
 * Обертка для алгоритма генерации выращивания дерева.
 */
public class GrowingThreeMazeGenerator implements Generator {

    private final RandomShell random;
    private final CellFactory cellFactory;

    @Inject
    public GrowingThreeMazeGenerator(RandomShell random, CellFactory cellFactory) {
        this.random = random;
        this.cellFactory = cellFactory;
    }

    @Override
    public Maze generate(int height, int width) {
        Coordinate coordinate = getRandomInputCoordinate(height, width, random);
        return new GrowingThreeMazeState(height, width, coordinate, null, random, cellFactory).generateMaze();
    }

    @Override
    public Maze generate(int height, int width, Coordinate input, Coordinate output) {
        return new GrowingThreeMazeState(height, width, input, output, random, cellFactory).generateMaze();
    }

    @Override public String toString() {
        return "Growing Three Maze Generator (Step By Step)";
    }

}
