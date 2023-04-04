package commands;

import Collection.CollectionDragons;
import Collection.Console;
import exception.WrongAmountCommandsException;

public class ShowCommand implements Command{
    private CollectionDragons collectionDragons;
    public ShowCommand(){}
    public ShowCommand(CollectionDragons dragon){
        this.collectionDragons = dragon;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show collection";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            collectionDragons.show();
        } catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }

    }
}
