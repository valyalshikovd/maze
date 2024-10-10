package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.util.RandomShell;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneratorWithNeighborManager {

    protected int Ysize;
    protected int Xsize;
    protected final Coordinate input;
    protected Coordinate output;
    protected final RandomShell random;
    protected final List<Coordinate> activeCoords = new ArrayList<>();
    protected final Cell[][] maze;

    protected GeneratorWithNeighborManager(int ysize, int xsize, Coordinate input, Coordinate output, RandomShell random) {
        Ysize = ysize;
        Xsize = xsize;
        this.input = input;
        this.output = output;
        this.random = random;
        this.maze = new Cell[Ysize][Xsize];
    }

    private boolean validateCoordsToPoolNeighbourCoords(Coordinate coord){
        return Maze.isValidCoordinate(coord, Ysize, Xsize) && !activeCoords.contains(coord) && maze[coord.Y()][coord.X()].type() != Cell.Type.PASSAGE;
    }

    private Coordinate getRandomNeighbourCoordinate(Coordinate coord) {
        NeighborManager neighborManager = new NeighborManager(coord);
        return neighborManager.brakeWall();
    }

    protected class NeighborManager{
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

        public Coordinate brakeWall(){
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
