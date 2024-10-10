package backend.academy.labirinth.labirinth.growingThreeGenerator;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Generator;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.util.RandomShell;
import jakarta.inject.Inject;

public class GrowingThreeMazeGenerator implements Generator {

    private final RandomShell random;

    @Inject
    public GrowingThreeMazeGenerator(RandomShell random) {
        this.random = random;
    }

    @Override
    public Maze generate(int height, int width) {
        int side = random.get(4);
        Coordinate coordinate = switch (side) {
            case 0 -> new Coordinate(random.get(width - 3), 0);
            case 1 -> new Coordinate(width - 3, random.get(height - 3));
            case 2 -> new Coordinate(random.get(width - 3), height - 3);
            case 3 -> new Coordinate(0, random.get(height - 3));
            default -> null;
        };
        return new GrowingThreeMazeState(height, width, coordinate, null, random).generateMaze();
    }

//    @Override
//    public Maze generate(int height, int width, Side sideInput) {
//        Coordinate coordinate = switch (sideInput.value()) {
//            case 0 -> new Coordinate(random.get(width - 3), 0);
//            case 1 -> new Coordinate(width - 3, random.get(height - 3));
//            case 2 -> new Coordinate(random.get(width - 3), height - 3);
//            case 3 -> new Coordinate(0, random.get(height - 3));
//            default -> null;
//        };
//
//        return new GrowingThreeMazeState(height, width, coordinate, null, random).generateMaze();
//    }
//
//    @Override
//    public Maze generate(int height, int width, Side sideInput, int coordInput) {
//        Coordinate coordinate = switch (sideInput.value()) {
//            case 0 -> new Coordinate(coordInput, 0);
//            case 1 -> new Coordinate(width - 3, coordInput);
//            case 2 -> new Coordinate(coordInput, height - 3);
//            case 3 -> new Coordinate(0, coordInput);
//            default -> null;
//        };
//
//        return new GrowingThreeMazeState(height, width, coordinate, null, random).generateMaze();
//    }
//
//    @Override
//    public Maze generate(int height, int width, Side sideInput, int coordInput, Side sideOutput) {
//        Coordinate coordinate = switch (sideInput.value()) {
//            case 0 -> new Coordinate(coordInput, 0);
//            case 1 -> new Coordinate(width - 3, coordInput);
//            case 2 -> new Coordinate(coordInput, height - 3);
//            case 3 -> new Coordinate(0, coordInput);
//            default -> null;
//        };
//        Coordinate output = switch (sideOutput.value()) {
//            case 0 -> new Coordinate(random.get(width - 3), 0);
//            case 1 -> new Coordinate(width - 3, random.get(height - 3));
//            case 2 -> new Coordinate(random.get(width - 3), height - 3);
//            case 3 -> new Coordinate(0, random.get(height - 3));
//            default -> null;
//        };
//        return new GrowingThreeMazeState(height, width, coordinate, output, random).generateMaze();
//    }
//
//    @Override
//    public Maze generate(int height, int width, Side sideInput, int coordInput, Side sideOutput, int coordOutput) {
//        Coordinate coordinateInput = switch (sideInput.value()) {
//            case 0 -> new Coordinate(coordInput, 0);
//            case 1 -> new Coordinate(width - 3, coordInput);
//            case 2 -> new Coordinate(coordInput, height - 3);
//            case 3 -> new Coordinate(0, coordInput);
//            default -> null;
//        };
//        Coordinate coordinateOutput = switch (sideInput.value()) {
//            case 0 -> new Coordinate(coordInput, 0);
//            case 1 -> new Coordinate(width - 3, coordOutput);
//            case 2 -> new Coordinate(coordOutput, height - 3);
//            case 3 -> new Coordinate(0, coordOutput);
//            default -> null;
//        };
//        return new GrowingThreeMazeState(height, width, coordinateInput, coordinateOutput, random).generateMaze();
//    }
//
//    @Override
//    public Maze generate(int height, int width, Side sideInput, Side sideOutput) {
//        Coordinate coordinateInput = switch (sideInput.value()) {
//            case 0 -> new Coordinate(random.get(width - 3), 0);
//            case 1 -> new Coordinate(width - 3, random.get(height - 3));
//            case 2 -> new Coordinate(random.get(width - 3), height - 3);
//            case 3 -> new Coordinate(0, random.get(height - 3));
//            default -> null;
//        };
//        Coordinate coordinateOutput = switch (sideOutput.value()) {
//            case 0 -> new Coordinate(random.get(width - 3), 0);
//            case 1 -> new Coordinate(width - 3, random.get(height - 3));
//            case 2 -> new Coordinate(random.get(width - 3), height - 3);
//            case 3 -> new Coordinate(0, random.get(height - 3));
//            default -> null;
//        };
//        return new GrowingThreeMazeState(height, width, coordinateInput, coordinateOutput, random).generateMaze();
//    }
}
