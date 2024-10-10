package backend.academy.labirinth.labirinth;

import java.util.ArrayList;
import java.util.List;

public class Step {
    public int numNeigh;
    public List<Coordinate> coord;

    public Step(int numNeigh) {
        this.numNeigh = numNeigh;
        coord = new ArrayList<Coordinate>();
    }
}
