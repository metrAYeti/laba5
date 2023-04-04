package commands;

import Collection.CollectionDragons;
import Collection.Console;
import exception.WrongAmountCommandsException;

import java.util.Iterator;

public class RemoveFirstCommand implements Command {
    private CollectionDragons collectionDragons;
    public RemoveFirstCommand(){}
    public RemoveFirstCommand(CollectionDragons dragon) {
        this.collectionDragons = dragon;
    }


    @Override
    public String getName() {
        return "remove_first";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            if (collectionDragons.getCollectionSize() != 0) {
                collectionDragons.removeFirst();
                Console.println("The first element was successfully removed!");
            } else {
                Console.println("There are no items in the collection!");
            }
        } catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
