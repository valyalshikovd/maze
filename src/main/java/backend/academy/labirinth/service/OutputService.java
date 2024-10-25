package backend.academy.labirinth.service;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import java.util.List;

public interface OutputService {
    void drawMaze(Maze maze);
    void drawMaze(Maze maze, List<Coordinate> path);
    public void drawCode(Maze maze);
    public void drawWelcoming();
    public void drawDescription();
    public void drawEnteringMaze(Maze maze);
    public void drawElectingConfig();
}
