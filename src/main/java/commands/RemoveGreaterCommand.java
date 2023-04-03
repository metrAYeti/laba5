package commands;

import Collection.CollectionDragons;
import data.Dragon;

import java.util.Scanner;
import java.util.Iterator;
import java.util.*;

public class RemoveGreaterCommand {

    public void removeGreater() {
        Deque<Dragon> copy_dragons = new ArrayDeque<>();
        System.out.println("Введите значение weight");
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        for (Dragon drag : CollectionDragons.getDragons()) {
            if (weight >= drag.getWeight()) copy_dragons.add(drag);
        }
        CollectionDragons.getDragons().clear();
        for(Dragon dragon: copy_dragons){
            CollectionDragons.getDragons().add(dragon);
        }
        System.out.println(CollectionDragons.getDragons());
    }
}

