package tictactoe;

public enum PlayerType {

    HUMAN("Human"),
    ROBOT("Robot");

    private final String playerType;

    PlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPlayerType() {
        return this.playerType;
    }
}
