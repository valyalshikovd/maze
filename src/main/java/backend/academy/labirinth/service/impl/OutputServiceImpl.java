package backend.academy.labirinth.service.impl;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.service.mazeRenderer.Renderer;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.service.output.PrintWriteShell;
import com.google.inject.Inject;
import java.util.List;

public class OutputServiceImpl implements OutputService {

    private final Renderer renderer;

    @Inject
    public OutputServiceImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void drawMaze(Maze maze) {
        PrintWriteShell.println(renderer.render(maze));
    }

    @Override
    public void drawMaze(Maze maze, List<Coordinate> path) {
        PrintWriteShell.println(renderer.render(maze, path));
    }

    public void drawCode(Maze maze) {
        PrintWriteShell.println(renderer.getCodeMaze(maze.getGrid()));
    }
}
