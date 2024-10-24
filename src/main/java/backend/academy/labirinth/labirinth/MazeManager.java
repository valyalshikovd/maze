package backend.academy.labirinth.labirinth;


import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.labirinth.solver.StepByStepSolver;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.service.mazeRenderer.impl.RendererImpl;
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
        System.out.println(ObjectFabric.getObject(RendererImpl.class).getCodeMaze(maze));
    }
}
