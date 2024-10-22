package backend.academy.labirinth.util.juice;



import backend.academy.labirinth.labirinth.CellFactory;
import backend.academy.labirinth.labirinth.DFSSolver.DFSSolver;
import backend.academy.labirinth.labirinth.ExtendedCellsFactory;
import backend.academy.labirinth.labirinth.Generator;
import backend.academy.labirinth.labirinth.RecursiveBacktrackerGenerator.RecursiveBacktrackerGenerator;
import backend.academy.labirinth.labirinth.growingThreeGenerator.GrowingThreeMazeGenerator;
import backend.academy.labirinth.labirinth.Solver;
import backend.academy.labirinth.service.OutputService;
import backend.academy.labirinth.service.impl.OutputServiceImpl;
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
        //bind(Generator.class).to(GrowingThreeMazeGenerator.class).in(Scopes.SINGLETON);
        bind(Generator.class).to(RecursiveBacktrackerGenerator.class).in(Scopes.SINGLETON);
        bind(Solver.class).to(DFSSolver.class).in(Scopes.SINGLETON);
        bind(CellFactory.class).to(ExtendedCellsFactory.class).in(Scopes.SINGLETON);
    }
}
