package pl.orange;


import pl.orange.initializer.CalendarsGenerator;
import pl.orange.models.Calendar;
import pl.orange.setMeet.SetMeeting;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        final String calendar1Path = "src/main/java/pl/orange/files/calendar1.json";
        final String calendar2Path = "src/main/java/pl/orange/files/calendar2.json";
        final String[] paths= {calendar1Path, calendar2Path};

        CalendarsGenerator calendarsGenerator = new CalendarsGenerator(paths);
        ArrayList<Calendar> calendars = calendarsGenerator.createCalendars();

        Calendar calendar1 = calendars.get(0);
        Calendar calendar2 = calendars.get(1);

        ArrayList<LocalTime[]> godziny = new ArrayList<>();

        SetMeeting sm = new SetMeeting();
        ArrayList<String[]> hours  = sm.setMeeting(calendar1,calendar2);
        for (String[] hour : hours) {
            LocalTime[] localTimes = new LocalTime[2];
            localTimes[0] = LocalTime.parse(hour[0]);
            localTimes[1] = LocalTime.parse(hour[hour.length-1]);
            godziny.add(localTimes);
        }

        Scanner duration = new Scanner(System.in);
        System.out.println("Podaj przewidywany czas spotkania - w minutach!");
        long zadanyCzasMinutach = duration.nextInt();

        for (LocalTime[] godz : godziny) {
            long czasWsekundach = Duration.between(godz[0],godz[1]).getSeconds();
            long czasWminutach = czasWsekundach/60;

            if(czasWminutach > zadanyCzasMinutach ){
                System.out.print(Arrays.toString(godz) + " ");
            }
        }
    }

}
