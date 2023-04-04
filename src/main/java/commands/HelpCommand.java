package commands;

import Collection.CommandManager;
import Collection.Console;
import exception.WrongAmountCommandsException;

import java.util.List;

public class HelpCommand implements Command{
    private CommandManager commandsManager = new CommandManager();
    private Console consoleManager;

    public HelpCommand(){
        this.consoleManager = new Console();
    }
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "command gives a summary of all other commands";
    }

    @Override
    public void execute(String argument){
        try {
            if(!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            List<Command> listCommands = commandsManager.getCommandsList();
            consoleManager.println(getName() + ": " + getDescription());
            for (Command commands : listCommands) {
                consoleManager.println(commands.getName() + ": " + commands.getDescription());
            }
        }catch (WrongAmountCommandsException ex){
            consoleManager.println("incorrect command usage, usage example: " + getName());
        }
    }
//        System.out.println("help : вывести справку по доступным командам " + '\n' +
//                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)" + '\n' +
//                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении" + '\n' +
//                "add {element} : добавить новый элемент в коллекцию" + '\n' +
//                "update id {element} : обновить значение элемента коллекции, id которого равен заданному" + '\n' +
//                "remove_by_id id : удалить элемент из коллекции по его id" + '\n' +
//                "clear : очистить коллекцию" + '\n' +
//                "save : сохранить коллекцию в файл" + '\n' +
//                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. " + '\n' +
//                "exit : завершить программу (без сохранения в файл)" + '\n' +
//                "remove_first : удалить первый элемент из коллекции" + '\n' +
//                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции" + '\n' +
//                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный" + '\n' +
//                "max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным" + '\n' +
//                "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку" + '\n' +
//                "print_field_descending_head : вывести значения поля head всех элементов в порядке убывания");
//    }
}
