package commands;

import Collection.CollectionDragons;
import Collection.CommandManager;
import Collection.Console;
import Collection.FileManager;
import exception.ScriptRecursionException;


import java.io.*;
import java.util.*;

public class ScriptCommand implements Command {
    private CollectionDragons collectionDragons;
    private CommandManager commandManager;
    private List<String> saveFileNameForExecute;
    private FileManager reader;

    public ScriptCommand(){}
    public ScriptCommand(CollectionDragons collectionDragons, List<String> saveFileNameForExecute, FileManager reader) {
        this.collectionDragons = collectionDragons;
        this.commandManager = new CommandManager();
        this.saveFileNameForExecute = saveFileNameForExecute;
        this.reader = reader;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "reads and executes a script from the specified file";
    }

    @Override
    public void execute(String argument) {
        File file = new File(argument);
        try (Scanner scanner = new Scanner(file)) {
            if (!scanner.hasNextLine()) throw new NoSuchElementException();
            HashMap<String, Command> executeMap = commandManager.getCommandsMap(collectionDragons, saveFileNameForExecute, reader);
            String[] array = {"", ""};
            String line;
            while (!Objects.equals(array, "exit")) {
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                    if (line.isEmpty()) {
                        continue;
                    }
                    array = line.split(" ");
                    if (line.split(" ").length > 2) {
                        Console.println("incorrect values");
                        break;
                    }
                    if (array.length == 2 && array[0].equals(array[1])) {
                        Console.println("invalid value format entered");
                        break;
                    }
                    if (executeMap.get(array[0]) == null) {
                        Console.println("no such command");
                    } else {
                        if (array[0].equals("execute_script")) {
                            if (saveFileNameForExecute.contains(argument)) throw new ScriptRecursionException();
                            else {
                                saveFileNameForExecute.add(argument);
                            }
                        }
                        if (array.length > 1) {
                            Console.println(executeMap.get(array[0]).getName() + " " + array[1] + ": ");
                        } else {
                            Console.println(executeMap.get(array[0]).getName() + ": ");
                        }
                        executeMap.get(array[0]).execute(array[array.length - 1]);
                    }
                    Console.println("");
                }
                if (!scanner.hasNextLine()) {
                    break;
                }
                if (scanner.nextLine().isEmpty()) {
                    break;
                }
            }
        } catch (NoSuchElementException exception) {
            Console.printerror("Boot file is empty!");
        } catch (FileNotFoundException e) {
            Console.printerror("File not found");
            throw new RuntimeException(e);
        } catch (ScriptRecursionException ex) {
            Console.printerror("recursion detected while executing command");
            saveFileNameForExecute.clear();
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


//
//public class ScriptCommand {
//    String s;
//
//    public static ArrayList<String> scriptProcessing() throws IOException {
//        ArrayList<String> commands = new ArrayList<String>();
//        System.out.print("Send file name: ");
//        Scanner scan = new Scanner(System.in);
//
//        String fileName = scan.nextLine();
//
//        File file = new File(fileName);
//
//        //создаем объект FileReader для объекта File
//        FileReader fr = new FileReader(file);
//        //создаем BufferedReader с существующего FileReader для построчного считывания
//        BufferedReader reader = new BufferedReader(fr);
//        // считаем сначала первую строку
//        String line = reader.readLine();
//        while (line != null) {
//            commands.add(line);
//            // считываем остальные строки в цикле
//            line = reader.readLine();
//        }
//        return commands;
//    }
//
//
//    public void executeScript(ArrayList<String> arrayList) throws IOException {
//
//        for (String value : arrayList) {
//            s = value;
//
//
//            switch (s) {
//                case "help" -> new HelpCommand().help();
//                case "info" -> new InfoCommand().info();
//                case "clear" -> new ClearCommand().clear();
//                case "show" -> new ShowCommand().show();
//                case "update" -> new UpdateCommand().update();
//                case "remove_first" -> new RemoveFirstCommand().remove_first();
//                case "remove_by_id" -> new RemoveById().remove_by_id();
//                case "remove_greater" -> new RemoveGreaterCommand().removeGreater();
//                case "max_by_coordinates" -> new MaxByCoordinates().max_by_coordinates();
//                case "filter_contains_name" -> new FilterContainsName().filter_contains_name();
//                case "print_field_descending_head()" -> new PrintFieldDescendingHead().print_field_descending_head();
//                case "add_element" -> CollectionDragons.getDragons().add(new AddElement().adder());
//                case "execute_script" -> new ScriptCommand().executeScript(ScriptCommand.scriptProcessing());
//                case "add_if_max" -> new AddIfMax().adderIfMax();
//                case "save" -> new FileManager("lab5").writeCollection(CollectionDragons.getDragons());
//                case "exit" -> {
//                    System.out.println("До свидания");
//                    System.exit(0);
//                }
//                default -> System.out.println("Такой команды нет" + s + ", воспользуйтесь командой help, чтобы увидеть список команд");
//            }
//        }
//
//    }
//
//
//}
