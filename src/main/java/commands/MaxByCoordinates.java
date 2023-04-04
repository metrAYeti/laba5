package commands;

import Collection.CollectionDragons;
import Collection.Console;
import data.Coordinates;
import data.Dragon;
import exception.WrongAmountCommandsException;

import java.util.Iterator;
import java.util.Scanner;

public class MaxByCoordinates implements Command{

    private CollectionDragons collectionDragons;
    public MaxByCoordinates(){}
    public MaxByCoordinates(CollectionDragons dragon){
        this.collectionDragons = dragon;
    }

    @Override
    public String getName() {
        return "max_by_coordinates";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            Iterator<Dragon> i = collectionDragons.getIterator();
            Dragon maxCordDragon = null;
            double value = 0;
            while (i.hasNext()) {
                Dragon dragon = i.next();
                if (value < (double) dragon.getCoordinates().getY() + dragon.getCoordinates().getX()) {
                    value = (double) dragon.getCoordinates().getY() + dragon.getCoordinates().getX();
                    maxCordDragon = dragon;
                }
            }
            Console.println(maxCordDragon);
        } catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}