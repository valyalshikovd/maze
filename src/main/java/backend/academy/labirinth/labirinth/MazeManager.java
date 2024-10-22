package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.labirinth.RecursiveBacktrackerGenerator.RecursiveBacktrackerGenerator;
import backend.academy.labirinth.labirinth.RecursiveBacktrackerGenerator.RecursiveBacktrackerGeneratorState;
import backend.academy.labirinth.labirinth.wallDestroyer.WallDestroyer;
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

//        Maze maze = generator.generate(30, 30);
//
//        Scanner scanner = new Scanner(System.in);
//        StepByStepSolver s = solver.getStepByStepSolver(maze);
//        while (s.hasNext()){
//            outputService.drawMaze(maze, s.next());
//            scanner.nextLine();
//        }


        Scanner scanner = new Scanner(System.in);
       // StepByStepSolver s = solver.getStepByStepSolver(maze);
        StepByStepGenerator s = generator.getStepByStepGenerator(30,30);

        while (s.hasNext()){
            s.next();
            outputService.drawMaze(s.getMaze());
            scanner.nextLine();
        }

        Maze m = WallDestroyer.destroyWalls(s.getMaze(), randomShell,  cellFactory);

//        StringBuilder sb = new StringBuilder();
//        for(Cell[] c : m.getGrid()) {
//            for(Cell cell : c) {
//                sb.append(cell.type().value());
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb.toString());


        outputService.drawMaze(m);


        StepByStepSolver stepByStepSolver = solver.getStepByStepSolver(m);

        while (stepByStepSolver.hasNext()){
            outputService.drawMaze(m, stepByStepSolver.next());
            scanner.nextLine();
        }
        //outputService.drawMaze(maze, solver.solve(maze));

    }
}
