package backend.academy.labirinth.labirinth.generator.cellFactory;

import backend.academy.labirinth.labirinth.Cell;

public interface CellFactory {

    Cell getPassageCell();

    Cell getOutput();

    Cell getInput();

    Cell getWall();
}
