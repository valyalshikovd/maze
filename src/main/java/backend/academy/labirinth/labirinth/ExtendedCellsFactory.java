package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

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
        System.out.println(count);
        if(count <= 0){
            int type = random.get(3);
            switch (type) {
                case 0:
                    currentType = Cell.Type.PASSAGE;
                    count = random.get(10);
                    break;
                case 1:
                    currentType = Cell.Type.COIN;
                    System.out.println("монетка");
                    count = 1;
                    break;
                case 2:
                    currentType = Cell.Type.SWAMP;
                    count = random.get(8);
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
