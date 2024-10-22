package backend.academy.labirinth.labirinth.generator.cellFactory;

import backend.academy.labirinth.labirinth.Cell;

public class BaseSellFactory implements CellFactory {
    @Override
    public Cell getPassageCell() {
        return new Cell(Cell.Type.PASSAGE);
    }

    @Override
    public Cell getOutput() {
        return null;
    }

    @Override
    public Cell getInput() {
        return null;
    }

    @Override
    public Cell getWall() {
        return null;
    }
}
