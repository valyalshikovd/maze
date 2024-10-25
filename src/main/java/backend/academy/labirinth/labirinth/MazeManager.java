package backend.academy.labirinth.labirinth;


import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.util.juice.ObjectFabric;
import com.google.inject.Inject;
import org.apache.commons.math3.util.Pair;

@SuppressWarnings("MultipleStringLiterals")
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
        outputService.drawWelcoming();
        outputService.drawDescription();
        Environment environment = outputService.drawElectingConfig();
        boolean continueFlag = true;
        while (continueFlag){
            Pair<Integer, Integer> size = outputService.getMazeSize();
            boolean flagEnteringInputOutput = outputService.drawEnteringRequestCoordinate();
            if(environment.stepByStep){
                EnvironmentStepByStep currEnvironment = (EnvironmentStepByStep) environment;
                if(currEnvironment.flagGenerator()){
                    if(flagEnteringInputOutput){
                        setSizeMaze(currEnvironment, size);
                    }else {
                        currEnvironment.setSizeMaze(size.getFirst(), size.getSecond());
                    }
                    while (currEnvironment.generateHasNext()){
                        int countSteps = outputService.getCountSteps();
                        currEnvironment.generateNext(countSteps);
                        outputService.drawStepDescription();
                        outputService.drawMaze(currEnvironment.maze());
                    }
                }else {
                    currEnvironment.createMaze(size.getFirst(), size.getSecond());
                    outputService.drawMaze(currEnvironment.maze());
                }
                outputService.drawRawText("Решение: ");
                if(currEnvironment.flagSolver()){
                    while (currEnvironment.solverHasNext()){
                        int countSteps = outputService.getCountSteps();
                        outputService.drawStepDescription();
                        outputService.drawMaze(currEnvironment.maze(), currEnvironment.solverNext(countSteps));
                    }
                }else {
                    outputService.drawMaze(currEnvironment.maze(), currEnvironment.solveMaze());
                }
            }else {
                if(flagEnteringInputOutput){
                    createMaze(environment, size);
                }else {
                    environment.createMaze(size.getFirst(), size.getSecond());
                }
                outputService.drawMaze(environment.maze());
                outputService.drawRawText("Решение: ");
                outputService.drawMaze(environment.maze(), environment.solveMaze());
            }
            continueFlag = outputService.drawEnteringContinue();
            if(continueFlag && !outputService.drawEnteringRequestNewEnvironment()){
               environment =  outputService.drawElectingConfig();
            }
        }
    }
    private Pair<Coordinate, Coordinate> enterCoords(){
        Coordinate input = null;
        Coordinate output = null;
        outputService.drawRawText("Введите координату входа: ");
        input = outputService.drawEnteringCoordinate();
        outputService.drawRawText("Введите координату выхода: ");
        output = outputService.drawEnteringCoordinate();
        return new Pair<>(input, output);
    }

    private void setSizeMaze(EnvironmentStepByStep currEnvironment, Pair<Integer, Integer> size){
        try {
            Pair<Coordinate, Coordinate> coords = enterCoords();
            currEnvironment.setSizeMaze(size.getFirst(), size.getSecond(), coords.getFirst(), coords.getSecond());
        } catch (Exception e) {
            outputService.drawRawText("Введены некорректные данные, попробуйтей снова");
            setSizeMaze(currEnvironment, size);

        }
    }

    private void createMaze(Environment currEnvironment, Pair<Integer, Integer> size){
        try {
            Pair<Coordinate, Coordinate> coords = enterCoords();
            currEnvironment.createMaze(size.getFirst(), size.getSecond(), coords.getFirst(), coords.getSecond());
        } catch (Exception e) {
            outputService.drawRawText("Введены некорректные данные, попробуйтей снова");
            createMaze(currEnvironment, size);

        }
    }

}
