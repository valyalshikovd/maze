package backend.academy.labirinth.labirinth.generator;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.util.RandomShell;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public abstract class GeneratorWithNeighborManager {

    protected int ySize;
    protected int xSize;
    protected final Coordinate input;
    protected Coordinate output;
    protected final RandomShell random;
    protected List<Coordinate> activeCoords = new ArrayList<>();
    protected final Cell[][] maze;
    protected Maze actualMaze;

    protected GeneratorWithNeighborManager(int ySize,
        int xSize, Coordinate input, Coordinate output, RandomShell random) {
        this.ySize = ySize;
        this.xSize = xSize;
        this.input = input;
        this.output = output;
        this.random = random;
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
            Coordinate res = neighbors.get(random.get(neighbors.size()));

            if (res.y() > currentCoord.y()) {
                maze[currentCoord.y() + 1][currentCoord.x()] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            if (res.y() < currentCoord.y()) {
                maze[currentCoord.y() - 1][currentCoord.x()] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            if (res.x() > currentCoord.x()) {
                maze[currentCoord.y()][currentCoord.x()  +1] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            if (res.x() < currentCoord.x()) {
                maze[currentCoord.y()][currentCoord.x() - 1] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            neighbors.remove(res);
            return null;
        }
    }
}
