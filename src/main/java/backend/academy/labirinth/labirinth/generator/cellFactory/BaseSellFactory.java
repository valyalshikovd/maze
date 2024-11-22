package backend.academy.labirinth.labirinth.generator.cellFactory;

import backend.academy.labirinth.labirinth.CellType;

public class BaseSellFactory implements CellFactory {
    @Override
    public CellType getPassageCell() {
        return CellType.PASSAGE;
    }

    @Override
    public CellType getOutput() {
        return null;
    }

    @Override
    public CellType getInput() {
        return null;
    }

    @Override
    public CellType getWall() {
        return null;
    }
}
