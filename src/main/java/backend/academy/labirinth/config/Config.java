package backend.academy.labirinth.config;

import java.io.InputStream;
import java.io.PrintStream;


public final class Config {
    public static final PrintStream OUT = System.out;
    public static final InputStream IN = System.in;
    public static final String RESET = "\u001B[0m";
    public static final String WHITE_TEXT = "\u001B[37m";
    public static final String YELLOW_TEXT = "\u001B[33m";
    public static final String WHITE_BACKGROUND  = "\u001B[31m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String RED_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String DARK_GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001b[43m";
    public static final String PASS_STRING  = WHITE_BACKGROUND + WHITE_TEXT + "   " + RESET;
    public static final String WALL_STRING  = BLACK_BACKGROUND + WHITE_TEXT + "   " + RESET;
    public static final String WAY_STRING  = BLUE_BACKGROUND + WHITE_TEXT + "   " + RESET;
    public static final String INPUT_STRING  = GREEN_BACKGROUND + WHITE_TEXT + "   " + RESET;
    public static final String OUTPUT_STRING  = RED_BACKGROUND + WHITE_TEXT + "   " + RESET;
    public static final String SWAMP_STRING = DARK_GREEN_BACKGROUND + WHITE_TEXT + "   " + RESET;
    public static final String COIN_STRING = WHITE_BACKGROUND + YELLOW_TEXT + " ● " + RESET;

    //потому что не должен иметь конструктор
    private Config() {
    }
}
