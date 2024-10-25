package backend.academy.labirinth.labirinth.wallDestroyer;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.util.RandomShell;
import backend.academy.labirinth.util.RandomShellImpl;
import backend.academy.labirinth.util.juice.ObjectFabric;

public class WallDestroyer {

    public static Maze destroyWalls(Maze maze) {

        Cell[][] cells = maze.getGrid();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (!validType(cells[i][j])) {
                    continue;
                }
                checkNeigbours(cells, i, j, ObjectFabric.getObject(RandomShellImpl.class), ObjectFabric.getObject(CellFactory.class));
            }
        }

        return new Maze(cells, maze.startCoordinate(), maze.endCoordinate());

    }

    private static void checkNeigbours(
        Cell[][] cells,
        int i,
        int j,
        RandomShell randomShell,
        CellFactory cellFactory
    ) {

        if (
            i + 2 < cells.length
                && j + 1 < cells[i].length
                && j - 1 > -1
                && cells[i + 1][j] != null
                && cells[i + 1][j].type() == Cell.Type.WALL
                && cells[i + 2][j] != null
                && validType(cells[i + 2][j])
                && cells[i + 1][j + 1] != null
                && cells[i + 1][j + 1].type() == Cell.Type.WALL
                && cells[i + 1][j - 1] != null
                && cells[i + 1][j - 1].type() == Cell.Type.WALL
        ) {
            int rand = randomShell.get(5);
            if (rand == 4) {
                cells[i + 1][j] = cellFactory.getPassageCell();
            }
        }

        if (
                i - 2 > -1
                && j + 1 < cells[i].length
                && j - 1 > -1
                && cells[i - 1][j] != null
                && cells[i - 1][j].type() == Cell.Type.WALL
                && cells[i - 2][j] != null
                && validType(cells[i - 2][j])
                && cells[i - 1][j + 1] != null
                && cells[i - 1][j + 1].type() == Cell.Type.WALL
                && cells[i - 1][j - 1] != null
                && cells[i - 1][j - 1].type() == Cell.Type.WALL
        ) {
            int rand = randomShell.get(5);
            if (rand == 4) {
                cells[i - 1][j] = cellFactory.getPassageCell();
            }
        }

        if (
            j + 2 < cells[i].length
                && i + 1 < cells[i].length
                && i - 1 > -1
                && cells[i][j + 1] != null
                && cells[i][j + 1].type() == Cell.Type.WALL
                && cells[i][j + 2] != null
                && validType(cells[i][j + 2])
                && cells[i + 1][j + 1] != null
                && cells[i + 1][j + 1].type() == Cell.Type.WALL
                && cells[i - 1][j + 1] != null
                && cells[i - 1][j + 1].type() == Cell.Type.WALL
        ) {
            int rand = randomShell.get(5);
            if (rand == 4) {
                cells[i][j + 1] = cellFactory.getPassageCell();
            }
        }

        if (
            j - 2 > -1
                && i + 1 < cells[i].length
                && i - 1 > -1
                && cells[i][j - 1] != null
                && cells[i][j - 1].type() == Cell.Type.WALL
                && cells[i][j - 2] != null
                && validType(cells[i][j - 2])
                && cells[i + 1][j - 1] != null
                && cells[i + 1][j - 1].type() == Cell.Type.WALL
                && cells[i - 1][j - 1] != null
                && cells[i - 1][j - 1].type() == Cell.Type.WALL
        ) {
            int rand = randomShell.get(5);
            if (rand == 4) {
                cells[i][j - 1] = cellFactory.getPassageCell();
            }
        }
    }

    private static boolean validType(Cell cell) {
        return cell.type() == Cell.Type.COIN
            || cell.type() == Cell.Type.SWAMP
            || cell.type() == Cell.Type.OUTPUT;
    }

}
