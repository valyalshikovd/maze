package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.exception.InvalidCoordinate;
import backend.academy.labirinth.exception.InvalidMaze;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import lombok.Getter;

@SuppressWarnings({"MultipleStringLiterals", "MOM_MISLEADING_OVERLOAD_MODEL"})
@SuppressFBWarnings("MOM_MISLEADING_OVERLOAD_MODEL")
public final class Maze {
    @Getter
    private final int height;
    @Getter
    private final int width;
    private final Cell[][] grid;
    @Getter
    private final Coordinate startCoordinate;
    @Getter
    private final Coordinate endCoordinate;

    public Maze(int height, int width, Coordinate startCoordinate, Coordinate endCoordinate) {
        this.height = height;
        this.width = width;
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        grid = new Cell[height][width];
    }

    public Maze(Cell[][] grid, Coordinate startCoordinate, Coordinate endCoordinate) {
        this.height = grid.length;
        this.width = getGridWidth(grid);
        this.grid = grid;
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
    }

    private int getGridWidth(Cell[][] grid) {

        int curr = grid[0].length;
        for (Cell[] row : grid) {
            if (row.length != curr) {
                throw new InvalidMaze("Not rectangle");
            }
        }
        return curr;
    }

    public void setCell(Coordinate coordinate, Cell cell) {
        if (!isValidCoordinate(coordinate)) {
            throw new InvalidCoordinate("invalid coordinate");
        }
        grid[coordinate.y()][coordinate.x()] = cell;
    }

    public Cell[][] getGrid() {
        Cell[][] res = new Cell[height][];
        for (int i = 0; i < height; i++) {
            res[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        return res;
    }

    public Cell getCell(Coordinate coordinate) {
        if (!isValidCoordinate(coordinate)) {
            throw new InvalidCoordinate("invalid coordinate");
        }
        return grid[coordinate.y()][coordinate.x()];
    }

    public Cell getCell(int x, int y) {
        if (!isValidCoordinate(new Coordinate(x, y))) {
            throw new InvalidCoordinate("invalid coordinate");
        }
        return grid[y][x];
    }

    public boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.y() > 0 && coordinate.y() < width && coordinate.x() > 0 && coordinate.x() < height;
    }

    public static boolean isValidCoordinate(Coordinate coordinate, int height, int width) {
        return coordinate.y() > -1 && coordinate.x() < width && coordinate.x() > -1 && coordinate.y()  < height;
    }
}

