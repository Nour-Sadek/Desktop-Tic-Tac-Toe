package tictactoe;

public enum GameMode {

    GAME_NOT_STARTED("Game is not started"),
    GAME_IN_PROGRESS("The turn of {0} Player ({1})"),
    X_WINS("The {0} Player (X) wins"),
    O_WINS("The {0} Player (O) wins"),
    DRAW("Draw");

    private final String textLabel;

    GameMode(String textLabel) {
        this.textLabel = textLabel;
    }

    public String getTextLabel() {
        return this.textLabel;
    }

}
