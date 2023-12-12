package ships;

public class Gameplay {
    private Board AIBoard;
    private Board playerBoard;
    private boolean gameActive;
    private String currentTurn;
    private String winner;

    public Gameplay(int i, int i1) {
        gameActive = true;
        currentTurn = "player";
    }

    public Gameplay() {
        gameActive = true;
        currentTurn = "player";
    }

    public boolean isGameActive() {
        return gameActive;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public void generateAIBoard() {

    }

    public void generateAIBoard(int i) {
    }

    public Board getAIBoard() {
        return AIBoard;
    }

    public String currentTurn() {
        return "player";
    }

    public void setPlayerBoard(Board board) {
        playerBoard = board;
    }

    public String getWinner() {
        return winner;
    }
}
