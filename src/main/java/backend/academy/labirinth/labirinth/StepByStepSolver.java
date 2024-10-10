package backend.academy.labirinth.labirinth;

import java.util.List;

public interface StepByStepSolver {

    boolean hasNext();

    List<Coordinate> next();

}
