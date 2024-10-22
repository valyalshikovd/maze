package backend.academy.labirinth.labirinth.solver;

import backend.academy.labirinth.labirinth.Coordinate;
import java.util.List;

public interface StepByStepSolver {

    boolean hasNext();
    List<Coordinate> next();

}
