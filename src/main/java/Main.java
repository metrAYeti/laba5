import Collection.CollectionDragons;
import Collection.CommandManager;
import Collection.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final String envVariable = "lab5";
        FileManager fileManager = new FileManager(envVariable);
        CollectionDragons collectionDragons = new CollectionDragons(fileManager);
        List<String> saveFileNameForExecute = new ArrayList<>();
        CommandManager commandsProcessing = new CommandManager(collectionDragons,fileManager,saveFileNameForExecute);
        commandsProcessing.commandManager();
    }
}
