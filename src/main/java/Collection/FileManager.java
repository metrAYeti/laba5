package Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Dragon;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class FileManager {
    private Gson gson = new Gson();
    private String envVariable;

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }

    public ArrayDeque<Dragon> readCollection() {
        if (System.getenv().get(envVariable) != null) {
//            File file = ;
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv().get(envVariable)))) {
                ArrayDeque<Dragon> collection;
                Type collectionType = new TypeToken<ArrayDeque<Dragon>>() {
                }.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                ArrayDeque<Dragon> dragons = collection;
                for (Dragon dragon: dragons) CollectionDragons.getArrayForId().add(dragon.getId());
                Console.println("Коллекция успешна загружена!");
                return collection;
            } catch (FileNotFoundException e) {
                Console.printerror("File not found");
                throw new RuntimeException(e);
            }catch (NoSuchElementException exception){
                Console.printerror("No such element in collection");
                throw new RuntimeException(exception);
            }
        }else return null;
    }
    public void writeCollection(Collection<?> collection) {
        if (System.getenv().get(envVariable) != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv().get(envVariable)))) {
                collectionFileWriter.write(gson.toJson(collection));
                Console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }
}