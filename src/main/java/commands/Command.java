package commands;

import java.io.IOException;

public interface Command {

    String getName();

    String getDescription();

    void execute(String argument) throws IOException;
}
