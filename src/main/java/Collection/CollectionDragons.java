package Collection;

import data.Dragon;
import java.time.LocalDateTime;
import java.util.*;

public class CollectionDragons {

    private static ArrayList<Long> arrayForId = new ArrayList<>();
    private ArrayDeque<Dragon> dragons;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private FileManager fileManager;

    public static ArrayList<Long> getArrayForId() {
        return arrayForId;
    }

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    public Deque<Dragon> getDragons() {
        return dragons;
    }

    public CollectionDragons(FileManager fileManagerReader) {
        dragons = fileManagerReader.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    public void saveCollection() {
        fileManager.writeCollection(dragons);
        lastSaveTime = LocalDateTime.now();
    }

    public void clear() {
        dragons.clear();
    }
    public void removeFirst(){
        dragons.removeFirst();
    }

    public Iterator<Dragon> getIterator() {
        return dragons.iterator();
    }

    public int getCollectionSize() {
        return dragons.size();
    }

    public Dragon getFirstElement() {
        return dragons.getFirst();
    }

    public void show() {
        Console.println("Dragons collection: \n");
        for (Dragon dragon: dragons) {Console.println(dragon);}
    }

    public Dragon getById(Long id) {
        for (Dragon dragon : dragons) {
            if (dragon.getId().equals(id)) return dragon;
        }
        return null;
    }

    public void addNewElement(Dragon dragon) {
        dragons.add(dragon);
    }

    public static Long generate_id() {
        Long id;
        while (true) {
            id = (long) (1L + (Math.random() * (10000L)));
            if (!arrayForId.contains(id)) {
                arrayForId.add(id);
                return id;
            }
        }
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

}
