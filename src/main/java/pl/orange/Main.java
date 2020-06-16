package pl.orange;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.orange.initializer.CalendarsGenerator;
import pl.orange.jsonParser.JSONReader;
import pl.orange.models.Calendar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        final String calendar1Path = "E:\\Universality\\LetsMeet\\src\\main\\java\\pl\\orange\\files\\calendar1.json";
        final String calendar2Path = "E:\\Universality\\LetsMeet\\src\\main\\java\\pl\\orange\\files\\calendar2.json";
        final String[] paths= {calendar1Path, calendar2Path};

        CalendarsGenerator calendarsGenerator = new CalendarsGenerator(paths);
        for (Calendar calendar : calendarsGenerator.createCalendars()) {
            System.out.println(calendar);
        }




    }

}
