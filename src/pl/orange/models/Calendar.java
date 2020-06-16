package pl.orange.models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Calendar {
   private String workingStart;
   private String workingEnd;

   private Set<Meet> plannedMeeting = new LinkedHashSet<>();

   public Calendar(String workingStart, String workingEnd, Set<Meet> plannedMeeting) {
      this.workingStart = workingStart;
      this.workingEnd = workingEnd;
      this.plannedMeeting = plannedMeeting;
   }
}
