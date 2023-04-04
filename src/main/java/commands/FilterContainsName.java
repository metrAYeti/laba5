package commands;

import Collection.CollectionDragons;
import data.Dragon;

import java.util.Iterator;
import java.util.Scanner;

public class FilterContainsName implements Command {
    private CollectionDragons collectionDragons;
    public FilterContainsName(){}

    public FilterContainsName(CollectionDragons dragon){
        this.collectionDragons = dragon;
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

    @Override
    public String getDescription() {
        return "filter collection of name";
    }

    @Override
    public void execute(String argument) {
        Iterator<Dragon> iter = collectionDragons.getIterator();
        while (iter.hasNext()) {
            Dragon dragon = iter.next();
            if (dragon.getName().contains(argument)) {
                System.out.println(dragon);
            }
        }


    }
}
