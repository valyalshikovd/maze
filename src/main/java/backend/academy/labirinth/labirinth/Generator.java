package backend.academy.labirinth.labirinth;

import lombok.Getter;

public interface Generator {

    @Getter enum Side{

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
    StepByStepGenerator getStepByStepGenerator(int height, int width);
//    Maze generate(int height, int width, Side sideInput);
//    Maze generate(int height, int width, Side sideInput, int coordInput);
//    Maze generate(int height, int width, Side sideInput, int coordInput, Side sideOutput);
//    Maze generate(int height, int width, Side sideInput, int coordInput, Side sideOutput, int coordOutput);
//    Maze generate(int height, int width, Side sideInput, Side sideOutput);
}
