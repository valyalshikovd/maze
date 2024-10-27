package Test.labirinth.algorithm;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.solver.DFSSolver.DFSSolver;
import backend.academy.labirinth.service.mazeRenderer.impl.RendererImpl;
import backend.academy.labirinth.util.juice.ObjectFabric;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFSTest {

    Cell[][] cells = new Cell[][] {
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.INPUT), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.OUTPUT),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
            new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
            new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),},
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL),}};

    @Test
    public void testDFSSolver(){
        Maze maze = new Maze(cells, new Coordinate(18, 1), new Coordinate(26, 27));
        assertEquals(134, ObjectFabric.getObject(DFSSolver.class).solve(maze).size());
    }
}