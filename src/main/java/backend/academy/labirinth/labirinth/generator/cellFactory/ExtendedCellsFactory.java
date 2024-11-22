package backend.academy.labirinth.labirinth.generator.cellFactory;

import backend.academy.labirinth.config.Config;
import backend.academy.labirinth.labirinth.CellType;
import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

/**
 * Реализация фабрики ячеек, реализует логику различных поверхноствей
 */
@SuppressWarnings("MagicNumber")
public class ExtendedCellsFactory implements CellFactory {

    private final RandomShell random;

    private int count = 0;
    private CellType currentType;

    @Inject
    public ExtendedCellsFactory(RandomShell random) {
        this.random = random;
    }

    @Override
    public CellType getPassageCell() {
        setType();
        count -= 1;
        return currentType;
    }

    private void setType() {
        if (count <= 0) {
            int type = random.get(Config.COUNT_OF_SURFACES);
            switch (type) {
                case 0:
                    currentType = CellType.PASSAGE;
                    count = random.get(10);
                    break;
                case 1:
                    currentType = CellType.COIN;
                    count = 1;
                    break;
                case 2:
                    currentType = CellType.SWAMP;
                    count = random.get(8);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public CellType getOutput() {
        return CellType.OUTPUT;
    }

    @Override
    public CellType getInput() {
        return CellType.INPUT;
    }

    @Override
    public CellType getWall() {
        return CellType.WALL;
    }
}
