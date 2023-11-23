package ships;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameplayTests {
    // Sprawdzenie, czy rozgrywka się prawidłowo uruchomiła
    @Test
    public void correctStart() {
        Gameplay gameplay = new Gameplay();

        boolean result = gameplay.isGameActive();

        Assertions.assertTrue(result);
    }
}
