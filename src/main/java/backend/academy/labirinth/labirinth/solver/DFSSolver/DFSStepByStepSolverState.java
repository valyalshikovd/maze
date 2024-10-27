package backend.academy.labirinth.labirinth.solver.DFSSolver;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.solver.StepByStepSolver;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import lombok.Getter;

@SuppressFBWarnings("SEO_SUBOPTIMAL_EXPRESSION_ORDER")
public class DFSStepByStepSolverState implements StepByStepSolver {


    private Maze maze;
    private final Deque<Coordinate> stack = new ArrayDeque<>();
    private final List<Coordinate> visitedCoords = new ArrayList<>();
    @Getter
    private final List<Coordinate> result = new ArrayList<>();
    private Coordinate current;
    private boolean flag = true;
    private final Deque<Step> steps = new ArrayDeque<>();
    private Step currStep;

    public DFSStepByStepSolverState(Maze maze) {
        this.maze = maze;
        current = maze.startCoordinate();
        stack.push(current);
        currStep = new Step(0);
    }

    public DFSStepByStepSolverState() {
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
        current = maze.startCoordinate();
        stack.push(current);
        currStep = new Step(0);
    }

    @Override
    public Maze getMaze() {
        return maze;
    }

    /**
     * этот метод вызывает SEO_SUBOPTIMAL_EXPRESSION_ORDER
     */
    public boolean hasNext() {
        return !current.equals(maze.endCoordinate()) && flag;
    }

    public List<Coordinate> next() {
        if (stack.isEmpty()) {
            return result;
        }
        current = stack.pop();
        List<Coordinate> neighbours = getNeighbours(current);
        visitedCoords.add(current);
        currStep.coord.add(current);

        if (neighbours.size() > 1) {
            currStep.numNeigh = neighbours.size();
            steps.push(currStep);
            currStep = new Step(0);
        }

        if (neighbours.isEmpty()) {
            steps.push(currStep);
            if (steps.peek().numNeigh == 0) {
                result.removeAll(steps.pop().coord);
                if (!steps.isEmpty()) {
                    steps.peek().numNeigh--;
                }
            }
            while (!steps.isEmpty() && steps.peek().numNeigh < 1) {
                if (steps.peek().numNeigh == 0) {
                    result.removeAll(steps.pop().coord);
                }
                if (!steps.isEmpty() && steps.peek().numNeigh > 0) {
                    steps.peek().numNeigh = steps.peek().numNeigh - 1;
                }
            }
        }

        stack.addAll(neighbours);
        if (!neighbours.isEmpty()) {
            result.add(current);
        }
        return result;
    }

    public List<Coordinate> solve() {
        while (hasNext()) {
            next();
        }
        return result;
    }

    public List<Coordinate> getNeighbours(Coordinate coord) {
        List<Coordinate> coords = new ArrayList<>();
        addToCords(coords, new Coordinate(coord.x(), coord.y() + 1));
        addToCords(coords, new Coordinate(coord.x(), coord.y() - 1));
        addToCords(coords, new Coordinate(coord.x() + 1, coord.y()));
        addToCords(coords, new Coordinate(coord.x() - 1, coord.y()));
        return coords;
    }

    private void addToCords(List<Coordinate> coordinates, Coordinate coord) {
        if (validateCoord(coord)) {
            if (maze.getCell(coord).type() == Cell.Type.OUTPUT) {
                flag = false;
            }
            coordinates.add(coord);
        }
    }

    private boolean validateCoord(Coordinate coordinate) {
        return
            maze.isValidCoordinate(coordinate)
                && (maze.getCell(coordinate).type() == Cell.Type.PASSAGE
                || maze.getCell(coordinate).type() == Cell.Type.OUTPUT
                || maze.getCell(coordinate).type() == Cell.Type.SWAMP
                || maze.getCell(coordinate).type() == Cell.Type.COIN
            )
                && !visitedCoords.contains(coordinate);
    }

}
