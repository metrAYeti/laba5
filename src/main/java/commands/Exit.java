package commands;

import Collection.CollectionDragons;
import Collection.Console;
import Collection.FileManager;
import com.google.gson.Gson;
import exception.WrongAmountCommandsException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exit implements Command {
    FileManager fileManager;
    CollectionDragons collectionDragons;

    public Exit() {}

    public Exit(CollectionDragons collectionDragons, FileManager fileManager) {
        this.collectionDragons = collectionDragons;
        this.fileManager = fileManager;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Terminates the application (without saving collection)";
    }

    @Override
    public void execute(String argument) throws IOException {

        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            Console.println("Good bye, my dear)");
//            fileManager.writeCollection(collectionDragons.getDragons());
            fileManager.writeCollection(collectionDragons.getDragons(), "dragonchik.json");
            Console.exit();

        } catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
