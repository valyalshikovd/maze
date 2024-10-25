package backend.academy.labirinth.labirinth.generator.RecursiveBacktrackerGenerator;

import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.generator.GeneratorWithNeighborManager;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.util.RandomShell;
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
        super(reductionToOdd(y_SIZE), reductionToOdd(x_SIZE), new Coordinate(inputCoord.x() + 1,inputCoord.y() + 1), outputCoord, random);
        currentCoord = new Coordinate(inputCoord.x(), inputCoord.y());
        this.cellFactory = cellFactory;
        for(Cell[] cells : maze){
            Arrays.fill(cells, cellFactory.getWall());
        }

        maze[inputCoord.y()][inputCoord.x()] = cellFactory.getInput();

    }

    public boolean hasNext(){
        return currentCoord != null;
    }

    public void next() {

        List<Coordinate> neighbors = getNeighbors(currentCoord);

        if (neighbors.isEmpty() && output == null) {
            System.out.println("-");
            output = currentCoord;
        }

        Coordinate coordinate = null;

        if (!neighbors.isEmpty()) {
            coordinate = neighbors.get(random.get(neighbors.size()));
        }


        if (coordinate != null) {
            neighbors.remove(coordinate);
            breakWalls(currentCoord, coordinate);


            for (Coordinate neighbor : neighbors) {
                iterationStack.add(new Iteration(currentCoord, neighbor));
            }
            currentCoord = coordinate;
        }
        if (coordinate == null &&  !iterationStack.isEmpty()) {

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
        if (currentCoord != null && validateCoordsToPoolNeighbourCoords(currentCoord)) {
            activeCoords.add(currentCoord);
            maze[currentCoord.y()][currentCoord.x()] = cellFactory.getPassageCell();
        }

        Cell[][] cells = new Cell[this.ySize + 2][this.xSize + 2];

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
        if (output != null) {
            cells[output.y() + 1][output.x() + 1] = new Cell(Cell.Type.OUTPUT);
        }

        if (output == null) {
            actualMaze = new Maze(cells, new Coordinate(input.x()  + 1, input.y() + 1), null);
        }else {
            actualMaze = new Maze(cells, new Coordinate(input.x()  + 1, input.y() + 1), new Coordinate(output.x() + 1, output.y() + 1));
        }
    }

    private void breakWalls(Coordinate source, Coordinate target){
        if (target.y() > source.y()) {
            maze[source.y() + 1][source.x()] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x(), source.y()+1));
        }
        if (target.y() < source.y()) {
            maze[source.y() - 1][source.x()] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x(), source.y()-1));
        }
        if (target.x() > source.x()) {
            maze[source.y()][source.x()  +1] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x() + 1, source.y()+1));
        }
        if (target.x() < source.x()) {
            maze[source.y()][source.x() - 1] = cellFactory.getPassageCell();
            activeCoords.add(new Coordinate(source.x()-1, source.y()));
        }
    }

    private static class Iteration {
        Coordinate currentCoord;
        Coordinate nextCoord;

        public Iteration(Coordinate currentCoord, Coordinate nextCoord) {
            this.currentCoord = currentCoord;
            this.nextCoord = nextCoord;
        }
    }

    private List<Coordinate> getNeighbors(Coordinate coordinate){
        List<Coordinate> neighbors = new ArrayList<>();
        Coordinate coord = new Coordinate(coordinate.x() ,coordinate.y() + 2);
        if (validateCoordsToPoolNeighbourCoords(coord)){
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.x() ,coordinate.y() - 2);
        if (validateCoordsToPoolNeighbourCoords(coord)) {
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.x() + 2 ,coordinate.y());
        if (validateCoordsToPoolNeighbourCoords(coord)) {
            neighbors.add(coord);
        }
        coord = new Coordinate(coordinate.x() - 2 ,coordinate.y());
        if (validateCoordsToPoolNeighbourCoords(coord)) {
            neighbors.add(coord);
        }
        return neighbors;
    }

    private boolean validateCoordsToPoolNeighbourCoords(Coordinate coord){
        return
            Maze.isValidCoordinate(coord, ySize, xSize)
                && !activeCoords.contains(coord) && maze[coord.y()][coord.x()].type() != Cell.Type.PASSAGE
                && maze[coord.y()][coord.x()].type() != Cell.Type.INPUT
                && maze[coord.y()][coord.x()].type() != Cell.Type.COIN
                && maze[coord.y()][coord.x()].type() != Cell.Type.SWAMP;
    }

    @Override
    public Maze getMaze() {
        return actualMaze;
    }
}
