package commands;

import Collection.CollectionDragons;
import data.Dragon;

import java.util.*;

public class UpdateCommand {
    public void update() {

        Deque<Dragon> copy = CollectionDragons.getDragons();
        System.out.println("Введите id:");
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        int k =0;
        List<Dragon> dragons = new ArrayList<>(CollectionDragons.getDragons());
        for (Dragon dragon : dragons) {
            if (dragon.getId().equals(id)) {
                dragon.setId(Dragon.generate_id());
                k = k + 1;
            }
        }
        if (k == 0) System.out.println("Элемента с таким id нет");

       /* Iterator<Dragon> i = CollectionDragons.getDragons().iterator();
        boolean flag = false;
        while (i.hasNext()) {
            if (id == i.next().getId()) {
                System.out.println("Введите новый id");
                Dragon dragon = i;
                dragon.setId(scanner.nextLong());
                flag = true;
            }
        }
        if (flag){
            System.out.println("Объект успешно обновлен");
        }
        else {
            System.out.println("Такого объекта нет");
        }*/


    }
}
