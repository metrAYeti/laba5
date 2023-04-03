package commands;

import Collection.CollectionDragons;
import data.Dragon;
import data.DragonHead;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintFieldDescendingHead {
    public void print_field_descending_head() {
        List<DragonHead> dragonHeads = new ArrayList<>();
        for (Dragon dragon : CollectionDragons.getDragons()) {
            dragonHeads.add(dragon.getHead());
        }
        Collections.sort(dragonHeads);
        System.out.println(dragonHeads);
    }
}
