package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ships.Gameplay;

public class WinScreenController {
    @FXML
    Label winnerLabel;

    @FXML
    private void initialize() {
        if(App.getActiveGameplay().getWinner().equals(Gameplay.PLAYER)) {
            winnerLabel.setText("Wygrałeś!");
        } else {
            winnerLabel.setText("Przegrałeś :c\nSpróbuj ponownie!");
        }
    }

    @FXML
    private void backToMenu() throws IOException {
        App.setRoot("main_menu");
    }

    @FXML
    private void exitGame() {
        System.exit(0);
    }
}
