package backend.academy.labirinth.service.mazeRenderer.impl;

import backend.academy.labirinth.labirinth.CellType;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.service.mazeRenderer.Renderer;
import java.util.Arrays;
import java.util.List;


/**
 * предоставляет методы, для визуализации Maze
 */
public class RendererImpl implements Renderer {

    @Override
    public String render(Maze maze) {
        return getStringMaze(maze.getGrid());
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        CellType[][] cells = maze.getGrid();
        cells = injectPathInMaze(cells, path);
        return getStringMaze(cells);
    }

    private CellType[][] injectPathInMaze(CellType[][] src, List<Coordinate> path) {
        CellType[][] res = Arrays.copyOf(src, src.length);
        for (Coordinate c : path) {
            if (res[c.y()][c.x()] == CellType.INPUT) {
                continue;
            }
            res[c.y()][c.x()] = CellType.WAY;
        }
        return res;
    }

    private String getStringMaze(CellType[][] cells) {
        StringBuilder sb = new StringBuilder();
        for (CellType[] c : cells) {
            for (CellType cell : c) {
                    sb.append(cell.value());
            }
            sb.append('\n');
        }
        return sb.toString();
    }


    /**
     * метод, генерирующий код, создающий такую же сетку ячеек как в Maze переданном в параметр
     */
    public String getCodeMaze(Maze maze) {
        StringBuilder sb = new StringBuilder();
        sb.append("new CellType[][]{");
        for (CellType[] c : maze.getGrid()) {
            sb.append("new CellType[]{");
            for (CellType cell : c) {
                sb.append("(CellType.").append(cell).append("),");
            }
            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append('}');
        return sb.toString();
    }
}
