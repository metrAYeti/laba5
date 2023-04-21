package commands;

import Collection.Asker;
import Collection.CollectionDragons;
import Collection.Console;
import data.Dragon;
import exception.WrongAmountCommandsException;

import java.time.LocalDateTime;
import java.util.Iterator;

public class AddIfMax implements Command{

    private Asker askerOrganizations;
    private CollectionDragons collectionDragons;
    public AddIfMax(CollectionDragons collectionDragons) {
        this.askerOrganizations =new Asker();
        this.collectionDragons = collectionDragons;
    }

    public AddIfMax() {}

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public String getDescription() {
        return "adds an element to the collection if it exceeds the value of the largest element";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            Dragon organization = new Dragon();
            organization.setId(CollectionDragons.generate_id());
            organization.setName(askerOrganizations.askName());
            organization.setCoordinates(askerOrganizations.setCoordinates());
            organization.setCreationDate(LocalDateTime.now());
            organization.setWeight(askerOrganizations.askWeight());
            organization.setCharacter(askerOrganizations.askCharacter());
            organization.setAge(askerOrganizations.askAge());
            organization.setWingspan(askerOrganizations.askWingspan());
            organization.setHead(askerOrganizations.setHead());
            collectionDragons.addNewElement(organization);
            Iterator<Dragon> iter = collectionDragons.getIterator();
            int count = 0;
            while(iter.hasNext()){
                Dragon org = iter.next();
                long result = organization.getWeight() - org.getWeight();
                if(result > 0){
                    count+=1;
                }
            }
            if(count == collectionDragons.getCollectionSize()){
                collectionDragons.addNewElement(organization);
                Console.println("organization has been successfully added to the collection!");
            }
            else{
                Console.println("The element was not added because its value is less than the largest element");
            }
        }catch (WrongAmountCommandsException ex){
            Console.println("incorrect command usage, usage example: " + getName());
        }

    }
}
