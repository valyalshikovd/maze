package backend.academy.labirinth;

import backend.academy.labirinth.labirinth.MazeManager;

public class Main {

    public static void main(String[] args) {



         MazeManager.initialize();

//        Cell[][] cells = new Cell[][]{
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)
//            },
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.INPUT), new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)},
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)},
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)},
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)},
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.OUTPUT), new Cell(Cell.Type.WALL)} ,
//            {new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)}}
//        ;
//        Maze maze = new Maze(cells, new Coordinate(1,1), new Coordinate(5,7));
//
//        OutputService outputService = ObjectFabric.getObject(OutputService.class);
//        Solver solver = ObjectFabric.getObject(Solver.class);
//
//        StepByStepSolver s = solver.getStepByStepSolver(maze);
//
//
//        while (s.hasNext()){
//            outputService.drawMaze(maze, s.next());
//            Scanner scanner = new Scanner(System.in);
//            scanner.nextLine();
//        }

    }

}
