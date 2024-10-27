package backend.academy.labirinth.labirinth.generator;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.util.RandomShell;

@SuppressWarnings("MagicNumber")
public interface Generator {

    int COUNT_SIDES = 4;
    int INDENT = 3;

    Maze generate(int height, int width);

    Maze generate(int height, int width, Coordinate input, Coordinate output);

    /**
     * метод размещает случайное начало лабиринта на одной из границ
     */
    default Coordinate getRandomInputCoordinate(int height, int width, RandomShell random) {
        int side = random.get(COUNT_SIDES);
        return switch (side) {
            case 0 -> new Coordinate(random.get(width - INDENT), 0);
            case 1 -> new Coordinate(width - INDENT, random.get(height - INDENT));
            case 2 -> new Coordinate(random.get(width - INDENT), height - INDENT);
            case 3 -> new Coordinate(0, random.get(height - INDENT));
            default -> null;
        };
    }
}
