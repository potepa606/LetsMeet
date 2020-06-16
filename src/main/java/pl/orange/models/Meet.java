package pl.orange.models;

public class Meet {
    private String start;
    private String end;

    public Meet(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
