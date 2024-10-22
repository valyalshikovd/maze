package backend.academy.labirinth.labirinth.generator.cellFactory;

import backend.academy.labirinth.labirinth.Cell;

public interface CellFactory {

    public Cell getPassageCell();
    public Cell getOutput();
    public Cell getInput();
    public Cell getWall();
}
