package backend.academy.labirinth.exception;

public class InvalidCoordinate extends RuntimeException {
    public InvalidCoordinate(String message) {
        super(message);
    }
}
