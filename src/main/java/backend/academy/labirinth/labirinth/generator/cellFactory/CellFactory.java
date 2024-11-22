package backend.academy.labirinth.labirinth.generator.cellFactory;

import backend.academy.labirinth.labirinth.CellType;

public interface CellFactory {

    CellType getPassageCell();

    CellType getOutput();

    CellType getInput();

    CellType getWall();
}
