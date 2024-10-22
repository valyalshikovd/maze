package backend.academy.labirinth.labirinth;

public interface CellFactory {

    public Cell getPassageCell();
    public Cell getOutput();
    public Cell getInput();
    public Cell getWall();
}
