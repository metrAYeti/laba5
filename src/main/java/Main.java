import Collection.CollectionDragons;
import Collection.FileManager;
import commands.CommandProcessing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String envVariable = "lab5";
        FileManager fileManager = new FileManager(envVariable);
        CollectionDragons collectionDragons = new CollectionDragons(fileManager);
        //CollectionDragons.getDragons();
        new CommandProcessing().switchCommands();
    }
}
