package commands;

import Collection.CollectionDragons;
import data.Dragon;

import java.util.Iterator;
import java.util.Scanner;

public class FilterContainsName {
    public void filter_contains_name() {
        System.out.println("Введите name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        Iterator<Dragon> i = CollectionDragons.getDragons().iterator();
        while (i.hasNext()) {
            Dragon dragon = i.next();
            if (dragon.getName().contains(name)) {
                System.out.println(dragon);
            }
        }
    }

}
