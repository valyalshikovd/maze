package backend.academy.labirinth.util.juice;



import backend.academy.labirinth.labirinth.generator.cellFactory.CellFactory;
import backend.academy.labirinth.labirinth.solver.DFSSolver.DFSSolver;
import backend.academy.labirinth.labirinth.generator.cellFactory.ExtendedCellsFactory;
import backend.academy.labirinth.labirinth.generator.Generator;
import backend.academy.labirinth.labirinth.generator.RecursiveBacktrackerGenerator.RecursiveBacktrackerGenerator;
import backend.academy.labirinth.labirinth.solver.Solver;
import backend.academy.labirinth.service.ConsoleInputService;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.service.impl.ConsoleInputServiceImpl;
import backend.academy.labirinth.service.impl.OutputServiceImpl;
import backend.academy.labirinth.service.input.BufferedReaderShell;
import backend.academy.labirinth.service.input.BufferedReaderShellImpl;
import backend.academy.labirinth.service.mazeRenderer.Renderer;
import backend.academy.labirinth.service.mazeRenderer.impl.RendererImpl;
import backend.academy.labirinth.util.RandomShell;
import backend.academy.labirinth.util.RandomShellImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;


public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RandomShell.class).to(RandomShellImpl.class).in(Scopes.SINGLETON);
        bind(Renderer.class).to(RendererImpl.class).in(Scopes.SINGLETON);
        bind(OutputService.class).to(OutputServiceImpl.class).in(Scopes.SINGLETON);
        bind(ConsoleInputService.class).to(ConsoleInputServiceImpl.class).in(Scopes.SINGLETON);
        //bind(Generator.class).to(GrowingThreeMazeGenerator.class).in(Scopes.SINGLETON);
        bind(BufferedReaderShell.class).to(BufferedReaderShellImpl.class).in(Scopes.SINGLETON);
        bind(Generator.class).to(RecursiveBacktrackerGenerator.class).in(Scopes.SINGLETON);
        bind(Solver.class).to(DFSSolver.class).in(Scopes.SINGLETON);
        bind(CellFactory.class).to(ExtendedCellsFactory.class).in(Scopes.SINGLETON);

    }
}
