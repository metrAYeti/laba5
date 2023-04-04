package commands;

import Collection.CollectionDragons;
import Collection.Console;
import exception.WrongAmountCommandsException;

public class InfoCommand implements Command{
    private CollectionDragons collectionDragons;
    public InfoCommand(){}
    public InfoCommand(CollectionDragons collectionDragons) {
        this.collectionDragons = collectionDragons;
    }

    public void info() {
        System.out.println(collectionDragons.info());
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "information about collection";
    }

    @Override
    public void execute(String argument) {
        try {
            if(!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            Console.println("Type of collection: Organization");
            Console.println("Count elements in collection: " + collectionDragons.getCollectionSize());
            if (collectionDragons.getCollectionSize() != 0) {
                Console.println("Inicialization date: " + collectionDragons.getFirstElement());
            }
        }catch (WrongAmountCommandsException ex){
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
