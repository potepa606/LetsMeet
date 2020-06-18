package pl.orange.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Calendar {
   private LocalTime workingStart;
   private LocalTime workingEnd;
   private ArrayList<Meet> plannedMeeting ;

   public Calendar(LocalTime workingStart, LocalTime workingEnd, ArrayList<Meet> plannedMeeting) {
      this.workingStart = workingStart;
      this.workingEnd = workingEnd;
      this.plannedMeeting = plannedMeeting;
   }

   public LocalTime getWorkingStart() {
      return workingStart;
   }

   public LocalTime getWorkingEnd() {
      return workingEnd;
   }

   public ArrayList<Meet> getPlannedMeeting() {
      return plannedMeeting;
   }

   @Override
   public String toString() {
      return "Calendar{" +
              "workingStart='" + workingStart + '\'' +
              ", workingEnd='" + workingEnd + '\'' +
              ", plannedMeeting=" + plannedMeeting +
              '}';
   }
}
