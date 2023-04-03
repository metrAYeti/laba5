package commands;

import Collection.CollectionDragons;
import Collection.Console;
import exception.WrongAmountCommandsException;

public class ClearCommand implements Command {
    public void clear() {
        CollectionDragons.getDragons().clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear collection";
    }

    @Override
    public void execute(String argument) {
        try {
            if(CollectionDragons.getDragons().size()!=0) {
                if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
                CollectionDragons.getDragons().clear();
                Console.println("Collection сleared");
            }else{
                Console.println("There are no elements in the collection");
            }
        }catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
