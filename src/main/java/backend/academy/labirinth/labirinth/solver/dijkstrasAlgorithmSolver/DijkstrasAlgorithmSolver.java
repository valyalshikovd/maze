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

        dist[maze.startCoordinate().Y()][maze.startCoordinate().X()] = 0;
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
                    dist[currentCoordinate.Y()][currentCoordinate.X()]
                        + grid[neighbor.Y()][neighbor.X()].type().weight();

                if (newDist < dist[neighbor.Y()][neighbor.X()]) {
                    dist[neighbor.Y()][neighbor.X()] = newDist;
                    prev[neighbor.Y()][neighbor.X()] = currentCoordinate;
                    pq.add(new CellInfo(neighbor, newDist));
                }

            }
        }
        if (dist[maze.endCoordinate().Y() + 1][maze.endCoordinate().X() + 1] == Integer.MAX_VALUE) {
            return List.of();
        }
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = new Coordinate(maze.endCoordinate().X() + 1, maze.endCoordinate().Y() + 1);
        while (current != null) {
            path.add(current);
            current = prev[current.Y()][current.X()];
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
}
