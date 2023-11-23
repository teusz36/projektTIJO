package ships;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ships.Board;

public class BoardTests {
    //Sprawdzenie, czy można umieścić statek w podanym miejscu
    @Test
    public void correctShipPlacement() {
        Board board = new Board();
        int numberOfMasts = 4;
        int coordinateX = 5;
        int coordinateY = 6;
        String direction = Board.UP;

        boolean result = board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);

        Assertions.assertTrue(result);
    }

    //Sprawdzenie, czy nie można umieścić statku poza planszą
    @Test
    public void shipOutOfBoundsPlacement() {
        Board board = new Board();
        int numberOfMasts = 3;
        int coordinateX = 1;
        int coordinateY = 1;
        String direction = Board.UP;

        boolean result = board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);

        Assertions.assertFalse(result);
    }

    //Sprawdzenie, czy nie można umieścić statku w miejscu, w którym już jest umieszczony inny statek
    @Test
    public void shipOnShipPlacement() {
        Board board = new Board();
        int numberOfMasts = 3;
        int coordinateX = 1;
        int coordinateY = 1;
        String direction = Board.UP;

        board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);
        boolean result = board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);

        Assertions.assertFalse(result);
    }

    // Sprawdzenie, czy podany statek został zatopiony
    @Test
    public void isShipSunk() {
        //Na wygenerowanej w ten sposób planszy na podanych koordynatach znajduje się jednomasztowy statek
        Board board = new Board().generiteAIBoard(1);
        int coordinateX = 4;
        int coordinateY = 5;

        boolean result = Board.isShipSunk(board, coordinateX, coordinateY);

        Assertions.assertTrue(result);
    }

    // Sprawdzenie, czy na planszy znajduje się trafiony
    @Test
    public void checkForShipsHit() {
        //Na wygenerowanej w ten sposób planszy na podanych koordynatach znajduje się dwumasztowy statek
        Board board = new Board().generiteAIBoard(1);
        int coordinateX = 3;
        int coordinateY = 6;

        board.shot(coordinateX, coordinateY);
        boolean result = board.checkForShipsHit();

        Assertions.assertTrue(result);
    }

    // Sprawdzenie, czy plansza AI została prawidłowo wczytana
    @Test
    public void AIBoardGeneration() {
        Board board;

        Board result = new Board().generiteAIBoard();

        Assertions.assertInstanceOf(Board.class, result);
    }
}
