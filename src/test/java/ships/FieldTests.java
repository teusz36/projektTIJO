package ships;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ships.Field;

public class FieldTests {
    // Sprawdzenie, czy statek został trafiony
    @Test
    public void shipHit() {
        Field field = new Field();
        field.ship(true); //ustawienie informacji o tym, że na polu znajduje się statek

        boolean result = field.shot();

        Assertions.assertTrue(result);
    }

    // Sprawdzenie, czy statek nie został trafiony
    @Test
    public void noShipHit() {
        Field field = new Field();
        field.ship(false); //ustawienie informacji o tym, że na polu znajduje się statek

        boolean result = field.shot();

        Assertions.assertFalse(result);
    }
}
