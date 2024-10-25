package backend.academy.labirinth.service;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Environment;
import backend.academy.labirinth.labirinth.Maze;
import org.apache.commons.math3.util.Pair;
import java.util.List;

public interface OutputService {
    void drawMaze(Maze maze);

    void drawMaze(Maze maze, List<Coordinate> path);

    void drawCode(Maze maze);

    void drawWelcoming();

    void drawDescription();

    void drawEnteringMaze(Maze maze);

    Environment drawElectingConfig();

    int getCountSteps();

    Pair<Integer, Integer> getMazeSize();

    void drawRawText(String text);

    boolean drawEnteringContinue();

    boolean drawEnteringRequestNewEnvironment();

    boolean drawEnteringRequestCoordinate();

    Coordinate drawEnteringCoordinate();

    void drawStepDescription();
}
