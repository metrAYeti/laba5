package Collection;

import commands.*;
import exception.WrongValuesException;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CommandManager {
    String[] s;
    private HashMap<String, Command> commandsMap;
    private List<Command> commandsListForHelp;

    public CommandManager(CollectionDragons collectionManager, FileManager reader, List<String> saveFileNameForExecute) {
        commandsMap = new HashMap<>();
        commandsMap.put("clear", new ClearCommand(collectionManager));
        commandsMap.put("remove_by_id", new RemoveById(collectionManager));
        commandsMap.put("help", new HelpCommand());
        commandsMap.put("info", new InfoCommand(collectionManager));
        commandsMap.put("remove_first", new RemoveFirstCommand(collectionManager));
        commandsMap.put("show", new ShowCommand(collectionManager));
        commandsMap.put("update_by_id", new UpdateCommand(collectionManager));
        commandsMap.put("remove_greater", new RemoveGreaterCommand(collectionManager));
        commandsMap.put("filter_contains_name", new FilterContainsName(collectionManager));
        commandsMap.put("max_by_coordinates", new MaxByCoordinates(collectionManager));
        commandsMap.put("print_field_descending_head", new PrintFieldDescendingHead(collectionManager));
        commandsMap.put("add", new AddElement(collectionManager));
        commandsMap.put("add_if_max", new AddIfMax(collectionManager));
        commandsMap.put("execute_script", new ScriptCommand(collectionManager, saveFileNameForExecute, reader));
        commandsMap.put("save", new SaveCommand(collectionManager, reader));
        commandsMap.put("exit", new Exit());
    }

    public CommandManager() {
        commandsListForHelp = new ArrayList<>();
        commandsListForHelp.add(new ClearCommand());
        commandsListForHelp.add(new RemoveById());
        commandsListForHelp.add(new InfoCommand());
        commandsListForHelp.add(new RemoveFirstCommand());
        commandsListForHelp.add(new ShowCommand());
        commandsListForHelp.add(new UpdateCommand());
        commandsListForHelp.add(new RemoveGreaterCommand());
        commandsListForHelp.add(new FilterContainsName());
        commandsListForHelp.add(new MaxByCoordinates());
        commandsListForHelp.add(new PrintFieldDescendingHead());
        commandsListForHelp.add(new AddElement());
        commandsListForHelp.add(new AddIfMax());
        commandsListForHelp.add(new ScriptCommand());
        commandsListForHelp.add(new SaveCommand());
        commandsListForHelp.add(new Exit());
    }
//
    public void commandManager() {
        Console.print("enter command: ");
        while (Console.ifScannerHasNext()) {
            try {
                s = Console.readString().trim().split(" ");
                if (s.length > 2) throw new WrongValuesException("invalid value format entered");
                if (s.length == 2 && s[0].equals(s[1])) throw new WrongValuesException("invalid value format entered");
                if (commandsMap.get(s[0]) == null) {
                    Console.println("no such command");
                    Console.print("enter command: ");
                } else {
                    commandsMap.get(s[0]).execute(s[s.length - 1]);
                    Console.print("enter command: ");
                }
            } catch (WrongValuesException ex) {
                Console.println(ex.getMessage());
                Console.print("enter command: ");
            }
        }
    }
    public List<Command> getCommandsList(){
        return commandsListForHelp;
    }
    public HashMap<String, Command> getCommandsMap(CollectionDragons collectionManager,List<String> saveFileNameForExecute,FileManager reader) {
        commandsMap = new HashMap<>();
        commandsMap.put("clear", new ClearCommand(collectionManager));
        commandsMap.put("remove_by_id", new RemoveById(collectionManager));
        commandsMap.put("help", new HelpCommand());
        commandsMap.put("info", new InfoCommand(collectionManager));
        commandsMap.put("remove_first", new RemoveFirstCommand(collectionManager));
        commandsMap.put("show", new ShowCommand(collectionManager));
        commandsMap.put("update_by_id", new UpdateCommand(collectionManager));
        commandsMap.put("remove_greater", new RemoveGreaterCommand(collectionManager));
        commandsMap.put("filter_contains_name", new FilterContainsName(collectionManager));
        commandsMap.put("max_by_coordinates", new MaxByCoordinates(collectionManager));
        commandsMap.put("print_field_descending_head", new PrintFieldDescendingHead(collectionManager));
        commandsMap.put("add", new AddElement(collectionManager));
        commandsMap.put("add_if_max", new AddIfMax(collectionManager));
        commandsMap.put("execute_script", new ScriptCommand(collectionManager, saveFileNameForExecute, reader));
        commandsMap.put("save", new SaveCommand(collectionManager, reader));
        commandsMap.put("exit", new Exit());
        return commandsMap;
    }
}
