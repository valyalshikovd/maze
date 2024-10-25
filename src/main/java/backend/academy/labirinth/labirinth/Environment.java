package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.exception.InvalidMaze;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.StepByStepGenerator;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.labirinth.wallDestroyer.WallDestroyer;
import lombok.Getter;
import java.util.List;

public class Environment {

    protected Generator generator;
    protected Solver solver;
    protected boolean loops = false;
    @Getter protected Maze maze = null;

    public Environment(
        Generator generator,
        Solver solver,
        boolean loops
    ) {
        this.generator = generator;
        this.solver = solver;
        this.loops = loops;
    }

    public Maze createMaze(int height, int width) {
        this.maze = generator.generate(height, width);
        if(loops){
            this.maze = WallDestroyer.destroyWalls(this.maze);
        }
        return this.maze;
    }

    public List<Coordinate> solveMaze() {
        if(this.maze == null){
            throw new InvalidMaze("Maze is null");
        }
        return solver.solve(this.maze);
    }

}
