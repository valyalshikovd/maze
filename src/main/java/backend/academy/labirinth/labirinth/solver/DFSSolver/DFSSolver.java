package backend.academy.labirinth.labirinth.solver.DFSSolver;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.solver.SolvableStepByStep;
import backend.academy.labirinth.labirinth.solver.StepByStepSolver;

import java.util.List;

public class DFSSolver implements SolvableStepByStep {
    @Override
    public List<Coordinate> solve(Maze maze) {
        DFSStepByStepSolverState solver = new DFSStepByStepSolverState(maze);
        while (solver.hasNext()) {
            solver.next();
        }
        return solver.result();
    }

    @Override
    public StepByStepSolver getStepByStepSolver(Maze maze) {
        return new DFSStepByStepSolverState(maze);
    }

    @Override
    public StepByStepSolver getStepByStepSolver() {
        return new DFSStepByStepSolverState();
    }

    @Override public String toString() {
        return "DFS Solver (StepByStep)";
    }

}
