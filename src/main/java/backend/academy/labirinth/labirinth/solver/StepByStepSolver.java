package backend.academy.labirinth.labirinth.solver;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import java.util.List;

public interface StepByStepSolver {

    boolean hasNext();

    List<Coordinate> next();

    void setMaze(Maze maze);

    Maze getMaze();

}
