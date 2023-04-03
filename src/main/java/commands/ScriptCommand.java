package commands;

import Collection.CollectionDragons;
import Collection.FileSaving;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScriptCommand {
    String s;

    public static ArrayList<String> scriptProcessing() throws IOException {
        ArrayList<String> commands = new ArrayList<String>();
        System.out.print("Send file name: ");
        Scanner scan = new Scanner(System.in);

        String fileName = scan.nextLine();

        File file = new File(fileName);

        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = reader.readLine();
        while (line != null) {
            commands.add(line);
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
        return commands;
    }


    public void executeScript(ArrayList<String> arrayList) throws IOException {

        for (String value : arrayList) {
            s = value;


            switch (s) {
                case "help" -> new HelpCommand().help();
                case "info" -> new InfoCommand().info();
                case "clear" -> new ClearCommand().clear();
                case "show" -> new ShowCommand().show();
                case "update" -> new UpdateCommand().update();
                case "remove_first" -> new RemoveFirstCommand().remove_first();
                case "remove_by_id" -> new RemoveById().remove_by_id();
                case "remove_greater" -> new RemoveGreaterCommand().removeGreater();
                case "max_by_coordinates" -> new MaxByCoordinates().max_by_coordinates();
                case "filter_contains_name" -> new FilterContainsName().filter_contains_name();
                case "print_field_descending_head()" -> new PrintFieldDescendingHead().print_field_descending_head();
                case "add_element" -> CollectionDragons.getDragons().add(new AddElement().adder());
                case "execute_script" -> new ScriptCommand().executeScript(ScriptCommand.scriptProcessing());
                case "add_if_max" -> new AddIfMax().adderIfMax();
                case "save" -> new FileSaving().fileSaving();
                case "exit" -> {
                    System.out.println("До свидания");
                    System.exit(0);
                }
                default -> System.out.println("Такой команды нет" + s + ", воспользуйтесь командой help, чтобы увидеть список команд");
            }
        }

    }


}
