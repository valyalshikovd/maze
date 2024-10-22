package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.labirinth.RecursiveBacktrackerGenerator.RecursiveBacktrackerGenerator;
import backend.academy.labirinth.labirinth.RecursiveBacktrackerGenerator.RecursiveBacktrackerGeneratorState;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.util.juice.ObjectFabric;
import com.google.inject.Inject;
import java.util.List;
import java.util.Scanner;

public final class MazeManager {

    private final OutputService outputService;
    private final Generator generator;
    private final Solver solver;

    @Inject
    private MazeManager(OutputService outputService, Generator generator, Solver solver) {
        this.outputService = outputService;
        this.generator = generator;
        this.solver = solver;
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

        StepByStepSolver stepByStepSolver = solver.getStepByStepSolver(s.getMaze());

        while (stepByStepSolver.hasNext()){
            outputService.drawMaze(s.getMaze(), stepByStepSolver.next());
            scanner.nextLine();
        }
        //outputService.drawMaze(maze, solver.solve(maze));

    }
}
