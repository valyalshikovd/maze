package backend.academy.labirinth.service.input;

import backend.academy.labirinth.config.Config;
import backend.academy.labirinth.exception.ConsolInputException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("MultipleStringLiterals")
public class BufferedReaderShellImpl implements BufferedReaderShell {

    private BufferedReader reader;

    @SuppressFBWarnings("LEST_LOST_EXCEPTION_STACK_TRACE")
    @Override
    public String getString() {
        checkScanner();
        try {
            return reader.readLine();
        } catch (Exception e) {
            throw new ConsolInputException("Ошибка ввода");
        }
    }

    @SuppressFBWarnings("LEST_LOST_EXCEPTION_STACK_TRACE")
    @Override
    public int getInt() {
        checkScanner();
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            throw new ConsolInputException("Ошибка ввода");
        }
    }

    private void checkScanner() {
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(Config.IN, StandardCharsets.UTF_8));
        }
    }
}
