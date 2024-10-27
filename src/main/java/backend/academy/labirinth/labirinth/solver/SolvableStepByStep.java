package backend.academy.labirinth.labirinth.solver;

import backend.academy.labirinth.labirinth.Maze;

public interface SolvableStepByStep extends Solver {

    StepByStepSolver getStepByStepSolver(Maze maze);

    StepByStepSolver getStepByStepSolver();
}
