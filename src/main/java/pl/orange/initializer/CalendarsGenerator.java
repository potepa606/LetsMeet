package pl.orange.initializer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.orange.jsonParser.JSONReader;
import pl.orange.models.Calendar;
import pl.orange.models.Meet;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CalendarsGenerator {

    private String[] paths;

    public CalendarsGenerator(String[] paths) {
        this.paths = paths;
    }

    public ArrayList<Calendar> createCalendars(){
        ArrayList<Calendar> calendars = new ArrayList<>();

        for (String path : paths) {
            JSONReader calendarReader = new JSONReader();
            calendarReader.readCalendar(path);
            JSONObject calendarJSON = calendarReader.getJsonObject();

           String workStart = createWorkingStart(calendarJSON);
           String workEnd = createWorkingEnd(calendarJSON);

           calendars.add(new Calendar(LocalTime.parse(workStart),LocalTime.parse(workEnd), createMeetings(calendarJSON)));
        }


        return calendars;
    }

    private String createWorkingStart(JSONObject jsonObject){
        JSONObject workingHours =  (JSONObject) jsonObject.get("working_hours");
        String workingHoursStart =  workingHours.get("start").toString();
        return workingHoursStart;
    }

    private String createWorkingEnd(JSONObject jsonObject){
        JSONObject workingHours =  (JSONObject) jsonObject.get("working_hours");
        String workingHoursEnd =  workingHours.get("end").toString();
        return workingHoursEnd;
    }

    private ArrayList<Meet> createMeetings(JSONObject jsonObject){
        ArrayList<Meet> meetings = new ArrayList<>();
        JSONArray plannedMeeting =  (JSONArray) jsonObject.get("planned_meeting");

        for (Object m : plannedMeeting) {
            JSONObject meet = (JSONObject) m;
            String startMeet = meet.get("start").toString();
            String endMeet = meet.get("end").toString();

            meetings.add(new Meet(LocalTime.parse(startMeet),LocalTime.parse(endMeet)));
        }
        return meetings;
    }


}
