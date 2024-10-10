package backend.academy.labirinth.service.mazeRenderer.impl;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.service.mazeRenderer.Renderer;
import java.util.Arrays;
import java.util.List;

public class RendererImpl implements Renderer {
    @Override
    public String render(Maze maze) {
        return getStringMaze(maze.getGrid());
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        Cell[][] cells = maze.getGrid();
        cells = injectPathInMaze(cells, path);
        return getStringMaze(cells);
    }

    private Cell[][] injectPathInMaze(Cell[][] src, List<Coordinate> path) {
        Cell[][] res = Arrays.copyOf(src, src.length);
        for(Coordinate c : path) {
            if(res[c.Y()][c.X()].type() == Cell.Type.INPUT){
                continue;
            }
            res[c.Y()][c.X()] = new Cell( Cell.Type.WAY);
        }
        return res;
    }
    private String getStringMaze(Cell[][] cells) {
        StringBuilder sb = new StringBuilder();
        for(Cell[] c : cells) {
            for(Cell cell : c) {
                sb.append(cell.type().value());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
