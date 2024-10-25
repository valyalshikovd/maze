package backend.academy.labirinth.labirinth.solver.dijkstrasAlgorithmSolver;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.Shift;
import backend.academy.labirinth.labirinth.solver.Solver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithmSolver implements Solver {

    private record CellInfo(Coordinate coordinate, int distance) {
    }
    @Override
    public List<Coordinate> solve(Maze maze) {

        int height = maze.height();
        int width = maze.width();
        Cell[][] grid = maze.getGrid();

        int[][] dist = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Coordinate[][] prev = new Coordinate[height][width];

        PriorityQueue<CellInfo> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        dist[maze.startCoordinate().y()][maze.startCoordinate().x()] = 0;
        pq.add(new CellInfo(maze.startCoordinate(), 0));

        while (!pq.isEmpty()) {
            CellInfo current = pq.poll();
            Coordinate currentCoordinate = current.coordinate;

            if (currentCoordinate.equals(maze.endCoordinate())) {
                break;
            }

            for (Shift direction : Shift.DIRECTION) {

                Coordinate neighbor = direction.getShiftedCoordinate(currentCoordinate);

                if (!validateCoord(neighbor, maze)) {
                    continue;
                }

                int newDist =
                    dist[currentCoordinate.y()][currentCoordinate.x()]
                        + grid[neighbor.y()][neighbor.x()].type().weight();

                if (newDist < dist[neighbor.y()][neighbor.x()]) {
                    dist[neighbor.y()][neighbor.x()] = newDist;
                    prev[neighbor.y()][neighbor.x()] = currentCoordinate;
                    pq.add(new CellInfo(neighbor, newDist));
                }
            }
        }
        if (dist[maze.endCoordinate().y()][maze.endCoordinate().x()] == Integer.MAX_VALUE) {
            return List.of();
        }
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = new Coordinate(maze.endCoordinate().x(), maze.endCoordinate().y());
        while (current != null) {
            path.add(current);
            current = prev[current.y()][current.x()];
        }
        Collections.reverse(path);
        return path;

    }

    private boolean validateCoord(Coordinate coordinate, Maze maze) {
        return
            maze.isValidCoordinate(coordinate)
                && (maze.getCell(coordinate).type() == Cell.Type.PASSAGE
                || maze.getCell(coordinate).type() == Cell.Type.OUTPUT
                || maze.getCell(coordinate).type() == Cell.Type.SWAMP
                || maze.getCell(coordinate).type() == Cell.Type.COIN
            );
    }

    @Override public String toString() {
        return "DijkstrasAlgorithmSolver";
    }
}
