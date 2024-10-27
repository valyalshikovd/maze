package backend.academy.labirinth.labirinth.generator;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.util.RandomShell;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * класс, имеющий в своей струкруте логику разрушения стен к соседям клетки.
 * Подобная логика требуется в обоих реализованных алгоритмах генерации, поэтому выведена в отдельный класс.
 */
public abstract class GeneratorWithNeighborManager {

    protected int ySize;
    protected int xSize;
    protected final Coordinate input;
    protected Coordinate output;
    protected final RandomShell random;
    protected List<Coordinate> activeCoords = new ArrayList<>();
    protected final Cell[][] maze;
    protected Maze actualMaze;
    protected final CellFactory cellFactory;

    protected GeneratorWithNeighborManager(int ySize,
        int xSize, Coordinate input, Coordinate output, RandomShell random, CellFactory cellFactory
    ) {
        this.ySize = ySize;
        this.xSize = xSize;
        this.input = input;
        this.output = output;
        this.random = random;
        this.cellFactory = cellFactory;
        this.maze = new Cell[this.ySize][this.xSize];
    }

    private boolean validateCoordsToPoolNeighbourCoords(Coordinate coord) {
        return Maze.isValidCoordinate(coord, ySize, xSize)
            && !activeCoords.contains(coord) && maze[coord.y()][coord.x()].type() != Cell.Type.PASSAGE;
    }

    private Coordinate getRandomNeighbourCoordinate(Coordinate coord) {
        NeighborManager neighborManager = new NeighborManager(coord);
        return neighborManager.brakeWall();
    }

    /**
     * класс, реализующий логику взаимодествия с клетками соседями.
     */
    protected class NeighborManager {
        @Getter
        private final List<Coordinate> neighbors = new ArrayList<>();
        private final Coordinate currentCoord;

        public NeighborManager(Coordinate currentCoord) {
            this.currentCoord = currentCoord;
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.x() + 2, currentCoord.y()));
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.x(), currentCoord.y() + 2));
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.x() - 2, currentCoord.y()));
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.x(), currentCoord.y() - 2));

        }

        private void addCoordsToPoolActiveCoords(Coordinate coord) {
            if (validateCoordsToPoolNeighbourCoords(coord)) {
                neighbors.add(coord);
            }
        }

        public Coordinate brakeWall() {
            if (neighbors.isEmpty()) {
                return null;
            }
            Coordinate neighbor = neighbors.get(random.get(neighbors.size()));
            Coordinate res = null;

            if (neighbor.y() > currentCoord.y()) {
                maze[currentCoord.y() + 1][currentCoord.x()] = cellFactory.getPassageCell();
                res = neighbor;
            }
            if (neighbor.y() < currentCoord.y()) {
                maze[currentCoord.y() - 1][currentCoord.x()] = cellFactory.getPassageCell();
                res = neighbor;
            }
            if (neighbor.x() > currentCoord.x() && res == null) {
                maze[currentCoord.y()][currentCoord.x() + 1] = cellFactory.getPassageCell();
                res = neighbor;
            }
            if (neighbor.x() < currentCoord.x() && res == null) {
                maze[currentCoord.y()][currentCoord.x() - 1] = cellFactory.getPassageCell();
                res = neighbor;
            }
            if (res != null) {
                return res;
            }
            neighbors.remove(neighbor);
            return null;
        }
    }
}
