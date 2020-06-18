package pl.orange.models;

import java.time.LocalTime;

public class Meet {
    private LocalTime start;
    private LocalTime end;

    public Meet(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
