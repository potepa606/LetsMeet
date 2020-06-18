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



    public void setMeeting(Calendar calendar1, Calendar calendar2){

        generateCalendarArrays();
        for (int i = 0; i < 48; i++) {
            if(cal1[i] != null && ( cal1[i].isBefore(calendar1.getWorkingStart()) || cal1[i].isAfter(calendar1.getWorkingEnd())) ){
                cal1[i] = null;
            }
            if(cal2[i] != null && ( cal2[i].isBefore(calendar2.getWorkingStart()) || cal2[i].isAfter(calendar2.getWorkingEnd())) ){
                cal2[i] = null;
            }
        }

        ArrayList<Meet> plannedMeetings_Person_1 = calendar1.getPlannedMeeting();
        ArrayList<Meet> plannedMeetings_Person_2 = calendar2.getPlannedMeeting();


        for (Meet pm : plannedMeetings_Person_1) {
            LocalTime startMeet_Person_1 = pm.getStart();
            LocalTime endMeet_Person_1 = pm.getEnd();

            for (int i = 0; i < 48; i++) {
                if(cal1[i] != null && ( (cal1[i].equals(startMeet_Person_1) | cal1[i].equals(endMeet_Person_1)) || ( cal1[i].isAfter(startMeet_Person_1) && cal1[i].isBefore(endMeet_Person_1) ))){
                    cal1[i] = null;
                }
            }
        }
        for (Meet pm : plannedMeetings_Person_2) {
            LocalTime startMeet_Person_2 = pm.getStart();
            LocalTime  endMeet_Person_2 = pm.getEnd();

            for (int i = 0; i < 48; i++) {
                if(cal2[i] != null && ( (cal2[i].equals(startMeet_Person_2) | cal2[i].equals(endMeet_Person_2)) || ( cal2[i].isAfter(startMeet_Person_2) && cal2[i].isBefore(endMeet_Person_2) ))){
                    cal2[i] = null;
                }
            }
        }


        display();
    }

    private static void generateCalendarArrays(){
        cal1[0] = LocalTime.of(0,0);
        for (int i = 1; i < cal1.length; i++) {
            LocalTime previousTimePlus30minutes = cal1[i-1].plusMinutes(30);
            cal1[i] = previousTimePlus30minutes;
        }
        // Arrays.stream(cal1).forEach(time -> System.out.println(time));

        cal2[0] = LocalTime.of(0,0);
        for (int i = 1; i < cal2.length; i++) {
            LocalTime previousTimePlus30minutes = cal2[i-1].plusMinutes(30);
            cal2[i] = previousTimePlus30minutes;
        }
        // Arrays.stream(cal1).forEach(time -> System.out.println(time));

    }

    private static void display(){
        for(int i=0; i<48 ;i++){
            System.out.println(cal1[i] + " - - " + cal2[i]);
        }

    }


}
