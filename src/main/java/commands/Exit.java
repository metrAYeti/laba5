package commands;

import Collection.CollectionDragons;
import Collection.Console;
import Collection.FileManager;
import exception.WrongAmountCommandsException;

public class Exit implements Command {
    FileManager fileManager = new FileManager("Lab5");
    CollectionDragons collectionDragons;
    public Exit() {

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
    public void execute(String argument) {
        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            Console.println("Good bye, my dear)");
            Console.exit();
        } catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
