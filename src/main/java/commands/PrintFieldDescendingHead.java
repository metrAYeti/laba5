package commands;

import Collection.CollectionDragons;
import Collection.Console;
import data.Dragon;
import data.DragonHead;
import exception.WrongAmountCommandsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintFieldDescendingHead implements Command {
    private CollectionDragons collectionDragons;
    public PrintFieldDescendingHead(){}

    public PrintFieldDescendingHead(CollectionDragons dragon) {
        this.collectionDragons = dragon;
    }

    public void print_field_descending_head() {
        List<DragonHead> dragonHeads = new ArrayList<>();
        for (Dragon dragons : collectionDragons.getDragons()) {
            dragonHeads.add(dragons.getHead());
        }
        Collections.sort(dragonHeads);
        System.out.println(dragonHeads);
    }

    @Override
    public String getName() {
        return "print_field_descending_head";
    }

    @Override
    public String getDescription() {
        return "print_field_descending_head";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            List<DragonHead> dragonHeads = new ArrayList<>();
            for (Dragon dragons : collectionDragons.getDragons()) {
                dragonHeads.add(dragons.getHead());
            }
            Collections.sort(dragonHeads);
            Console.println(dragonHeads);
        } catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }

    }
}
