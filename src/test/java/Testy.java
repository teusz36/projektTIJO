import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Testy {

// Sprawdzenie czy statek został trafiony

    @Test
    public void shipHit() {
        Board board = new Board().generiteAIBoard(1);
        int coordinateX = 4;
        int coordinateY = 5;
        boolean result = board.shot(coordinateX, coordinateY);

        Assertions.assertTrue(result);
    }
// Sprawdzenie czy statek nie został trafiony

    @Test
    public void noShipHit() {
        Board board = new Board().generiteAIBoard(1);
        int coordinateX = 4;
        int coordinateY = 5;

        boolean result = board.shot(coordinateX, coordinateY);

        Assertions.assertFalse(result);
    }




// Sprawdzenie czy podany statek został zatopiony

    @Test
    public void isShipSunk() {
        Board board = new Board().generiteAIBoard(1);
        int coordinateX = 4;
        int coordinateY = 5;

        boolean result = Board.isShipSunk(board, coordinateX, coordinateY);

        Assertions.assertTrue(result);
    }
//Sprawdzenie czy na planszy zostały jakieś niezatopione statki

    @Test
    public void allShipsNotSunk() {
        Board board = new Board().generiteAIBoard(1);

        boolean result = Board.allShipsSunk(board);

        Assertions.assertFalse(result);
    }
//Sprawdzenie czy wszystkie statki zostały zatopione

    @Test
    public void allShipsSunk() {
        Board board = new Board().generiteAIBoard(1);
        board.shot(3, 6);
        board.shot(3, 7);
        board.shot(3, 8);
        board.shot(3, 9);
        board.shot(1, 4);
        board.shot(1, 5);
        board.shot(1, 6);
        board.shot(9, 7);
        board.shot(9, 8);
        board.shot(9, 9);
        board.shot(4, 3);
        board.shot(4, 4);
        board.shot(8, 4);
        board.shot(9, 4);
        board.shot(6, 8);
        board.shot(7, 8);
        board.shot(2, 2);
        board.shot(6, 6);
        board.shot(5, 10);
        board.shot(7, 10);

        boolean result = Board.allShipsSunk(board);

        Assertions.assertTrue(result);
    }

// Sprawdzenie czy została wczytana plansza AI

    @Test
    public void AIBoardGeneration() {
        Board board;
        Board result = new Board().generiteAIBoard();

        Assertions.assertInstanceOf(Board.class, result);
    }

//Sprawdzenie czy można umieścić statek w podanym miejscu

    @Test
    public void correctShipPlacement() {
        Board board = new Board();
        int numberOfMasts = 4;
        int coordinateX = 5;
        int coordinateY = 6;
        char direction = 'u';

        boolean result = board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);

        Assertions.assertTrue(result);
    }
//Sprawdzenie czy statek nie jest uplasowany poza planszą

    @Test
    public void incorrectShipPlacement() {
        Board board = new Board();
        int numberOfMasts = 3;
        int coordinateX = 1;
        int coordinateY = 1;
        char direction = 'u';

        boolean result = board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);

        Assertions.assertFalse(result);
    }
//Sprawdzenie, czy nie można umieścić statku w miejscu, w którym już jest umieszczony inny statek

    @Test
    public void incorrectShipPlacement() {
        Board board = new Board();
        int numberOfMasts = 3;
        int coordinateX = 1;
        int coordinateY = 1;
        char direction = 'u';

        board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);
        boolean result = board.generateShip(numberOfMasts, coordinateX, coordinateY, direction);

        Assertions.assertFalse(result);
    }
//Sprawdzamy, czy na planszy znajdują się trafione, ale nie zatopione statki

    @Test
    public void AIShotAndHit() {
        Board board = new Board().generiteAIBoard(1);
        int coordinateX = 3;
        int coordinateY = 6;

        board.shot(coordinateX, coordinateY);
        boolean result = board.checkForShipsHit();

        Assertions.assertTrue(result);
    }

// Test sprawdzający poprawność ustawienia statków na planszy AI

    @Test
    public void correctShipPlacement() {
        Board board = new Board().generiteAIBoard(1);

        Assertions.assertTrue(board.shot(3, 6));
        Assertions.assertTrue(board.shot(3, 7));
        Assertions.assertFalse(board.shot(3, 10));
        Assertions.assertTrue(board.checkForShipsHit());
        Assertions.assertTrue(board.shot(3, 8));
        Assertions.assertTrue(board.shot(3, 9));
        Assertions.assertFalse(board.checkForShipsHit());
    }
// Test sprawdzający poprawność ustawienia statków na planszy

    @Test
    public void correctShipPlacement() {
        Board board = new Board();
        Assertions.assertTrue(board.generateShip(4, 1, 1, 'd'));
        Assertions.assertFalse(board.generateShip(4, 1, 5, 'd'));
        Assertions.assertTrue(board.generateShip(3, 5, 1, 'r'));
        Assertions.assertTrue(board.generateShip(3, 8, 1, 'd'));
        Assertions.assertFalse(board.generateShip(2, 5, 1, 'd'));
        Assertions.assertTrue(board.generateShip(2, 6, 2, 'r'));
        Assertions.assertFalse(board.generateShip(1, 2, 5, 'd'));

    }

// Test sprawdza poprawność ustawienia I trafienia na planszy AI

    @Test
    public void correctAIShipPlacement() {
        Board Board = new Board().generiteAIBoard(1);

        Assertions.assertTrue(Board.shot(3, 6));
        Assertions.assertTrue(Board.shot(3, 7));
        Assertions.assertFalse(Board.shot(3, 10));
        Assertions.assertTrue(Board.checkForShipsHit());
        Assertions.assertTrue(Board.shot(3, 8));
        Assertions.assertTrue(Board.shot(3, 9));
        Assertions.assertFalse(Board.checkForShipsHit());


    }
//Test sprawdza poprawność rozpoczęcia rozgrywki

    @Test
    public void gameplayStart() {
        Gameplay gameplay = new Gameplay();
        Board playerBoard = gameplay.generatePlayerBoard();
        Board AIBoard = gameplay.generateAIBoard();
        Assertions.assertTrue(gameplay.isActive());
    }



//  Test sprawdza poprawność generacji plansz

    @Test
    public void gameplay() {
        Gameplay gameplay = new Gameplay();
        Board playerBoard = gameplay.generatePlayerBoard();
        Board AIBoard = gameplay.generateAIBoard();
        Assertions.assertTrue(playerBoard.shot(1, 1));
        Assertions.assertFalse(playerBoard.shot(1, 2));
        Assertions.assertFalse(AIBoard.shot(1, 1));
    }

//  Test sprawdza poprawność w doborze kolejności ruchu

    @Test
    public void turnCheck() {
        Gameplay gameplay = new Gameplay();
        Board playerBoard = gameplay.generatePlayerBoard();
        Board AIBoard = gameplay.generateAIBoard();
        Assertions.assertEquals(gameplay.currentTurn(), "player");
        Assertions.assertTrue(playerBoard.shot(1, 1));
        Assertions.assertEquals(gameplay.currentTurn(), "player");
        Assertions.assertFalse(playerBoard.shot(1, 2));
        Assertions.assertEquals(gameplay.currentTurn(), "AI");
        Assertions.assertFalse(AIBoard.shot(1, 1));
        Assertions.assertEquals(gameplay.currentTurn(), "player");
    }
}
