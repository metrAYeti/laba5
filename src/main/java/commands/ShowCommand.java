package commands;

import Collection.CollectionDragons;

public class ShowCommand {
    public void show() {
        if(CollectionDragons.getDragons().size() == 0){
            System.out.println("Collection is empty");
        }
        else {
            System.out.println(CollectionDragons.getDragons());
        }
    }
}
