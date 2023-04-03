import Collection.CollectionDragons;
import commands.CommandProcessing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CollectionDragons.getDragons();
        new CommandProcessing().switchCommands();
    }
}
