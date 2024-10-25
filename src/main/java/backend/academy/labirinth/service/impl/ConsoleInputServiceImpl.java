package backend.academy.labirinth.service.impl;


import backend.academy.labirinth.service.ConsoleInputService;
import backend.academy.labirinth.service.input.BufferedReaderShell;
import com.google.inject.Inject;


@SuppressWarnings({"MultipleStringLiterals"})
public class ConsoleInputServiceImpl implements ConsoleInputService {

    BufferedReaderShell readerShell;

    @Inject
    public ConsoleInputServiceImpl(BufferedReaderShell readerShell) {
        this.readerShell = readerShell;
    }

    @Override
    public int getInt() {
        return readerShell.getInt();
    }

    @Override
    public String getString() {
        return  readerShell.getString();
    }
}
