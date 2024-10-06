package backend.academy.labirinth;

public interface Renderer {
    String render(Maze maze);
    String render(Maze maze, List<Coordinate> path);
}
