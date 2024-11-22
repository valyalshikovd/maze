package Test.labirinth.algorithm;


import backend.academy.labirinth.labirinth.CellType;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.solver.DFSSolver.DFSSolver;
import backend.academy.labirinth.util.juice.ObjectFabric;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFSTest {

    CellType[][] cells = new CellType[][] {
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.COIN), (CellType.WALL),
            (CellType.INPUT), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.COIN), (CellType.COIN), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.COIN),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.COIN), (CellType.PASSAGE), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.COIN), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.COIN), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.COIN), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.PASSAGE),
            (CellType.COIN), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.COIN), (CellType.COIN), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
            (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.COIN),
            (CellType.PASSAGE), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.COIN), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.COIN), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.COIN), (CellType.SWAMP), (CellType.PASSAGE),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.COIN), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.COIN), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
            (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.COIN), (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.SWAMP), (CellType.WALL),
            (CellType.COIN), (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.WALL), (CellType.SWAMP), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.COIN),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.COIN),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.OUTPUT),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.COIN), (CellType.WALL), (CellType.PASSAGE),
            (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
            (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
            (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
            (CellType.COIN), (CellType.PASSAGE), (CellType.WALL),
            (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
            (CellType.COIN), (CellType.SWAMP), (CellType.PASSAGE),
            (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
            (CellType.COIN), (CellType.SWAMP), (CellType.WALL),
            (CellType.WALL),},
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL),}};

    @Test
    public void testDFSSolver(){
        Maze maze = new Maze(cells, new Coordinate(18, 1), new Coordinate(26, 27));
        assertEquals(134, ObjectFabric.getObject(DFSSolver.class).solve(maze).size());
    }
}
