package Test.service;

import backend.academy.labirinth.config.Config;
import backend.academy.labirinth.labirinth.Cell;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.service.mazeRenderer.impl.RendererImpl;
import org.apache.commons.digester.annotations.rules.SetTop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RendererTest {

    private static Cell[][] testCells  = new Cell[][] {
        new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
            new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL)},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)}
    };


    @InjectMocks
    private RendererImpl renderer;

    @Test
    public void codeGenerator() {


        String res =
            "new Cell[][]{new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),},new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),},new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),},new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),},new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),},new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.PASSAGE),new Cell(Cell.Type.WALL),},new Cell[]{new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),new Cell(Cell.Type.WALL),}}";
        assertEquals(res, renderer.getCodeMaze(new Maze(testCells, null, null)));
    }

    @Test
    public void render() {

        //код автматисески сгененрированный codeGenerator
        Cell[][] cells = new Cell[][] {
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.INPUT), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.OUTPUT),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.COIN),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.PASSAGE),
                new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.WALL), new Cell(Cell.Type.SWAMP),
                new Cell(Cell.Type.COIN), new Cell(Cell.Type.SWAMP), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),},
            new Cell[] {new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL),
                new Cell(Cell.Type.WALL),}};

        Maze maze = new Maze(cells, null, null);
        String res = renderer.render(maze);

        assertEquals(16368, res.length());

        String exepted =
            Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.PASS_STRING + Config.PASS_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.PASS_STRING + Config.PASS_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING +
                "\n";

        assertEquals(exepted, renderer.render(new Maze(testCells, null, null)));
    }

    @Test
    public void testRenderWithSolve(){

        Maze maze = new Maze(testCells, null, null);
        List<Coordinate> way = List.of(new Coordinate(2, 1), new Coordinate(1, 1),
            new Coordinate(1, 2), new Coordinate(1, 3), new Coordinate(1, 4),
               new Coordinate(1, 5), new Coordinate(2, 5));


        String exepted =
            Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.WAY_STRING + Config.WAY_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.WAY_STRING + Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.WAY_STRING + Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.WAY_STRING + Config.WALL_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.WAY_STRING + Config.WAY_STRING + Config.PASS_STRING + Config.WALL_STRING +
                "\n" +
                Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING + Config.WALL_STRING +
                "\n";

        assertEquals(exepted, renderer.render(maze, way));
    }

}
