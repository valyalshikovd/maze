package backend.academy.labirinth.labirinth.DFSSolver;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.Solver;
import backend.academy.labirinth.labirinth.StepByStepSolver;

import java.util.List;

public class DFSSolver implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze) {
        DFSSolverState solver = new DFSSolverState(maze);
        while (solver.hasNext()){
            solver.next();
        }
        return solver.result();
    }

    @Override
    public StepByStepSolver getStepByStepSolver(Maze maze) {
        return new DFSSolverState(maze);
    }


}
