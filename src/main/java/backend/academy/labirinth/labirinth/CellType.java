package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.config.Config;
import lombok.Getter;

public enum CellType {

    WALL(Config.WALL_STRING, 1000),
    PASSAGE(Config.PASS_STRING, 10),
    WAY(Config.WAY_STRING, 10),
    INPUT(Config.INPUT_STRING, 10),
    OUTPUT(Config.OUTPUT_STRING, 10),
    COIN(Config.COIN_STRING, 5),
    SWAMP(Config.SWAMP_STRING, 50);

    @Getter
    private String value;
    @Getter
    private int weight;

    CellType(String value, int weight) {
        this.value = value;
        this.weight = weight;
    }

}
