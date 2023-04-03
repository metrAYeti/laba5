package commands;

import Collection.CollectionDragons;
import data.Dragon;

import java.util.Iterator;
import java.util.Scanner;

public class AddIfMax {
     /**
      *
      * @return
      */
     public long compareWeight () {
          Iterator<Dragon> i = CollectionDragons.getDragons().iterator();
          long maxWeight = 0;
          while (i.hasNext()) {
               Dragon dragon = i.next();
               if (dragon.getWeight() > maxWeight) {
                    maxWeight = dragon.getWeight();
               }
          }
          return maxWeight;
     }

     /**
      *
      */
     public void adderIfMax() {
          Dragon dragon = new AddElement().adder();
          if (dragon.getWeight() > compareWeight()) {
               CollectionDragons.getDragons().add(dragon);
               System.out.println("Элемент имеет максимальное значение, он будет добавлен в коллекцию");
          } else System.out.println("Элемент не имеет максимальное значение, он не будет добавлен в коллекцию");
     }
}
