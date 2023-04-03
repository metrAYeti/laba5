package commands;

import Collection.CollectionDragons;
import data.Coordinates;
import data.Dragon;

import java.util.Iterator;
import java.util.Scanner;

public class MaxByCoordinates {

    public void max_by_coordinates() {
        Iterator<Dragon> i = CollectionDragons.getDragons().iterator();
        Dragon maxCordDragon = null;
        double value = 0;
        while (i.hasNext()) {
            Dragon dragon = i.next();
            if (value < (double) dragon.getCoordinates().getY() + dragon.getCoordinates().getX()) {
                value = (double) dragon.getCoordinates().getY() + dragon.getCoordinates().getX();
                maxCordDragon = dragon;
            }
        }
        System.out.println(maxCordDragon);
    }
}