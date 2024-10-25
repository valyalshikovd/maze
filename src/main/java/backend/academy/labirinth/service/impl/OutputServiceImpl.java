package backend.academy.labirinth.service.impl;

import backend.academy.labirinth.config.Config;
import backend.academy.labirinth.exception.ConsolInputException;
import backend.academy.labirinth.labirinth.Coordinate;
import backend.academy.labirinth.labirinth.Environment;
import backend.academy.labirinth.labirinth.EnvironmentStepByStep;
import backend.academy.labirinth.labirinth.Maze;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.RecursiveBacktrackerGenerator.RecursiveBacktrackerGenerator;
import backend.academy.labirinth.labirinth.generator.growingThreeGenerator.GrowingThreeMazeGenerator;
import backend.academy.labirinth.labirinth.solver.DFSSolver.DFSSolver;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.labirinth.solver.dijkstrasAlgorithmSolver.DijkstrasAlgorithmSolver;
import backend.academy.labirinth.service.ConsoleInputService;
import backend.academy.labirinth.service.mazeRenderer.Renderer;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.service.output.PrintWriteShell;
import backend.academy.labirinth.util.juice.ObjectFabric;
import com.google.inject.Inject;
import org.apache.commons.math3.util.Pair;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("MultipleStringLiterals")
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
    public Environment drawElectingConfig() {

        int numAlg =  getNumGen();
        Generator generator = null;
        boolean stepByStepGenerator = false;
        switch (numAlg) {
            case 1 : {
                generator = ObjectFabric.getObject(GrowingThreeMazeGenerator.class);
                break;
            }
            case 2 : {
                stepByStepGenerator = enteringStepByStepGenerator();
                generator = ObjectFabric.getObject(RecursiveBacktrackerGenerator.class);
                break;
            }
            default : {}
        };

        boolean loopFlags = enteringLoops();


        boolean stepByStepSolver = false;

        Solver solver = null;
        if (loopFlags) {

            solver = ObjectFabric.getObject(DijkstrasAlgorithmSolver.class);

        } else {
            switch (getNumSolver()){
                case 1:
                {
                    stepByStepSolver = enteringStepByStepSolver();
                    solver = ObjectFabric.getObject(DFSSolver.class);
                    break;
                }
                case 2:
                {
                    solver = ObjectFabric.getObject(DijkstrasAlgorithmSolver.class);
                    break;
                }
            }
        }

        if(stepByStepSolver || stepByStepGenerator){

            return new EnvironmentStepByStep(generator, solver, loopFlags, stepByStepSolver, stepByStepGenerator);

        }

        return new Environment(generator, solver, loopFlags);

    }

    @Override
    public int getCountSteps() {
        try {
            PrintWriteShell.println(
                "Введите количество шагов: \n \"1\" - 1 \n \"2\" - 10 \n \"3\" - 100 "
            );
            int res = consoleInputService.getInt();
            if (res != 1 && res != 2 && res != 3) {
                throw new ConsolInputException("Invalid entering");
            }
            return switch (res) {
                case 1 -> 1;
                case 2 -> 10;
                case 3 -> 100;
                default -> 0;
            };
        } catch (ConsolInputException e) {
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return getCountSteps();
        }
    }

    @Override
    public Pair<Integer, Integer> getMazeSize() {
        try {
            PrintWriteShell.println(
                "Введите высоту лабиринта: "
            );
            int y = consoleInputService.getInt();

            PrintWriteShell.println(
                "Введите ширина лабиринта: "
            );
            int x = consoleInputService.getInt();

            return new Pair<>(x, y);

        }catch (ConsolInputException e){
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return getMazeSize();
        }
    }

    @Override
    public void drawRawText(String text) {
        PrintWriteShell.println(text);
    }

    @Override
    public boolean drawEnteringContinue() {
        try {
            PrintWriteShell.println(
                "Желаете ли продолжить? (\"+\" - если да, иначе любой другой символ): "
            );

            String s = consoleInputService.getString();

            return s.equals("+");

        } catch (Exception e) {
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return drawEnteringContinue();
        }

    }

    @Override
    public boolean drawEnteringRequestNewEnvironment() {
        try {
            PrintWriteShell.println(
                "Желаете ли вы оставить текущую конфигурацию (\"+\" - если да, иначе любой другой символ): "
            );
            String s = consoleInputService.getString();

            return Objects.equals(s, "+");

        } catch (ConsolInputException e) {
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return drawEnteringRequestNewEnvironment();
        }
    }

    @Override
    public boolean drawEnteringRequestCoordinate() {
        try {
            PrintWriteShell.println(
                "Желаете ли вы в ручную ввести координаты входа/выхода (\"+\" - если да, иначе любой другой символ): "
            );
            String s = consoleInputService.getString();

            return Objects.equals(s, "+");

        }catch (ConsolInputException e){
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return enteringStepByStepSolver();
        }
    }

    @Override
    public Coordinate drawEnteringCoordinate() {
        try {
            PrintWriteShell.println(
                "Введите координату x: "
            );
            int y = consoleInputService.getInt();

            PrintWriteShell.println(
                "Введите координату y: "
            );
            int x = consoleInputService.getInt();

            return new Coordinate(x, y);

        } catch (ConsolInputException e) {
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return drawEnteringCoordinate();
        }
    }

    @Override
    public void drawStepDescription() {
        PrintWriteShell.println(Config.WAY_STRING + " - вход/найденный путь, " + Config.OUTPUT_STRING + " - выход, " + Config.COIN_STRING + " - монетка(ускоряет), " + Config.SWAMP_STRING + " - болото(замедляет)");
    }

    private int getNumGen(){
        try {
            PrintWriteShell.println(
                "Введите номер алгоритма генерации: "
            );
            int numAlg = consoleInputService.getInt();

            if (numAlg < 0 || numAlg > Config.NUMBER_OF_GENERATOR) {
                throw new ConsolInputException("incorrect alg num");
            }

            return numAlg;

        }catch (ConsolInputException e) {
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return getNumGen();
        }
    }

    private boolean enteringLoops(){
        try {
            PrintWriteShell.println(
                "Желаете ли добавить циклы в лабиринт (\"+\" - если да, иначе любой другой символ): "
            );
            String s = consoleInputService.getString();

            if (Objects.equals(s, "+")) {
                PrintWriteShell.println(
                    "Предупреждуние: В таком случае для нахождения кратчайшего пути имеет смысл только алгоритм Дейксты."
                );
                return true;
            }
            return false;

        }catch (Exception e){
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return enteringLoops();
        }
    }

    private int getNumSolver(){
        try {
            PrintWriteShell.println(
                "Введите номер алгоритма поиска решения: "
            );
            int numAlg = consoleInputService.getInt();

            if (numAlg < 0 || numAlg > Config.NUMBER_OF_GENERATOR) {
                throw new ConsolInputException("incorrect alg num");
            }

            return numAlg;

        }catch (ConsolInputException e) {
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return getNumSolver();
        }
    }

    private boolean enteringStepByStepGenerator(){
        try {
            PrintWriteShell.println(
                "Желаете ли вы применить пошаговый генератор (\"+\" - если да, иначе любой другой символ): "
            );
            String s = consoleInputService.getString();

            return Objects.equals(s, "+");

        }catch (ConsolInputException e){
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return enteringStepByStepGenerator();
        }
    }

    private boolean enteringStepByStepSolver(){
        try {
            PrintWriteShell.println(
                "Желаете ли вы применить пошаговый solver (\"+\" - если да, иначе любой другой символ): "
            );
            String s = consoleInputService.getString();

            return Objects.equals(s, "+");

        }catch (ConsolInputException e){
            PrintWriteShell.println(
                "Ошибка ввода попробуйте снова. "
            );
            return enteringStepByStepSolver();
        }
    }
}
