package Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.Dragon;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class FileManager {
    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).registerTypeAdapter(
            LocalDateTime.class, new LocalDateTimeAdapter()).setPrettyPrinting().create();
    private String envVariable;

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }

    public ArrayDeque<Dragon> readCollection() {
        if (System.getenv().get(envVariable) != null) {
            File file = new File(System.getenv().get(envVariable));
            if (file.canRead()) {
                try (Scanner collectionFileScanner = new Scanner(file)) {
                    ArrayDeque<Dragon> collection;
                    Type collectionType = new TypeToken<ArrayDeque<Dragon>>() {
                    }.getType();
                    String coll = null;
                    while (collectionFileScanner.hasNext()){
                        String col = collectionFileScanner.nextLine().trim();
                        coll = coll + col;
                    }
                    String a = coll.substring(4);
                    collection = gson.fromJson(a, collectionType);
                    ArrayDeque<Dragon> dragons = collection;
                    for (Dragon dragon : dragons) CollectionDragons.getArrayForId().add(dragon.getId());
                    Console.println("Collection save successful");
                    return collection;
                } catch (FileNotFoundException e) {
                    Console.printerror("File not found");
                    throw new RuntimeException(e);
                } catch (NoSuchElementException exception) {
                    Console.printerror("No such element in collection");
                    throw new RuntimeException(exception);
                }
                catch (NullPointerException exception){
                    Console.printerror("Collection not have element");
                    throw new RuntimeException(exception);
                }
            } else {
                Console.printerror("no read access rights");
                throw new RuntimeException("ululu");
            }

        } else return null;
    }


    public void writeCollection(Collection<?> collection, String name) {
        File file = new File(name);
        if (name!=null && file.canWrite() ) {
            try (FileWriter collectionFileWrit = new FileWriter(name)){
                collectionFileWrit.write(gson.toJson(collection));
            }catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }
    public void writeCollection(Collection<?> collection) {
        if (System.getenv().get(envVariable) != null) {
            try (FileWriter collectionFileWriter = new FileWriter((System.getenv().get(envVariable)))) {
                collectionFileWriter.write(gson.toJson(collection));
                Console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }
}