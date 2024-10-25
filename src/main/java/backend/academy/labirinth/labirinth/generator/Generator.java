package backend.academy.labirinth.labirinth.generator;

import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import lombok.Getter;

public interface Generator {

    @Getter enum Side {

        NORTH_SIDE(0),
        EAST_SIDE(1),
        SOUTH_SIDE(2),
        WEST_SIDE(3);

        private int value;

        Side(int value) {
            this.value = value;
        }
    }

    Maze generate(int height, int width);

    Maze generate(int height, int width, Coordinate input, Coordinate output);
}
