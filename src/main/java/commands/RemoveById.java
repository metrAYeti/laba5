package commands;

import Collection.CollectionDragons;
import data.Dragon;

import java.util.Iterator;
import java.util.Scanner;

public class RemoveById {
    public void remove_by_id() {

        System.out.println("Введите id:");
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();

        Iterator<Dragon> i = CollectionDragons.getDragons().iterator();
        boolean flag = false;
        while (i.hasNext()) {
            if (id.equals(i.next().getId())) {
                i.remove();
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Объект успешно удалён");
        } else {
            System.out.println("Такого объекта нет");
        }
    }
}
