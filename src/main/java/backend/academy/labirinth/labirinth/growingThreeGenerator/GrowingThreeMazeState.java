package backend.academy.labirinth.labirinth.growingThreeGenerator;

import backend.academy.labirinth.exception.InvalidInputOutputCoords;
import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.util.RandomShell;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GrowingThreeMazeState {

    private final int Ysize;
    private final int Xsize;
    private final Coordinate input;
    private Coordinate output;
    private final RandomShell random;
    private final List<Coordinate> activeCoords = new ArrayList<>();
    private final Cell[][] maze;


    public GrowingThreeMazeState(int height, int width, Coordinate input, Coordinate output, RandomShell random) {
        this.Ysize = reductionToOdd(height);
        this.Xsize = reductionToOdd(width);
        this.input = input;
        this.output = output;
        this.random = random;
        this.maze = new Cell[Ysize][Xsize];
    }

    private int reductionToOdd (int val){
        if (val % 2 == 0){
             val --;
        }
        return val;
    }


    public Maze generateMaze() {

        if(checkEdgeCoords(input)){
            throw new InvalidInputOutputCoords("invalid input output coords");
        }
        if(output != null && (checkEdgeCoords(output) || input.equals(output))){
            throw new InvalidInputOutputCoords("invalid input output coords");
        }
        for(Cell[] cells : maze){
            Arrays.fill(cells, new Cell(Cell.Type.WALL));
        }

        Coordinate currentCoord = input;
        activeCoords.add(currentCoord);
        while (!activeCoords.isEmpty()){
            Coordinate tempCoord = null;
            while (currentCoord != null){
                tempCoord = currentCoord;
                currentCoord = getRandomNeighbourCoordinate(currentCoord);
                if(currentCoord != null){
                    maze[currentCoord.Y()][currentCoord.X()] =  new Cell(Cell.Type.PASSAGE);
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


        Cell[][] cells =  new Cell[Ysize+2][Xsize+2];

        for (int j = 0; j < Xsize+2; j++) {
            cells[0][j] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < Xsize+2; j++) {
            cells[Ysize+1][j] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < Ysize+2; j++) {
            cells[j][0] = new Cell(Cell.Type.WALL);
        }
        for (int j = 0; j < Ysize+2; j++) {
            cells[j][Xsize+1] = new Cell(Cell.Type.WALL);
        }
        for (int i = 1; i < Ysize+1; i++) {
            for (int j = 1; j < Xsize+1; j++) {
                cells[i][j] = maze[i - 1][j -1 ];
            }
        }
        cells[input.Y() + 1][input.X() + 1] = new Cell(Cell.Type.INPUT);
        cells[output.Y() + 1][output.X() + 1] = new Cell(Cell.Type.OUTPUT);
        return new Maze(cells , new Coordinate(input.X() + 1, input.Y() + 1), new Coordinate(output.X() + 1, output.Y() + 1));
    }

    private Coordinate getRandomNeighbourCoordinate(Coordinate coord) {
        NeighborManager neighborManager = new NeighborManager(coord);
        return neighborManager.brakeWall();
    }

    private boolean checkEdgeCoords(Coordinate coordinate){
        return coordinate.X() != Xsize - 2 && coordinate.X() != 0 && coordinate.Y() != Ysize - 2 && coordinate.Y() != 0;
    }

    private boolean validateCoordsToPoolNeighbourCoords(Coordinate coord){
        return Maze.isValidCoordinate(coord, Ysize, Xsize) && !activeCoords.contains(coord) && maze[coord.Y()][coord.X()].type() != Cell.Type.PASSAGE;
    }


    private class NeighborManager{
        private final List<Coordinate> neighbors = new ArrayList<>();
        private final Coordinate currentCoord;

        public NeighborManager(Coordinate currentCoord) {
            this.currentCoord = currentCoord;
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.X() + 2, currentCoord.Y()));
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.X(), currentCoord.Y() + 2));
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.X() - 2, currentCoord.Y()));
            addCoordsToPoolActiveCoords(new Coordinate(currentCoord.X(), currentCoord.Y() - 2));

        }

        private void addCoordsToPoolActiveCoords(Coordinate coord){
            if(validateCoordsToPoolNeighbourCoords(coord)){
                neighbors.add(coord);
            }
        }

        private Coordinate brakeWall(){
            if(neighbors.isEmpty()){
                return null;
            }
            Coordinate res = neighbors.get(random.get(neighbors.size()));
            if(res.Y() > currentCoord.Y()){
                maze[currentCoord.Y() + 1][currentCoord.X()] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            if(res.Y() < currentCoord.Y()){
                maze[currentCoord.Y() - 1][currentCoord.X()] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            if(res.X() > currentCoord.X()){
                maze[currentCoord.Y()][currentCoord.X()  +1] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            if(res.X() < currentCoord.X()){
                maze[currentCoord.Y()][currentCoord.X() - 1] = new Cell(Cell.Type.PASSAGE);
                return res;
            }
            return null;
        }
    }
}
