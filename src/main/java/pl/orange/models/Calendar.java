package pl.orange.models;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Calendar {
   private String workingStart;
   private String workingEnd;
   private ArrayList<Meet> plannedMeeting ;

   public Calendar(String workingStart, String workingEnd, ArrayList<Meet> plannedMeeting) {
      this.workingStart = workingStart;
      this.workingEnd = workingEnd;
      this.plannedMeeting = plannedMeeting;
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
