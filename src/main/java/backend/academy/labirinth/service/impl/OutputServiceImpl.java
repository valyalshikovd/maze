package backend.academy.labirinth.service.impl;

import backend.academy.labirinth.config.Config;
import backend.academy.labirinth.exception.ConsolInputException;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.service.ConsoleInputService;
import backend.academy.labirinth.service.mazeRenderer.Renderer;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.service.output.PrintWriteShell;
import com.google.inject.Inject;
import java.util.List;

public class OutputServiceImpl implements OutputService {

    private final Renderer renderer;
    private final ConsoleInputService consoleInputService;


    @Inject
    public OutputServiceImpl(Renderer renderer, ConsoleInputService consoleInputService) {
        this.renderer = renderer;
        this.consoleInputService = consoleInputService;
    }

    @Override
    public void drawMaze(Maze maze) {
        PrintWriteShell.println(renderer.render(maze));
    }

    @Override
    public void drawMaze(Maze maze, List<Coordinate> path) {
        PrintWriteShell.println(renderer.render(maze, path));
    }

    public void drawCode(Maze maze) {
        PrintWriteShell.println(renderer.getCodeMaze(maze));
    }

    /**
     * надпись с https://fsymbols.com/ru/generatory/
     */
    @Override
    public void drawWelcoming() {
        PrintWriteShell.println(
                "██╗░░░░░░█████╗░██████╗░██╗░░░██╗██████╗░██╗███╗░░██╗████████╗██╗░░██╗░██████╗\n" +
                "██║░░░░░██╔══██╗██╔══██╗╚██╗░██╔╝██╔══██╗██║████╗░██║╚══██╔══╝██║░░██║██╔════╝\n" +
                "██║░░░░░███████║██████╦╝░╚████╔╝░██████╔╝██║██╔██╗██║░░░██║░░░███████║╚█████╗░\n" +
                "██║░░░░░██╔══██║██╔══██╗░░╚██╔╝░░██╔══██╗██║██║╚████║░░░██║░░░██╔══██║░╚═══██╗\n" +
                "███████╗██║░░██║██████╦╝░░░██║░░░██║░░██║██║██║░╚███║░░░██║░░░██║░░██║██████╔╝\n" +
                "╚══════╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝╚═╝░░╚══╝░░░╚═╝░░░╚═╝░░╚═╝╚═════╝░"
        );
    }

    @Override
    public void drawDescription() {
        PrintWriteShell.println("Вы можете сгенерировать и решить созданные лабиринты. \n" +
            "Реализованы следующие алгоритмы генерации: \n" +
            "1. Growing Three Generator \n" +
            "2. Recursive Back Tracker Generator (Step by step)\n" +
            "Эти алгоритмы, по умолчанию, создают лабиринты без циклов, но при желании можно добавить циклы, в этом случае доступен только алгоритм Дейкстры  \n" +
            "По умолчанию система поверхностей отсутствует, но при желании можно включить ее при генерации:  \n" +
            "Реализованы следующие алгоритмы поиска пути: \n" +
            "1. DFS solver (первый найденный путь) \n" +
            "2. Dijkstra's Algorithm (кратчайший путь)");
    }

    @Override
    public void drawEnteringMaze(Maze maze) {

    }

    @Override
    public void drawElectingConfig() {

        int numAlg =  getNum();


    }

    private int getNum(){
        try {
            PrintWriteShell.println(
                "Введите номер алгоритма генерации: "
            );
            int numAlg = consoleInputService.getInt();

            if(numAlg < 0 || numAlg > Config.NUMBER_OF_GENERATOR) {
                throw new ConsolInputException("incorrect alg num");
            }

            return numAlg;

        }catch (ConsolInputException e){
            return getNum();
        }
    }
}
