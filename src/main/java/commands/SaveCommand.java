package commands;

import Collection.CollectionDragons;
import Collection.Console;
import Collection.FileManager;
import exception.WrongAmountCommandsException;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class SaveCommand implements Command{
    private FileManager fileManager;
    private CollectionDragons collectionDragons;
    public SaveCommand(CollectionDragons collectionDragons, FileManager reader){
        this.fileManager = new FileManager("lab5");
        this.collectionDragons = collectionDragons;
    }
    public SaveCommand(){}

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "saving file";
    }

    @Override
    public void execute(String argument) {
        try{
            if(!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            fileManager.writeCollection(collectionDragons.getDragons());
        }catch (WrongAmountCommandsException ex){
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
