package commands;

import Collection.*;
import data.Dragon;

import java.util.Scanner;
import java.util.Iterator;
import java.util.*;

public class RemoveGreaterCommand implements Command{
    private CollectionDragons collectionDragons;
    public RemoveGreaterCommand(){}
    public RemoveGreaterCommand(CollectionDragons dragon){
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
            if (collectionDragons.getCollectionSize() > 0) {
                double weight = Double.parseDouble(argument);
                int s = collectionDragons.getCollectionSize();
                Iterator<Dragon> iter = collectionDragons.getIterator();
                while (iter.hasNext()) {
                    Dragon i = iter.next();
                    if (i.getWeight() > weight) {
                        iter.remove();
                    }
                }
                if (collectionDragons.getCollectionSize() < s) {
                    Console.println("Element(s) successfully removed(s)");
                } else {
                    Console.println("All elements do not exceed the specified");
                }
            } else {
                Console.println("There are no elements in the collection");
            }
        }catch(NumberFormatException ex) {
            Console.println("annualTurnover must be represented by a float number, enter the correct value");
        }
    }
}

