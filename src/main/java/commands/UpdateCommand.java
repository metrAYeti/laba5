package commands;

import Collection.CollectionDragons;
import Collection.Console;
import data.Dragon;
import exception.WrongAmountCommandsException;

import java.util.*;

public class UpdateCommand implements Command {
    private CollectionDragons collectionDragons;
    public UpdateCommand(){}
    public UpdateCommand(CollectionDragons dragon) {
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
            Iterator<Dragon> iter = collectionDragons.getIterator();
            if (collectionDragons.getCollectionSize() != 0) {
                Long id = Long.parseLong(argument);
                if(id>0) {
                    if (collectionDragons.getById(id) == null) throw new WrongAmountCommandsException();
                    while (iter.hasNext()) {
                        Dragon i = iter.next();
                        if (Objects.equals(i.getId(), id)) {
                            i.setId(collectionDragons.generate_id());
                            Console.println("element id updated successfully");
                        }
                    }
                }else{
                    Console.println("id must be greater than 0");
                }
            } else {
                Console.println("There are no items in the collection");
            }
        }catch(NumberFormatException ex){
            Console.println("id must be represented by a number, enter the correct value");
        }catch(WrongAmountCommandsException ex){
            Console.println("organization with this id was not found");
        }
    }
}
