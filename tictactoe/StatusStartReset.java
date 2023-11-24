package tictactoe;

public enum StatusStartReset {

    START("Start"),
    RESET("Reset");

    private final String buttonLabel;

    StatusStartReset(String buttonLabel) {
        this.buttonLabel = buttonLabel;
    }

    public String getButtonLabel() {
        return this.buttonLabel;
    }
}
