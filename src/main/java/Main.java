import Collection.CollectionDragons;
import Collection.CommandManager;
import Collection.FileManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException { 
        System.out.println("What file you want open?" + "\n" + "1.AutoSaveFile" +"\n" + "2.NotAutoSaveFile");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 2){
            final String envVariable = "lab5";
            FileManager fileManager = new FileManager(envVariable);
            CollectionDragons collectionDragons = new CollectionDragons(fileManager);
            List<String> saveFileNameForExecute = new ArrayList<>();
            CommandManager commandsProcessing = new CommandManager(collectionDragons, fileManager, saveFileNameForExecute);
            commandsProcessing.commandManager();
        }
        else {
            final String envVariabl = "lab5auto";
            FileManager fileManager = new FileManager(envVariabl);
            CollectionDragons collectionDragons = new CollectionDragons(fileManager);
            List<String> saveFileNameForExecute = new ArrayList<>();
            CommandManager commandsProcessing = new CommandManager(collectionDragons, fileManager, saveFileNameForExecute);
            commandsProcessing.commandManager();
        }
    }
}
