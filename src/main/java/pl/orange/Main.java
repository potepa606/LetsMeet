package pl.orange;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.orange.initializer.CalendarsGenerator;
import pl.orange.jsonParser.JSONReader;
import pl.orange.models.Calendar;
import pl.orange.setMeet.SetMeeting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {
        final String calendar1Path = "src/main/java/pl/orange/files/calendar1.json";
        final String calendar2Path = "src/main/java/pl/orange/files/calendar2.json";
        final String[] paths= {calendar1Path, calendar2Path};

        CalendarsGenerator calendarsGenerator = new CalendarsGenerator(paths);
        ArrayList<Calendar> calendars = calendarsGenerator.createCalendars();

        for (Calendar calendar : calendars) {
         //   System.out.println(calendar);
        }

        Calendar calendar1 = calendars.get(0);
        Calendar calendar2 = calendars.get(1);

        SetMeeting sm = new SetMeeting();
        sm.setMeeting(calendar1,calendar2);




    }

}
