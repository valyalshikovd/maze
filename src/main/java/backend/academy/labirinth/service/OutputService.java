package backend.academy.labirinth.service;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Environment;
import backend.academy.labirinth.labirinth.Maze;
import java.util.List;
import org.apache.commons.math3.util.Pair;

public interface OutputService {

    void drawMaze(Maze maze);

    void drawMaze(Maze maze, List<Coordinate> path);

    void drawCode(Maze maze);

    void drawWelcoming();

    void drawDescription();

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
