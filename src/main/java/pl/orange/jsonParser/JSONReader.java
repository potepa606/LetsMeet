package pl.orange.jsonParser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    private JSONParser jsonParser;
    private FileReader calendarFile;
    private JSONObject jsonObject;

    public JSONReader() {
        this.jsonParser = new JSONParser();
        this.calendarFile = null;
        this.jsonObject = null;

    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void readCalendar(String Path) {

        try {
            calendarFile = new FileReader(Path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Nie znaleziono jednego z plikow!");
        }
        this.jsonObject =   parseFileToJSON(calendarFile);
    }

    private JSONObject parseFileToJSON(Object object) {
        try {
            return (JSONObject) jsonParser.parse((FileReader) object);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
