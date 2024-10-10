package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.exception.InvalidCoordinate;
import backend.academy.labirinth.exception.InvalidMaze;
import lombok.Getter;
import java.util.Arrays;

public final class Maze {
    private final int height;
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
        if(!isValidCoordinate(coordinate)) {
            throw new InvalidCoordinate("invalid coordinate");
        }
        grid[coordinate.Y()][coordinate.X()] = cell;
    }

    public Cell[][] getGrid() {
        Cell[][] res = new Cell[height][];
        for(int i = 0; i < height; i++){
            res[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        return res;
    }

    public Cell getCell(Coordinate coordinate) {
        if(!isValidCoordinate(coordinate)) {
            throw new InvalidCoordinate("invalid coordinate");
        }
        return grid[coordinate.Y()][coordinate.X()];
    }

    public Cell getCell(int x, int y) {
        if(!isValidCoordinate(new Coordinate(x, y))) {
            throw new InvalidCoordinate("invalid coordinate");
        }
        return grid[y][x];
    }

    public boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.Y() > 0 && coordinate.Y() < width && coordinate.X() > 0 && coordinate.X() < height;
    }

    public Coordinate getValidCoordinate(Coordinate coordinate) {
        return getValidCoordinate(coordinate, height, width);
    }
    public static Coordinate getValidCoordinate(Coordinate coordinate, int height, int width) {
        if(isValidCoordinate(coordinate, height, width)) {
            return coordinate;
        }
        return null;
    }
    public static boolean isValidCoordinate(Coordinate coordinate, int height, int width) {
        return coordinate.Y() > -1 && coordinate.X() < width && coordinate.X() > -1 && coordinate.Y()  < height;
    }
}

