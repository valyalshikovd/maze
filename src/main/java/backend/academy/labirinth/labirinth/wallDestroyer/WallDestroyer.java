package backend.academy.labirinth.labirinth.wallDestroyer;

import backend.academy.labirinth.labirinth.CellType;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.util.RandomShell;
import backend.academy.labirinth.util.RandomShellImpl;
import backend.academy.labirinth.util.juice.ObjectFabric;

@SuppressWarnings({"MagicNumber", "CyclomaticComplexity"})
public final class WallDestroyer {

    public static Maze destroyWalls(Maze maze) {

        CellType[][] cells = maze.getGrid();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (!validType(cells[i][j])) {
                    continue;
                }
                checkNeigbours(cells, i, j,
                    ObjectFabric.getObject(RandomShellImpl.class),
                    ObjectFabric.getObject(CellFactory.class));
            }
        }

        return new Maze(cells, maze.startCoordinate(), maze.endCoordinate());
    }

    private static void checkNeigbours(
        CellType[][] cells,
        int i,
        int j,
        RandomShell randomShell,
        CellFactory cellFactory
    ) {

        if (
            i + 2 < cells.length
                && j + 1 < cells[i].length
                && j - 1 > -1
                && checkNeighbourWalls(cells, i + 1, j)
                && cells[i + 2][j] != null
                && validType(cells[i + 2][j])
                && checkNeighbourWalls(cells, i + 1, j + 1)
                && checkNeighbourWalls(cells, i + 1, j - 1)
        ) {
            int rand = randomShell.get(10);
            if (rand == 4) {
                cells[i + 1][j] = cellFactory.getPassageCell();
            }
        }

        if (
                i - 2 > -1
                && j + 1 < cells[i].length
                && j - 1 > -1
                && checkNeighbourWalls(cells, i - 1, j)
                && cells[i - 2][j] != null
                && validType(cells[i - 2][j])
                && checkNeighbourWalls(cells, i - 1, j + 1)
                && checkNeighbourWalls(cells, i - 1, j - 1)
        ) {
            int rand = randomShell.get(10);
            if (rand == 4) {
                cells[i - 1][j] = cellFactory.getPassageCell();
            }
        }

        if (
            j + 2 < cells[i].length
                && i + 1 < cells[i].length
                && i - 1 > -1
                && checkNeighbourWalls(cells, i, j + 1)
                && cells[i][j + 2] != null
                && validType(cells[i][j + 2])
                && checkNeighbourWalls(cells, i + 1, j + 1)
                && checkNeighbourWalls(cells, i - 1, j + 1)
        ) {
            int rand = randomShell.get(10);
            if (rand == 4) {
                cells[i][j + 1] = cellFactory.getPassageCell();
            }
        }

        if (
            j - 2 > -1
                && i + 1 < cells[i].length
                && i - 1 > -1
                && checkNeighbourWalls(cells, i, j - 1)
                && cells[i][j - 2] != null
                && validType(cells[i][j - 2])
                && checkNeighbourWalls(cells, i + 1, j - 1)
                && checkNeighbourWalls(cells, i - 1, j - 1)
        ) {
            int rand = randomShell.get(10);
            if (rand == 4) {
                cells[i][j - 1] = cellFactory.getPassageCell();
            }
        }
    }

    private static boolean checkNeighbourWalls(CellType[][] cells, int i, int j) {
            return cells[i][j] != null
            && cells[i][j] == CellType.WALL;
    }


    private static boolean validType(CellType cell) {
        return
            cell == CellType.PASSAGE
            || cell == CellType.COIN
            || cell == CellType.SWAMP
            || cell == CellType.OUTPUT;
    }

    private WallDestroyer() {
    }
}
