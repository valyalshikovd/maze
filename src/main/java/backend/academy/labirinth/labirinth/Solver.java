package backend.academy.labirinth.labirinth;

import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze);

    StepByStepSolver getStepByStepSolver(Maze maze);
}
