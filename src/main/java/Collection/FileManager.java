package Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Dragon;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileManager {
    private Gson gson = new Gson();
    private String envVariable;

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }

    public ArrayDeque<Dragon> readCollection() {
        if (System.getenv().get(envVariable) != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv().get(envVariable)))) {
                ArrayDeque<Dragon> collection;
                Type collectionType = new TypeToken<ArrayDeque<Dragon>>() {
                }.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                Console.println("Коллекция успешна загружена!");
                return collection;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
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
//    public static ArrayDeque<Dragon> fileReader () throws IOException {
//        Gson gson = new Gson();
//        File collection = new File("collection.json");
//        if (collection.canRead()) {
//
//            Reader reader = Files.newBufferedReader(Paths.get(String.valueOf(collection)));
//
//            // convert JSON array to list of dragons
//            List<Dragon> dragonsFromFile = Arrays.asList(gson.fromJson(reader, Dragon[].class));
//            ArrayDeque<Dragon> dragons = new ArrayDeque<>(dragonsFromFile);
//
//            // close reader
//            reader.close();
//            ArrayList<Long> arrayList = new ArrayList<>();
//            for (Dragon dragon : dragons) {
//                arrayList.add(dragon.getId());
//            }
//            Dragon.setArrayList(arrayList);
//            return dragons;
//        } else {
//            return null;
//        }
//    }
}