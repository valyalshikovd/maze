package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.exception.InvalidGenerator;
import backend.academy.labirinth.exception.InvalidSolver;
import backend.academy.labirinth.labirinth.generator.GeneratingStepByStep;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.labirinth.solver.SolvableStepByStep;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.labirinth.solver.StepByStepSolver;
import backend.academy.labirinth.labirinth.wallDestroyer.WallDestroyer;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * Класс расширяющий окружение. Содержит функционал для взаимодействия с алгоритмами отображаемыми пошагово.
 */
@SuppressWarnings("MultipleStringLiterals")
public class EnvironmentStepByStep extends Environment {

    private StepByStepSolver stepByStepSolver;
    private StepByStepGenerator stepByStepGenerator;
    @Getter
    private boolean flagSolver;
    @Getter
    private boolean flagGenerator;

    public EnvironmentStepByStep(Generator generator,
        Solver solver, boolean loops, boolean flagSolver, boolean flagGenerator) {
        super(generator, solver, loops);
        this.flagSolver = flagSolver;
        this.flagGenerator = flagGenerator;
        this.stepByStep = true;
        if (flagSolver) {
            stepByStepSolver = ((SolvableStepByStep) solver).getStepByStepSolver();
        }

    }

    public void setSizeMaze(int height, int width) {
        if (!flagGenerator) {
            return;
        }
        stepByStepGenerator = ((GeneratingStepByStep) generator).getStepByStepGenerator(height, width);

    }

    public void setSizeMaze(int height, int width, Coordinate input, Coordinate output) {
        if (!flagGenerator) {
            return;
        }
        stepByStepGenerator = ((GeneratingStepByStep) generator).getStepByStepGenerator(height, width, input, output);

    }

    public boolean generateHasNext() {
        if (stepByStepGenerator == null) {
            throw new InvalidGenerator("Generator not initialized");
        }
        boolean res = stepByStepGenerator.hasNext();

        if (!res) {
            Maze maze = WallDestroyer.destroyWalls(stepByStepGenerator.getMaze());
            this.maze = maze;
            if (flagSolver) {
                stepByStepSolver.setMaze(maze);
            }
        }
        return res;
    }

    public void generateNext(int countSteps) {
        if (stepByStepGenerator == null) {
            throw new InvalidGenerator("Generator not initialized");
        }
        for (int i = 0; i < countSteps; i++) {
            if (stepByStepGenerator.hasNext()) {
                stepByStepGenerator.next();
                maze = stepByStepGenerator.getMaze();
            }
        }
    }

    public boolean solverHasNext() {
        if (stepByStepSolver == null) {
            throw new InvalidSolver("Solver not initialized");
        }
        if (stepByStepSolver.getMaze() == null) {
            stepByStepSolver.setMaze(maze);
        }
        return stepByStepSolver.hasNext();
    }

    public List<Coordinate> solverNext(int countSteps) {
        if (stepByStepSolver == null) {
            throw new InvalidSolver("Solver not initialized");
        }
        List<Coordinate> res = new ArrayList<Coordinate>();
        for (int i = 0; i < countSteps; i++) {
            if (stepByStepSolver.hasNext()) {
                res = stepByStepSolver.next();
            }
        }
        return res;
    }

    @Override public String toString() {
        return "Окружение с пошаговым отабражанием: "
            + ",\nГенератор: " + generator
            + ",\nSolver: " + solver
            + ",\nЦиклы: " + loops
            + ",\nSolver: " + solver
            + ",\nГенератор: " + generator
            + ",\nПошаговое отображение поиска решения: " + flagSolver
            + ",\nПошаговое отображение генерации лабиринта: " + flagGenerator;
    }
}
