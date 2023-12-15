package ships;

import org.openjfx.App;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Gameplay {
    private Board AIBoard;
    private Board playerBoard;
    private boolean gameActive;
    private String currentTurn;
    public String winner;

    public static final String PLAYER = "player";
    public static final String AI = "AI";

    public Gameplay(int PlayerNumber, int AINumber) {
        gameActive = true;
        currentTurn = "player";

        playerBoard = new Board();
        String fileLine;
        String fileName = "./AIplansze/AI_plansza_"+PlayerNumber+".txt";
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            fileLine = in.readLine();
            in.close();
            for(int i=0; i< 100; i++){
                if(fileLine.charAt(i) != '0'){
                    playerBoard.get(i).ship(true);
                }
            }
        } catch (Exception e){
            System.out.println("Brak pliku");
        }

        generateAIBoard(AINumber);
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
        AIBoard = new Board();
        Random rand = new Random();
        int boardNumber = rand.nextInt(10);
        String fileLine;
        String fileName = "./AIplansze/AI_plansza_"+boardNumber+".txt";
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            fileLine = in.readLine();
            in.close();
            for(int i=0; i< 100; i++){
                if(fileLine.charAt(i) != '0'){
                    AIBoard.get(i).ship(true);
                }
            }
        } catch (Exception e){
            System.out.println("Brak pliku");
        }
    }

    public void generateAIBoard(int boardNumber) {
        AIBoard = new Board();
        String fileLine;
        String fileName = "./AIplansze/AI_plansza_"+boardNumber+".txt";
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            fileLine = in.readLine();
            in.close();
            for(int i=0; i< 100; i++){
                if(fileLine.charAt(i) != '0'){
                    AIBoard.get(i).ship(true);
                }
            }
        } catch (Exception e){
            System.out.println("Brak pliku");
        }
    }

    public Board getAIBoard() {
        return AIBoard;
    }

    public String currentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(String turn) {
        currentTurn = turn;
    }

    public void setPlayerBoard(Board board) {
        playerBoard = board;
    }

    public String getWinner() {
        return winner;
    }

    public boolean shot(Board board, int x, int y) {
        boolean hit = board.shot(x, y);
        if(!hit) {
            if(Objects.equals(currentTurn, Gameplay.PLAYER)) {
                currentTurn = Gameplay.AI;
            } else {
                currentTurn = Gameplay.PLAYER;
            }
        } else {
            if(board.isBoardCleared()) {
                gameActive = false;
                if(Objects.equals(currentTurn, Gameplay.PLAYER)) {
                    winner = Gameplay.PLAYER;
                } else {
                    winner = Gameplay.AI;
                }
                try {
                    App.setRoot("win_screen");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hit;
    }
}
