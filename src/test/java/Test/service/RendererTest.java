package Test.service;

import backend.academy.labirinth.config.Config;
import backend.academy.labirinth.labirinth.CellType;
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

    private static CellType[][] testCells  = new CellType[][] {
        new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
            (CellType.WALL), (CellType.WALL)},
            new CellType[] {(CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL)},
            new CellType[] {(CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL)},
            new CellType[] {(CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL)},
            new CellType[] {(CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL)},
            new CellType[] {(CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL)},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL)}
    };


    @InjectMocks
    private RendererImpl renderer;

    @Test
    public void codeGenerator() {


        String res =
            "new CellType[][]{new CellType[]{(CellType.WALL),(CellType.WALL),(CellType.WALL),(CellType.WALL),(CellType.WALL),},new CellType[]{(CellType.WALL),(CellType.PASSAGE),(CellType.PASSAGE),(CellType.PASSAGE),(CellType.WALL),},new CellType[]{(CellType.WALL),(CellType.PASSAGE),(CellType.WALL),(CellType.PASSAGE),(CellType.WALL),},new CellType[]{(CellType.WALL),(CellType.PASSAGE),(CellType.WALL),(CellType.PASSAGE),(CellType.WALL),},new CellType[]{(CellType.WALL),(CellType.PASSAGE),(CellType.WALL),(CellType.PASSAGE),(CellType.WALL),},new CellType[]{(CellType.WALL),(CellType.PASSAGE),(CellType.PASSAGE),(CellType.PASSAGE),(CellType.WALL),},new CellType[]{(CellType.WALL),(CellType.WALL),(CellType.WALL),(CellType.WALL),(CellType.WALL),}}";
        assertEquals(res, renderer.getCodeMaze(new Maze(testCells, null, null)));
    }

    @Test
    public void render() {

        //код автматисески сгененрированный codeGenerator
        CellType[][] cells = new CellType[][] {
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.COIN), (CellType.WALL),
                (CellType.INPUT), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.COIN), (CellType.COIN), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.COIN),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.COIN), (CellType.PASSAGE), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.COIN), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.COIN), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.COIN), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.PASSAGE),
                (CellType.COIN), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.COIN), (CellType.COIN), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
                (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.COIN),
                (CellType.PASSAGE), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.COIN), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.COIN), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.COIN), (CellType.SWAMP), (CellType.PASSAGE),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.COIN), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.COIN), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.COIN),
                (CellType.WALL), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.COIN), (CellType.COIN), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.SWAMP), (CellType.WALL),
                (CellType.COIN), (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.WALL), (CellType.SWAMP), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.COIN),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.COIN),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.OUTPUT),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.COIN),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.COIN), (CellType.WALL), (CellType.PASSAGE),
                (CellType.WALL), (CellType.SWAMP), (CellType.WALL),
                (CellType.SWAMP), (CellType.WALL), (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.SWAMP),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.WALL),
                (CellType.PASSAGE), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.WALL), (CellType.PASSAGE), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.PASSAGE),
                (CellType.COIN), (CellType.PASSAGE), (CellType.WALL),
                (CellType.SWAMP), (CellType.SWAMP), (CellType.SWAMP),
                (CellType.COIN), (CellType.SWAMP), (CellType.PASSAGE),
                (CellType.PASSAGE), (CellType.WALL), (CellType.SWAMP),
                (CellType.COIN), (CellType.SWAMP), (CellType.WALL),
                (CellType.WALL),},
            new CellType[] {(CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL), (CellType.WALL), (CellType.WALL),
                (CellType.WALL),}};

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
