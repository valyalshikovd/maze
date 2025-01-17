package backend.academy.labirinth.labirinth;

import java.util.List;
import lombok.Getter;

@Getter
public class Shift {
    private final int x;
    private final int y;


    public static final List<Shift> DIRECTION = List.of(
        new Shift(0, 1),
        new Shift(1, 0),
        new Shift(0, -1),
        new Shift(-1, 0)
    );


    public Shift(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate getShiftedCoordinate(Coordinate coordinate) {
        return new Coordinate(coordinate.x() + x, coordinate.y() + y);
    }
}
