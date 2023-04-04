package commands;

import Collection.CollectionDragons;
import Collection.Console;
import data.Dragon;
import exception.WrongAmountCommandsException;

public class ClearCommand implements Command {
    private CollectionDragons dragon;
    public ClearCommand(){}
    public ClearCommand(CollectionDragons dragon){
        this.dragon = dragon;
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
            if(dragon.getCollectionSize()!=0) {
                if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
                dragon.clear();
                Console.println("Collection сleared");
            }else{
                Console.println("There are no elements in the collection");
            }
        }catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
