package ships;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjfx.App;

public class IntegrationTests {
    //Sprawdzenie poprawności rozpoczęcia rozgrywki
    @Test
    public void gameplayStart() {
        Gameplay gameplay = new Gameplay(1, 1);

        Board board = gameplay.getPlayerBoard();

        Assertions.assertTrue(board.shot(1, 1));
        Assertions.assertFalse(board.shot(1, 2));
        Assertions.assertFalse(board.shot(2, 2));
    }

    //Pobranie obiektów Field i sprawdzenie poprawności wygenerowanych statków
    @Test
    public void boardGeneration() {
        Board board = new Board();
        int numberOfMasts = 3;
        int coordinateX = 2;
        int coordinateY = 3;
        String direction = Board.RIGHT;

        Assertions.assertTrue(board.generateShip(numberOfMasts, coordinateX, coordinateY, direction));
        Assertions.assertTrue(board.getBoard().get(32).isShip());
        Assertions.assertFalse(board.getBoard().get(1).isShip());
        Assertions.assertTrue(board.getBoard().get(33).isShip());
        Assertions.assertFalse(board.checkForShipsHit());
        Assertions.assertTrue(board.getBoard().get(34).isShip());
        Assertions.assertTrue(board.shot(coordinateX, coordinateY));
        Assertions.assertTrue(board.checkForShipsHit());
    }

    //Test poprawności generacji planszy AI
    @Test
    public void AIBoardGeneration() {
        Gameplay gameplay = new Gameplay();

        gameplay.generateAIBoard(1);
        Board AIBoard = gameplay.getAIBoard();

        Assertions.assertFalse(AIBoard.shot(1, 2));
        Assertions.assertFalse(AIBoard.checkForShipsHit());
        Assertions.assertTrue(AIBoard.shot(2, 3));
        Assertions.assertTrue(AIBoard.checkForShipsHit());
        Assertions.assertTrue(AIBoard.shot(3, 3));
        Assertions.assertFalse(AIBoard.checkForShipsHit());
    }

    // Sprawdzenie poprawności działania strzałów gracza oraz zapisu strzałów w obiektach Field
    @Test
    public void playerShots() {
        Board board = new Board();
        board.generateShip(2, 1, 1, Board.RIGHT);

        Assertions.assertTrue(board.getBoard().get(11).isActive());
        Assertions.assertTrue(board.shot(1,1));
        Assertions.assertFalse(board.getBoard().get(11).isActive());
        Assertions.assertFalse(board.shot(1,2));
        Assertions.assertTrue(board.getBoard().get(12).isActive());
        Assertions.assertTrue(board.shot(2,1));
        Assertions.assertFalse(board.getBoard().get(12).isActive());
    }

    //Test poprawności reakcji planszy na strzały gracza
    @Test
    public void boardReactionToShots() {
        Board board = new Board();

        board.generateShip(2, 1, 1, Board.RIGHT);
        Assertions.assertTrue(board.shot(1, 1));
        Assertions.assertTrue(board.checkForShipsHit());
        Assertions.assertTrue(board.shot(2, 1));
        Assertions.assertFalse(board.checkForShipsHit());

    }

    //  Test sprawdza poprawność w doborze kolejności ruchu
    @Test
    public void turnCheck() {
        Gameplay gameplay = new Gameplay(1, 1);

        Assertions.assertEquals(gameplay.currentTurn(), "player");
        Assertions.assertTrue(gameplay.shot(gameplay.getPlayerBoard(),1, 1));
        Assertions.assertEquals(gameplay.currentTurn(), "player");
        Assertions.assertFalse(gameplay.shot(gameplay.getPlayerBoard(),1, 2));
        Assertions.assertEquals(gameplay.currentTurn(), "AI");
        Assertions.assertFalse(gameplay.shot(gameplay.getAIBoard(), 1, 2));
        Assertions.assertEquals(gameplay.currentTurn(), "player");
        Assertions.assertFalse(gameplay.shot(gameplay.getAIBoard(), 2, 2));
        Assertions.assertEquals(gameplay.currentTurn(), "AI");
    }

    //Test poprawności wykonywania ruchów przez AI w trafianiu do niezatopionych statków
    @Test
    public void AICornerShotCheck() {
        Board board = new Board();

        board.generateShip(2, 0, 0, Board.DOWN);
        Assertions.assertTrue(board.shot(0, 0));
        Assertions.assertFalse(board.shot(1, 0));
        int[] result = AI.shot(board);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(1, result[1]);
    }

    //Test poprawności wykonywania ruchów przez AI w trafianiu do niezatopionych statków w prawo
    @Test
    public void AIShotCheck() {
        Board board = new Board();

        board.generateShip(2, 5, 6, Board.RIGHT);
        Assertions.assertTrue(board.shot(5, 6));
        Assertions.assertFalse(board.shot(5, 7));
        Assertions.assertFalse(board.shot(5, 5));
        Assertions.assertFalse(board.shot(4, 6));
        int[] result = AI.shot(board);
        Assertions.assertEquals(6, result[0]);
        Assertions.assertEquals(6, result[1]);
    }

    //Test poprawności wygrania rozgrywki przez gracza
    @Test
    public void playerWin() {
        Gameplay gameplay = new Gameplay();
        gameplay.generateAIBoard();
        Board board = new Board();
        board.generateShip(1, 0, 0, Board.DOWN);
        gameplay.setPlayerBoard(board);

        Assertions.assertTrue(gameplay.isGameActive());
        Assertions.assertTrue(gameplay.shot(board, 0, 0));
        Assertions.assertFalse(gameplay.isGameActive());
        Assertions.assertEquals("player", gameplay.getWinner());
    }

    //Test poprawności wygrania rozgrywki przez AI
    @Test
    public void AIWin() {
        Gameplay gameplay = new Gameplay();
        gameplay.generateAIBoard();
        Board board = new Board();
        board.generateShip(2, 0, 0, Board.DOWN);
        gameplay.setPlayerBoard(board);

        Assertions.assertTrue(gameplay.isGameActive());
        Assertions.assertTrue(gameplay.shot(board,0, 0));
        Assertions.assertFalse(gameplay.shot(board,1, 0));
        int[] AIShot = AI.shot(board);
        Assertions.assertTrue(gameplay.shot(board, AIShot[0], AIShot[1]));
        Assertions.assertFalse(gameplay.isGameActive());
        Assertions.assertEquals("AI", gameplay.getWinner());
    }
}