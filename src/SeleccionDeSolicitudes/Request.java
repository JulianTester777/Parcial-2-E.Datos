package SeleccionDeSolicitudes;

public class Request {

    private String code;
    private Priority priority;
    private int duration;

    public Request(String code, Priority priority, int duration) {
        this.code = code;
        this.priority = priority;
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return code + " - " + priority + " - " + duration + " minutos";
    }


}
