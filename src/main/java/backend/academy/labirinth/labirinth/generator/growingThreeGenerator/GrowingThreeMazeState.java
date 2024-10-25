package backend.academy.labirinth.labirinth.generator.growingThreeGenerator;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.generator.GeneratorWithNeighborManager;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.util.RandomShell;
import java.util.Arrays;

public final class GrowingThreeMazeState extends GeneratorWithNeighborManager {



    public GrowingThreeMazeState(int height, int width, Coordinate input, Coordinate output, RandomShell random) {
        super(reductionToOdd(height), reductionToOdd(width), input, output, random);
    }

    private static int reductionToOdd (int val) {
        if (val % 2 == 0){
             val --;
        }
        return val;
    }


    public Maze generateMaze() {

        for(Cell[] cells : maze) {
            Arrays.fill(cells, new Cell(Cell.Type.WALL));
        }

        Coordinate currentCoord = input;
        activeCoords.add(currentCoord);
        while (!activeCoords.isEmpty()) {
            Coordinate tempCoord = null;
            while (currentCoord != null) {
                tempCoord = currentCoord;
                currentCoord = getRandomNeighbourCoordinate(currentCoord);
                if (currentCoord != null) {
                    maze[currentCoord.y()][currentCoord.x()] =  new Cell(Cell.Type.PASSAGE);
                    activeCoords.add(currentCoord);
                }
            }
            if(output == null){
                output = tempCoord;
            }
            activeCoords.remove(tempCoord);
            if(!activeCoords.isEmpty()){
                currentCoord = activeCoords.get(random.get(activeCoords.size()));
            }
        }


        Cell[][] cells =  new Cell[ySize +2][xSize +2];

        for (int j = 0; j < xSize +2; j++) {
            cells[0][j] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < xSize +2; j++) {
            cells[ySize +1][j] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < ySize +2; j++) {
            cells[j][0] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < ySize +2; j++) {
            cells[j][xSize +1] = new Cell(Cell.Type.WALL);
        }
        for (int i = 1; i < ySize +1; i++) {
            for (int j = 1; j < xSize +1; j++) {
                cells[i][j] = maze[i - 1][j -1 ];
            }
        }
        cells[input.y() + 1][input.x() + 1] = new Cell(Cell.Type.INPUT);
        cells[output.y() + 1][output.x() + 1] = new Cell(Cell.Type.OUTPUT);
        return new Maze(cells , new Coordinate(input.x() + 1, input.y() + 1), new Coordinate(output.x() + 1, output.y() + 1));
    }

    private Coordinate getRandomNeighbourCoordinate(Coordinate coord) {
        NeighborManager neighborManager = new NeighborManager(coord);
        return neighborManager.brakeWall();
    }

    private boolean checkEdgeCoords(Coordinate coordinate) {
        return coordinate.x() != xSize - 2 && coordinate.x() != 0 && coordinate.y() != ySize - 2 && coordinate.y() != 0;
    }

    private boolean validateCoordsToPoolNeighbourCoords(Coordinate coord) {
        return Maze.isValidCoordinate(coord, ySize, xSize)
            && !activeCoords.contains(coord)
            && maze[coord.y()][coord.x()].type() != Cell.Type.PASSAGE
            && maze[coord.y()][coord.x()].type() != Cell.Type.COIN
            && maze[coord.y()][coord.x()].type() != Cell.Type.SWAMP;
    }
}
