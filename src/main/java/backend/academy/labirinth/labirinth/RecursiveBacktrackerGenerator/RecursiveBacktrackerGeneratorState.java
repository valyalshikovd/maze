package backend.academy.labirinth.labirinth.RecursiveBacktrackerGenerator;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.CellFactory;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.GeneratorWithNeighborManager;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.StepByStepGenerator;
import backend.academy.labirinth.labirinth.StepByStepSolver;
import backend.academy.labirinth.util.RandomShell;
import net.bytebuddy.asm.MemberSubstitution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RecursiveBacktrackerGeneratorState extends GeneratorWithNeighborManager implements StepByStepGenerator {


    private Coordinate currentCoord;
    private Stack<Iteration> iterationStack = new Stack<>();
    private CellFactory cellFactory;

    private static int reductionToOdd (int val){
        if (val % 2 == 0){
            val --;
        }
        return val;
    }

    public RecursiveBacktrackerGeneratorState(
        int x_SIZE,
        int y_SIZE,
        Coordinate inputCoord,
        Coordinate outputCoord,
        RandomShell random,
        CellFactory cellFactory
    ) {
        super(reductionToOdd(y_SIZE), reductionToOdd(x_SIZE), new Coordinate(inputCoord.X() + 1,inputCoord.Y() + 1), outputCoord, random);
        currentCoord = new Coordinate(inputCoord.X(), inputCoord.Y());
        this.cellFactory = cellFactory;
        for(Cell[] cells : maze){
            Arrays.fill(cells, cellFactory.getWall());
        }

        maze[inputCoord.Y()][inputCoord.X()] = cellFactory.getInput();

    }

    public boolean hasNext(){
        return currentCoord != null;
    }

    public void next() {

        List<Coordinate> neighbors = getNeighbors(currentCoord);

        if(neighbors.isEmpty() && output == null){
            output = currentCoord;
        }

        Coordinate coordinate = null;

        if(!neighbors.isEmpty()){
            coordinate = neighbors.get(random.get(neighbors.size()));
        }


        if(coordinate != null) {
            neighbors.remove(coordinate);
            breakWalls(currentCoord, coordinate);


            for (Coordinate neighbor : neighbors) {
                iterationStack.add(new Iteration(currentCoord, neighbor));
            }
            currentCoord = coordinate;
        }
        if( coordinate == null &&  !iterationStack.isEmpty() ) {

            Iteration iter = iterationStack.pop();
            while (!validateCoordsToPoolNeighbourCoords(iter.nextCoord)){
                if(iterationStack.isEmpty()){
                    currentCoord = null;
                    return;
                }
                iter = iterationStack.pop();
            }
                breakWalls(iter.currentCoord, iter.nextCoord);
                currentCoord = iter.nextCoord;

        }
        if(currentCoord != null && validateCoordsToPoolNeighbourCoords(currentCoord)  ) {
            activeCoords.add(currentCoord);
            maze[currentCoord.Y()][currentCoord.X()] = cellFactory.getPassageCell();
        }

        Cell[][] cells = new Cell[this.Ysize + 2][this.Xsize + 2];

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
    //
    //    cells[input.Y()][input.X()] = new Cell(Cell.Type.INPUT);
        if(output != null){
            cells[output.Y() + 1][output.X() + 1] = new Cell(Cell.Type.OUTPUT);
        }

        actualMaze = new Maze(cells, input, output);
    }

    private void breakWalls(Coordinate source, Coordinate target){
        if(target.Y() > source.Y()){
            maze[source.Y() + 1][source.X()] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.X(), source.Y()+1));
        }
        if(target.Y() < source.Y()){
            maze[source.Y() - 1][source.X()] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.X(), source.Y()-1));
        }
        if(target.X() > source.X()){
            maze[source.Y()][source.X()  +1] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.X() + 1, source.Y()+1));
        }
        if(target.X() < source.X()){
            maze[source.Y()][source.X() - 1] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.X()-1, source.Y()));
        }
    }

    private static class Iteration{
        Coordinate currentCoord;
        Coordinate nextCoord;

        public Iteration(Coordinate currentCoord, Coordinate nextCoord) {
            this.currentCoord = currentCoord;
            this.nextCoord = nextCoord;
        }
    }

    private List<Coordinate> getNeighbors(Coordinate coordinate){
        List<Coordinate> neighbors = new ArrayList<>();
        Coordinate coord = new Coordinate(coordinate.X() ,coordinate.Y() + 2);
        if(validateCoordsToPoolNeighbourCoords(coord)){
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.X() ,coordinate.Y() - 2);
        if(validateCoordsToPoolNeighbourCoords(coord)){
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.X() + 2 ,coordinate.Y());
        if(validateCoordsToPoolNeighbourCoords(coord)){
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.X() - 2 ,coordinate.Y());
        if(validateCoordsToPoolNeighbourCoords(coord)){
            neighbors.add(coord);
        }
        return neighbors;
    }

    private boolean validateCoordsToPoolNeighbourCoords(Coordinate coord){
        return
            Maze.isValidCoordinate(coord, Ysize, Xsize)
                && !activeCoords.contains(coord) && maze[coord.Y()][coord.X()].type() != Cell.Type.PASSAGE
                && maze[coord.Y()][coord.X()].type() != Cell.Type.INPUT
                && maze[coord.Y()][coord.X()].type() != Cell.Type.COIN
                && maze[coord.Y()][coord.X()].type() != Cell.Type.SWAMP;
    }

    @Override
    public Maze getMaze() {
        return actualMaze;
    }
}
