package ships;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AITests {
    // Sprawdzenie poprawności strzału AI
    @Test
    public void AIShot() {
        Board board = new Board();

        Object result = AI.shot(board);

        Assertions.assertTrue(result instanceof int[]);
    }


}
