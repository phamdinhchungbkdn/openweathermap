package data.reader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager;
    private static data.reader.JsonReader jsonReader;

    public static FileReaderManager getInstance( ) {
        return fileReaderManager = new FileReaderManager();
    }

    public JsonReader getJsonReader(){
        return (jsonReader == null) ? new JsonReader() : jsonReader;
    }
}
