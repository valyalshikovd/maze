package backend.academy.labirinth.labirinth;

public class BaseSellFactory implements CellFactory{
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
