package tictactoe;

public enum GameMode {

    GAME_NOT_STARTED("Game is not started"),
    GAME_IN_PROGRESS("Game in progress"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    DRAW("Draw");

    private final String textLabel;

    GameMode(String textLabel) {
        this.textLabel = textLabel;
    }

    public String getTextLabel() {
        return this.textLabel;
    }

}
