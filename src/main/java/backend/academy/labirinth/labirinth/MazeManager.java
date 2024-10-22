package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.labirinth.solver.dijkstrasAlgorithmSolver.DijkstrasAlgorithmSolver;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.labirinth.generator.wallDestroyer.WallDestroyer;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.util.RandomShell;
import backend.academy.labirinth.util.juice.ObjectFabric;
import com.google.inject.Inject;
import java.util.List;
import java.util.Scanner;

public final class MazeManager {

    private final OutputService outputService;
    private final Generator generator;
    private final Solver solver;
    private final RandomShell randomShell;
    private final CellFactory cellFactory;

    @Inject
    private MazeManager(OutputService outputService, Generator generator, Solver solver,
        CellFactory cellFactory,
        RandomShell randomShell
    ) {
        this.outputService = outputService;
        this.generator = generator;
        this.solver = solver;
        this.cellFactory = cellFactory;
        this.randomShell = randomShell;
    }


    public static void initialize() {
        ObjectFabric.getObject(MazeManager.class).start();
    }

    public void start(){


        Cell[][] cells = new Cell[][]{
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.INPUT),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.SWAMP),new Cell(Cell.Type.WALL),new Cell(Cell.Type.COIN),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.OUTPUT),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
            new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL)},
        };
   //    Maze maze = new Maze(cells, new Coordinate(2, 1), new Coordinate(2, 9));



//  //     Maze maze = generator.generate(30, 30);
//
//        Scanner scanner = new Scanner(System.in);
//        StepByStepSolver s = solver.getStepByStepSolver(maze);
//        while (s.hasNext()){
//            outputService.drawMaze(maze, s.next());
//            scanner.nextLine();
//        }


       Scanner scanner = new Scanner(System.in);
       // StepByStepSolver s = solver.getStepByStepSolver(maze);
        StepByStepGenerator s = generator.getStepByStepGenerator(21,21);

        while (s.hasNext()){
           s.next();
      //      outputService.drawMaze(s.getMaze());
     //       scanner.nextLine();
        }
        Maze m = WallDestroyer.destroyWalls(s.getMaze(), randomShell,  cellFactory);


       outputService.drawMaze(m);

  //     outputService.drawCode(m);


//        StepByStepSolver stepByStepSolver = solver.getStepByStepSolver(m);
//
//        while (stepByStepSolver.hasNext()){
//            outputService.drawMaze(m, stepByStepSolver.next());
//       //     scanner.nextLine();
//        }
        outputService.drawMaze(m, solver.solve(m));


        List<Coordinate> coordinates = new DijkstrasAlgorithmSolver().solve(m);
 //       scanner.close();
    //    System.out.println(coordinates);
     //   System.out.println(coordinates.size());
   //   outputService.drawMaze(maze, new DijkstrasAlgorithmState(maze).solve());
        outputService.drawMaze(m, coordinates);

    }
}
