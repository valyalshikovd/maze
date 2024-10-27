package backend.academy.labirinth.labirinth.generator.RecursiveBacktrackerGenerator;


import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.GeneratorWithNeighborManager;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.util.RandomShell;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

@SuppressFBWarnings("CLI_CONSTANT_LIST_INDEX")
public class RecursiveBacktrackerGeneratorState extends GeneratorWithNeighborManager implements StepByStepGenerator {

    private Coordinate currentCoord;
    private final Deque<Iteration> iterations = new ArrayDeque<>();
    private final CellFactory cellFactory;

    private static int reductionToOdd(int val) {
        int newVal = val;
        if (val % 2 == 0) {
            newVal = val - 1;
        }
        return newVal;
    }

    public RecursiveBacktrackerGeneratorState(
        int xSIZE,
        int ySIZE,
        Coordinate inputCoord,
        Coordinate outputCoord,
        RandomShell random,
        CellFactory cellFactory
    ) {
        super(
            reductionToOdd(ySIZE),
            reductionToOdd(xSIZE),
            new Coordinate(inputCoord.x(), inputCoord.y()),
            outputCoord,
            random,
            cellFactory
        );
        currentCoord = new Coordinate(inputCoord.x(), inputCoord.y());
        this.cellFactory = cellFactory;
        for (Cell[] cells : maze) {
            Arrays.fill(cells, cellFactory.getWall());
        }
        maze[inputCoord.y()][inputCoord.x()] = cellFactory.getInput();
    }

    public boolean hasNext() {
        return currentCoord != null;
    }

    public void next() {

        List<Coordinate> neighbors = getNeighbors(currentCoord);

        if (neighbors.isEmpty() && output == null) {
            output = currentCoord;
        }

        Coordinate coordinate = null;

        if (!neighbors.isEmpty()) {
            coordinate = neighbors.get(random.get(neighbors.size()));
        }

        if (coordinate != null) {
            neighbors.remove(coordinate);
            breakWalls(currentCoord, coordinate);

            for (Coordinate neighbor : neighbors) {
                iterations.add(new Iteration(currentCoord, neighbor));
            }
            currentCoord = coordinate;
        }
        if (coordinate == null &&  !iterations.isEmpty()) {

            Iteration iter = iterations.pop();
            while (!validateCoordsToPoolNeighbourCoords(iter.nextCoord)) {
                if (iterations.isEmpty()) {
                    currentCoord = null;
                    return;
                }
                iter = iterations.pop();
            }
                breakWalls(iter.currentCoord, iter.nextCoord);
                currentCoord = iter.nextCoord;

        }
        if (currentCoord != null && validateCoordsToPoolNeighbourCoords(currentCoord)) {
            activeCoords.add(currentCoord);
            maze[currentCoord.y()][currentCoord.x()] = cellFactory.getPassageCell();
        }

        Cell[][] cells = createNewCells();

        if (output != null) {
            cells[output.y() + 1][output.x() + 1] = new Cell(Cell.Type.OUTPUT);
        }

        if (output == null) {
            actualMaze = new Maze(cells,
                new Coordinate(input.x() + 1, input.y() + 1), null);
        } else {
            actualMaze = new Maze(cells,
                new Coordinate(input.x() + 1, input.y() + 1),
                new Coordinate(output.x() + 1, output.y() + 1));
        }
    }

    private Cell[][] createNewCells() {
        Cell[][] cells = new Cell[this.ySize + 2][this.xSize + 2];

        final int FIRST_CELL = 0;

        for (int j = 0; j < xSize + 2; j++) {
            cells[FIRST_CELL][j] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < xSize + 2; j++) {
            cells[ySize + 1][j] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < ySize + 2; j++) {
            cells[j][FIRST_CELL] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < ySize + 2; j++) {
            cells[j][xSize + 1] = new Cell(Cell.Type.WALL);
        }
        for (int i = 1; i < ySize + 1; i++) {
            if (xSize + 1 - 1 >= 0) {
                System.arraycopy(maze[i - 1], 0, cells[i], 1, xSize);
            }
        }
        return cells;
    }

    private void breakWalls(Coordinate source, Coordinate target) {
        if (target.y() > source.y()) {
            maze[source.y() + 1][source.x()] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x(), source.y() + 1));
        }
        if (target.y() < source.y()) {
            maze[source.y() - 1][source.x()] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x(), source.y() - 1));
        }
        if (target.x() > source.x()) {
            maze[source.y()][source.x()  + 1] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x() + 1, source.y() + 1));
        }
        if (target.x() < source.x()) {
            maze[source.y()][source.x() - 1] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x() - 1, source.y()));
        }
    }

    private List<Coordinate> getNeighbors(Coordinate coordinate) {
        List<Coordinate> neighbors = new ArrayList<>();
        Coordinate coord = new Coordinate(coordinate.x(), coordinate.y() + 2);
        if (validateCoordsToPoolNeighbourCoords(coord)) {
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.x(), coordinate.y() - 2);
        if (validateCoordsToPoolNeighbourCoords(coord)) {
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.x() + 2, coordinate.y());
        if (validateCoordsToPoolNeighbourCoords(coord)) {
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.x() - 2, coordinate.y());
        if (validateCoordsToPoolNeighbourCoords(coord)) {
            neighbors.add(coord);
        }
        return neighbors;
    }

    private boolean validateCoordsToPoolNeighbourCoords(Coordinate coord) {
        return
            Maze.isValidCoordinate(coord, ySize, xSize)
                && !activeCoords.contains(coord) && maze[coord.y()][coord.x()].type() != Cell.Type.PASSAGE
                && maze[coord.y()][coord.x()].type() != Cell.Type.INPUT
                && maze[coord.y()][coord.x()].type() != Cell.Type.COIN
                && maze[coord.y()][coord.x()].type() != Cell.Type.SWAMP;
    }

    @Override
    public Maze getMaze() {
        return actualMaze;
    }

    private static class Iteration {
        Coordinate currentCoord;
        Coordinate nextCoord;

        Iteration(Coordinate currentCoord, Coordinate nextCoord) {
            this.currentCoord = currentCoord;
            this.nextCoord = nextCoord;
        }
    }
}
