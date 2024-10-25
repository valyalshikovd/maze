package backend.academy.labirinth.labirinth.generator.cellFactory;

import backend.academy.labirinth.config.Config;
import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

@SuppressWarnings("MagicNumber")
public class ExtendedCellsFactory implements CellFactory {

    private final RandomShell random;

    private int count = 0;
    private Cell.Type currentType;

    @Inject
    public ExtendedCellsFactory(RandomShell random) {
        this.random = random;
    }

    @Override
    public Cell getPassageCell() {
        setType();
        count -= 1;
        return new Cell(currentType);
    }

    private void setType() {
        if (count <= 0) {
            int type = random.get(Config.COUNT_OF_SURFACES);
            switch (type) {
                case 0:
                    currentType = Cell.Type.PASSAGE;
                    count = random.get(10);
                    break;
                case 1:
                    currentType = Cell.Type.COIN;
                    count = 1;
                    break;
                case 2:
                    currentType = Cell.Type.SWAMP;
                    count = random.get(8);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public Cell getOutput() {
        return new Cell(Cell.Type.OUTPUT);
    }

    @Override
    public Cell getInput() {
        return new Cell(Cell.Type.INPUT);
    }

    @Override
    public Cell getWall() {
        return new Cell(Cell.Type.WALL);
    }
}
