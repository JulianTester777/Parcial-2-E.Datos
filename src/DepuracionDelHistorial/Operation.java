package DepuracionDelHistorial;

public class Operation {

    private String code;
    private State state;

    public Operation(String code, State state) {
        this.code = code;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return code + "(" + state + ")";
    }


}
