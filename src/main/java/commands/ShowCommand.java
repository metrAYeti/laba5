package commands;

import Collection.CollectionDragons;
import Collection.Console;
import exception.NotElementOfCollection;
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
            if (collectionDragons.getCollectionSize() < 1) throw new NotElementOfCollection();
        } catch (WrongAmountCommandsException ex) {
            Console.printerror("incorrect command usage, usage example: " + getName());
        }catch (NotElementOfCollection e) {
            Console.printerror("Collection is empty");
        }

    }
}
