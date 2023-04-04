//package commands;
//
//import Collection.CollectionDragons;
//import Collection.FileManager;
//
//import data.Dragon;
//
//import java.io.IOException;
//import java.util.Objects;
//import java.util.Scanner;
//
//public class CommandProcessing {
//    String s;
//
//    public void switchCommands() throws IOException {
//        System.out.print("enter command: ");
//        while (!Objects.equals(s, "exit")) {
//            Scanner scanner = new Scanner(System.in);
//            s = scanner.nextLine();
//            switch (s) {
//                case "help" -> {
//                    new HelpCommand().help();
//                    System.out.print("enter command: ");
//                }
//                case "info" -> {
//                    new InfoCommand().info();
//                    System.out.print("enter command: ");
//                }
//                case "clear" -> {
//                    new ClearCommand().clear();
//                    System.out.print("enter command: ");
//                }
//                case "show" -> {
//                    new ShowCommand().show();
//                    System.out.print("enter command: ");
//                }
//                case "update" -> {
//                    new UpdateCommand().update();
//                    System.out.print("enter command: ");
//                }
//                case "remove_first" -> {
//                    new RemoveFirstCommand().remove_first();
//                    System.out.print("enter command: ");
//                }
//                case "remove_by_id" -> {
//                    new RemoveById().remove_by_id();
//                    System.out.print("enter command: ");
//                }
//                case "remove_greater" -> {
//                    new RemoveGreaterCommand().removeGreater();
//                    System.out.print("enter command: ");
//                }
//                case "max_by_coordinates" -> {
//                    new MaxByCoordinates().max_by_coordinates();
//                    System.out.print("enter command: ");
//                }
//                case "filter_contains_name" -> {
//                    new FilterContainsName().filter_contains_name();
//                    System.out.print("enter command: ");
//                }
//                case "print_field_descending_head()" -> {
//                    new PrintFieldDescendingHead().print_field_descending_head();
//                    System.out.print("enter command: ");
//                }
//                case "execute_script" -> {
//                    new ScriptCommand().executeScript(ScriptCommand.scriptProcessing());
//                    System.out.print("enter command: ");
//                }
//                case "add" -> {
//                    CollectionDragons.getDragons().add(new AddElement().adder());
//                    System.out.print("enter command: ");
//                }
//                case "add_if_max" -> {
//                    new AddIfMax().adderIfMax();
//                    System.out.print("enter command: ");
//                }
//                case "save" -> {
//                    new FileManager("lab5").writeCollection(CollectionDragons.getDragons());
//                    System.out.print("enter command: ");
//                }
//                case "exit" -> {
//                    System.out.println("До свидания");
//                    System.exit(0);
//                }
//                default -> {
//                    System.out.println("Такой команды нет, воспользуйтесь командой help, чтобы увидеть список команд");
//                    System.out.print("enter command: ");
//                }
//            }
//        }
//    }
//}
