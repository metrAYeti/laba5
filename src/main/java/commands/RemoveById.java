package commands;

import Collection.CollectionDragons;
import Collection.Console;
import data.Dragon;
import exception.WrongAmountCommandsException;

import java.util.Iterator;
import java.util.Objects;

public class RemoveById implements Command{
    private CollectionDragons collectionDragons;

    public RemoveById( ){}
    public RemoveById(CollectionDragons dragon){
        this.collectionDragons = dragon;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute(String argument) {
        try {
            if(collectionDragons.getCollectionSize()!=0) {
                Long id = Long.parseLong(argument);
                if(id>0) {
                    if (collectionDragons.getById(id) == null) throw new WrongAmountCommandsException();
                    Iterator<Dragon> iter = collectionDragons.getIterator();
                    int i = 0;
                    while (iter.hasNext()) {
                        if (Objects.equals(iter.next().getId(), id)) {
                            iter.remove();
                            i += 1;
                            Console.println("Element deleted successfully");
                        }
                    }
                    if (i != 1) {
                        Console.println("This id is not in the collection");
                    }
                }else{
                    Console.println("id must be greater than 0");
                }
            }else{
                Console.println("There are no elements in the collection");
            }
        } catch (NumberFormatException ex) {
            Console.println("id must be represented by a number, enter the correct value");
        } catch (WrongAmountCommandsException ex) {
            Console.println("organization with this id was not found");
        }

    }
}
