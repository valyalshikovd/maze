package backend.academy.labirinth.labirinth.solver;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;

import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze);

}
