package Test.labirinth.algorithm;


import backend.academy.labirinth.labirinth.CellType;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.solver.DFSSolver.DFSSolver;
import backend.academy.labirinth.labirinth.solver.dijkstrasAlgorithmSolver.DijkstrasAlgorithmSolver;
import backend.academy.labirinth.util.juice.ObjectFabric;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DijkstrasAlgorithmTest {

    @Test
    public void algTest() {
        CellType[][] cells = new CellType[][] {
            {(CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL)
            },
            {(CellType.WALL), (CellType.INPUT), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.WALL)},
            {(CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL)},
            {(CellType.WALL), (CellType.COIN), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.OUTPUT), (CellType.WALL)},
            {(CellType.WALL), (CellType.COIN), (CellType.COIN), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.PASSAGE), (CellType.WALL)},
            {(CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL)},
            {(CellType.WALL), (CellType.COIN), (CellType.COIN), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL)},
            {(CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL)}};
        Maze maze = new Maze(cells, new Coordinate(1, 1), new Coordinate(5, 3));
//        System.out.println(ObjectFabric.getObject(RendererImpl.class).render(maze));
//        System.out.println(ObjectFabric.getObject(RendererImpl.class).render(maze, ObjectFabric.getObject(DFSSolver.class).solve(maze)));
//        System.out.println(ObjectFabric.getObject(RendererImpl.class).render(maze, ObjectFabric.getObject(DijkstrasAlgorithmSolver.class).solve(maze)));

            assertEquals(13, ObjectFabric.getObject(DijkstrasAlgorithmSolver.class).solve(maze).size());
            assertTrue(ObjectFabric.getObject(DFSSolver.class).solve(maze).size() < ObjectFabric.getObject(DijkstrasAlgorithmSolver.class).solve(maze).size());
    }
}
