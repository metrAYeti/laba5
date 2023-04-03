package Collection;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaving {
    public void fileSaving() throws IOException {
        Gson gson = new Gson();
        // create a writer
        String filePath = System.getenv("lab5");
        Writer writer = Files.newBufferedWriter(Paths.get(filePath));
//      Writer writer = Files.newBufferedWriter(Paths.get(filePath));
        // convert books object to JSON file
        gson.toJson(CollectionDragons.getDragons(), writer);
        // close writer
        writer.close();
//        final String filename = System.getenv("PlsSetAMaximum");
//        if (filename == null || filename.isEmpty()) {
//            System.out.println(("please set a PlsSetAMaximum env.variable"));
//            return;
//        }
//        File file = new File(filename);
//        Path path = Paths.get(filename);
//        if (!file.exists()) {
//            System.out.println(("file not founded"));
//            return;
//        }
    }
}


