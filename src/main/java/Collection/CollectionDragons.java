package Collection;

import com.google.gson.Gson;
import data.Dragon;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

public class CollectionDragons {
    public static Deque<Dragon> getDragons() {
        return dragons;
    }

    private static Deque<Dragon> dragons;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionDragons(FileManager fileManagerReader){
        dragons = fileManagerReader.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    public void saveCollection() {
        fileManager.writeCollection(dragons);
        lastSaveTime = LocalDateTime.now();
    }

//    static {
//        try {
//            dragons = CollectionDragons.fileReader();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ArrayDeque<Dragon> fileReader() throws IOException {
//        Gson gson = new Gson();
//        boolean flag = true;
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
//        }
//        else{
//            return null;
//        }
//    }

    // create a reader


    public static String info() {
        int size = CollectionDragons.getDragons().size();
        String result = "Размер коллекции: " + size + '\n' + "Тип коллекции: ArrayDeque" + '\n' + "Дата инициализации: " + LocalDateTime.now();
        return result;
    }
}
