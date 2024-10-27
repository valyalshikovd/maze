package backend.academy.labirinth.labirinth.generator.growingThreeGenerator;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.GeneratorWithNeighborManager;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.util.RandomShell;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;

/**
 * Класс реализующий алгоритм выращивания дерева.
 */
@SuppressFBWarnings("CLI_CONSTANT_LIST_INDEX")
public final class GrowingThreeMazeState extends GeneratorWithNeighborManager {

    private final CellFactory cellFactory;

    public GrowingThreeMazeState(int height, int width,
        Coordinate input, Coordinate output,
        RandomShell random, CellFactory cellFactory) {
        super(reductionToOdd(height), reductionToOdd(width), input, output, random, cellFactory);
        this.cellFactory = cellFactory;
    }

    private static int reductionToOdd(int val) {
        int newVal = val;
        if (val % 2 == 0) {
             newVal = val - 1;
        }
        return newVal;
    }

    public Maze generateMaze() {

        for (Cell[] cells : maze) {
            Arrays.fill(cells, cellFactory.getWall());
        }

        Coordinate currentCoord = input;
        activeCoords.add(currentCoord);
        while (!activeCoords.isEmpty()) {
            Coordinate tempCoord = null;
            while (currentCoord != null) {
                tempCoord = currentCoord;
                currentCoord = getRandomNeighbourCoordinate(currentCoord);
                if (currentCoord != null) {
                    maze[currentCoord.y()][currentCoord.x()] = cellFactory.getPassageCell();
                    activeCoords.add(currentCoord);
                }
            }
            if (output == null) {
                output = tempCoord;
            }
            activeCoords.remove(tempCoord);
            if (!activeCoords.isEmpty()) {
                currentCoord = activeCoords.get(random.get(activeCoords.size()));
            }
        }


        Cell[][] cells =  new Cell[ySize + 2][xSize + 2];

        for (int j = 0; j < xSize + 2; j++) {
            cells[0][j] = cellFactory.getWall();
        }
        for (int j = 0; j < xSize + 2; j++) {
            cells[ySize + 1][j] = cellFactory.getWall();
        }
        for (int j = 0; j < ySize + 2; j++) {
            cells[j][0] = cellFactory.getWall();
        }
        for (int j = 0; j < ySize + 2; j++) {
            cells[j][xSize + 1] = cellFactory.getWall();
        }
        for (int i = 1; i < ySize + 1; i++) {
            if (xSize + 1 - 1 >= 0) {
                System.arraycopy(maze[i - 1], 0, cells[i], 1, xSize);
            }
        }
        cells[input.y() + 1][input.x() + 1] = cellFactory.getInput();
        cells[output.y() + 1][output.x() + 1] = cellFactory.getOutput();
        return new Maze(cells,
            new Coordinate(input.x() + 1, input.y() + 1),
            new Coordinate(output.x() + 1, output.y() + 1));
    }

    private Coordinate getRandomNeighbourCoordinate(Coordinate coord) {
        NeighborManager neighborManager = new NeighborManager(coord);
        return neighborManager.brakeWall();
    }
}
