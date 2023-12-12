package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    private void startGame() throws IOException {
        App.setRoot("create_board");
    }

    @FXML
    private void exitGame() {
        System.exit(0);
    }
}
