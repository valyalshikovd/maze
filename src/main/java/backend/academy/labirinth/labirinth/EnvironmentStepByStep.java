package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.exception.InvalidGenerator;
import backend.academy.labirinth.exception.InvalidSolver;
import backend.academy.labirinth.labirinth.generator.GeneratingStepByStep;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.labirinth.solver.SolvableStepByStep;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.labirinth.solver.StepByStepSolver;

public class EnvironmentStepByStep extends Environment{

    private StepByStepSolver stepByStepSolver;
    private StepByStepGenerator stepByStepGenerator;

    public EnvironmentStepByStep(Generator generator, Solver solver, boolean loops) {
        super(generator, solver, loops);

        stepByStepSolver = ((SolvableStepByStep) solver).getStepByStepSolver(maze);

    }
    public void setSizeMaze(int height, int width) {
        stepByStepGenerator = ((GeneratingStepByStep) generator).getStepByStepGenerator(height, width);
    }

    public boolean generateHasNext(){
        if (stepByStepGenerator == null) {
            throw new InvalidGenerator("Generator not initialized");
        }
        return stepByStepGenerator.hasNext();
    }

    public void generateNext(int countSteps){
        if (stepByStepGenerator == null) {
            throw new InvalidGenerator("Generator not initialized");
        }
        for (int i = 0; i < countSteps; i++) {
            if(stepByStepGenerator.hasNext()){
                stepByStepGenerator.next();
            }
        }
    }

    public boolean solverHasNext(){
        if (stepByStepSolver == null) {
            throw new InvalidSolver("Solver not initialized");
        }
        return stepByStepSolver.hasNext();
    }

    public void solverNext(int countSteps){
        if (stepByStepSolver == null) {
            throw new InvalidSolver("Solver not initialized");
        }
        for (int i = 0; i < countSteps; i++) {
            if(stepByStepSolver.hasNext()){
                stepByStepSolver.next();
            }
        }
    }
}
