package doomLibraries;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    public static List<String> dirtyStringsList = readFromJson();

    public JsonReader() throws IOException {
    }

    public static List<String> readFromJson() {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(new File("dirtystrings.json"), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readFromJson();
    }
}
