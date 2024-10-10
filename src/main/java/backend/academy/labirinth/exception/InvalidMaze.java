package backend.academy.labirinth.exception;

public class InvalidMaze extends RuntimeException {
    public InvalidMaze(String message) {
        super(message);
    }
}
