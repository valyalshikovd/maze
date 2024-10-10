package backend.academy.labirinth.labirinth;

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

        Maze maze = generator.generate(30, 30);

        Scanner scanner = new Scanner(System.in);
        StepByStepSolver s = solver.getStepByStepSolver(maze);
        while (s.hasNext()){
            outputService.drawMaze(maze, s.next());
            scanner.nextLine();
        }

        //outputService.drawMaze(maze, solver.solve(maze));

    }
}
