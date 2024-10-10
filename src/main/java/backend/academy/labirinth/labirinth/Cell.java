package backend.academy.labirinth.labirinth;

import backend.academy.labirinth.config.Config;
import lombok.Getter;

public record Cell( Type type) {
    public enum Type {
        WALL(Config.WALL_STRING),
        PASSAGE(Config.PASS_STRING),
        WAY(Config.WAY_STRING),
        INPUT(Config.INPUT_STRING),
        OUTPUT(Config.OUTPUT_STRING);

        @Getter
        private String value;

        Type(String value) {
            this.value = value;
        }
    }
}
