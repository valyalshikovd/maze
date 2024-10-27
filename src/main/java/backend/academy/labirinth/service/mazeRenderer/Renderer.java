package backend.academy.labirinth.service.mazeRenderer;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Coordinate> path);

    String getCodeMaze(Maze grid);
}
