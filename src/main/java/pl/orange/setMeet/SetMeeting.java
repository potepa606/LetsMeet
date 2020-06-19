package pl.orange.setMeet;

import pl.orange.models.Calendar;
import pl.orange.models.Meet;

import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

public class SetMeeting {


    static LocalTime[] cal1 = new LocalTime[48]; // kazda komorka to plus 30 min. od 00:00 do 23:30
    static LocalTime[] cal2 = new LocalTime[48];

    static ArrayList<LocalTime> freeTime = new ArrayList<>();
    static ArrayList<LocalTime> freeTime2 = new ArrayList<>();

    static ArrayList<String[]> finallyFreeTime = new ArrayList<>();



    public ArrayList<String[]> setMeeting(Calendar calendar1, Calendar calendar2) {

        generateCalendarArrays();
        for (int i = 0; i < 48; i++) {
            if (cal1[i] != null && (cal1[i].isBefore(calendar1.getWorkingStart()) || cal1[i].isAfter(calendar1.getWorkingEnd()))) {
                cal1[i] = null;
            }
            if (cal2[i] != null && (cal2[i].isBefore(calendar2.getWorkingStart()) || cal2[i].isAfter(calendar2.getWorkingEnd()))) {
                cal2[i] = null;
            }
        }

        ArrayList<Meet> plannedMeetings_Person_1 = calendar1.getPlannedMeeting();
        ArrayList<Meet> plannedMeetings_Person_2 = calendar2.getPlannedMeeting();


        setNullMeetingPositions(plannedMeetings_Person_1, cal1, calendar1);
        setNullMeetingPositions(plannedMeetings_Person_2, cal2, calendar2);

        return checkFreeTime();

//        display();
    }


    private ArrayList<String[]> checkFreeTime() {
        boolean save = true;
        for (int i = 1; i < 47; i++) {
            if(cal1[i] != null && cal2[i] != null && cal1[i].equals(cal2[i])){
                freeTime.add(cal1[i]);
            }
        }

        for (int i = 0; i < freeTime.size()-1; i++) {
            LocalTime time = freeTime.get(i).plusMinutes(30);
            if(time.equals(freeTime.get(i+1))) {
                freeTime2.add(freeTime.get(i));
               // freeTime2.add(time);
            }else if(freeTime.get(i).equals(freeTime.get(i-1).plusMinutes(30))){
                freeTime2.add(freeTime.get(i));

            }
            if(!time.equals(freeTime.get(i+1))) {
                freeTime2.add(null);
            }
        }

        LocalTime[] arrTimes = new LocalTime[2];
        //freeTime2.add(0, null);

        String test = "";
        for (LocalTime localTime : freeTime2) {
            test += localTime + "";
        }
        String[] test2 = test.split("null");
        for (int i = 0; i < test2.length; i++) {
            finallyFreeTime.add(test2[i].split("(?<=\\G.{5})"));
        }

        for (String[] strings : finallyFreeTime) {
        //    System.out.println(Arrays.toString(strings));
        }

       // freeTime2.forEach(t -> System.out.println(t));

        return finallyFreeTime;
    }

    private void setNullMeetingPositions(ArrayList<Meet> plannedMeetings_Person, LocalTime[] cal, Calendar calendar) {
        LocalTime endMeet_Person_Prev = null;


        for (Meet pm : plannedMeetings_Person) {
            LocalTime startMeet_Person = pm.getStart();
            LocalTime endMeet_Person = pm.getEnd();


            for (int i = 0; i < 48; i++) {
                if (cal[i] != null && ((cal[i].isAfter(startMeet_Person) && cal[i].isBefore(endMeet_Person)))) {
                    cal[i] = null;
                }
                if (endMeet_Person_Prev != null && cal[i] != null && cal[i].equals(startMeet_Person) && (endMeet_Person_Prev.equals(startMeet_Person))) {
                    cal[i] = null;
                }
                if (cal[i] != null && cal[i].equals(startMeet_Person) && startMeet_Person.equals(calendar.getWorkingStart())) {
                    cal[i] = null;
                }

            }
            endMeet_Person_Prev = endMeet_Person;
        }
    }

    private static void generateCalendarArrays() {
        cal1[0] = LocalTime.of(0, 0);
        for (int i = 1; i < cal1.length; i++) {
            LocalTime previousTimePlus30minutes = cal1[i - 1].plusMinutes(30);
            cal1[i] = previousTimePlus30minutes;
        }
        // Arrays.stream(cal1).forEach(time -> System.out.println(time));

        cal2[0] = LocalTime.of(0, 0);
        for (int i = 1; i < cal2.length; i++) {
            LocalTime previousTimePlus30minutes = cal2[i - 1].plusMinutes(30);
            cal2[i] = previousTimePlus30minutes;
        }
        // Arrays.stream(cal1).forEach(time -> System.out.println(time));

    }

    private static void display() {
        for (int i = 0; i < 48; i++) {
            System.out.println(cal1[i] + " - - " + cal2[i]);
        }

    }


}
