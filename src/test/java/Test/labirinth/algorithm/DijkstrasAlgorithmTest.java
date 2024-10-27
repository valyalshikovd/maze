package Test.labirinth.algorithm;

import Test.service.RendererTest;
import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.solver.DFSSolver.DFSSolver;
import backend.academy.labirinth.labirinth.solver.dijkstrasAlgorithmSolver.DijkstrasAlgorithmSolver;
import backend.academy.labirinth.service.mazeRenderer.impl.RendererImpl;
import backend.academy.labirinth.util.juice.ObjectFabric;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DijkstrasAlgorithmTest {

    @Test
    public void algTest() {
        Cell[][] cells = new Cell[][] {
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)
            },
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.INPUT), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL)},
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL)},
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.OUTPUT), new Cell(Cell.Type.WALL)},
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL)},
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
            {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)}};
        Maze maze = new Maze(cells, new Coordinate(1, 1), new Coordinate(5, 3));
//        System.out.println(ObjectFabric.getObject(RendererImpl.class).render(maze));
//        System.out.println(ObjectFabric.getObject(RendererImpl.class).render(maze, ObjectFabric.getObject(DFSSolver.class).solve(maze)));
//        System.out.println(ObjectFabric.getObject(RendererImpl.class).render(maze, ObjectFabric.getObject(DijkstrasAlgorithmSolver.class).solve(maze)));

            assertEquals(13, ObjectFabric.getObject(DijkstrasAlgorithmSolver.class).solve(maze).size());
            assertTrue(ObjectFabric.getObject(DFSSolver.class).solve(maze).size() < ObjectFabric.getObject(DijkstrasAlgorithmSolver.class).solve(maze).size());
    }
}
