package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class GameController {

    @FXML
    ImageView playerBoardx0y0, playerBoardx0y1, playerBoardx0y2, playerBoardx0y3, playerBoardx0y4, playerBoardx0y5, playerBoardx0y6, playerBoardx0y7, playerBoardx0y8, playerBoardx0y9, playerBoardx1y0, playerBoardx1y1, playerBoardx1y2, playerBoardx1y3, playerBoardx1y4, playerBoardx1y5, playerBoardx1y6, playerBoardx1y7, playerBoardx1y8, playerBoardx1y9, playerBoardx2y0, playerBoardx2y1, playerBoardx2y2, playerBoardx2y3, playerBoardx2y4, playerBoardx2y5, playerBoardx2y6, playerBoardx2y7, playerBoardx2y8, playerBoardx2y9, playerBoardx3y0, playerBoardx3y1, playerBoardx3y2, playerBoardx3y3, playerBoardx3y4, playerBoardx3y5, playerBoardx3y6, playerBoardx3y7, playerBoardx3y8, playerBoardx3y9, playerBoardx4y0, playerBoardx4y1, playerBoardx4y2, playerBoardx4y3, playerBoardx4y4, playerBoardx4y5, playerBoardx4y6, playerBoardx4y7, playerBoardx4y8, playerBoardx4y9, playerBoardx5y0, playerBoardx5y1, playerBoardx5y2, playerBoardx5y3, playerBoardx5y4, playerBoardx5y5, playerBoardx5y6, playerBoardx5y7, playerBoardx5y8, playerBoardx5y9, playerBoardx6y0, playerBoardx6y1, playerBoardx6y2, playerBoardx6y3, playerBoardx6y4, playerBoardx6y5, playerBoardx6y6, playerBoardx6y7, playerBoardx6y8, playerBoardx6y9, playerBoardx7y0, playerBoardx7y1, playerBoardx7y2, playerBoardx7y3, playerBoardx7y4, playerBoardx7y5, playerBoardx7y6, playerBoardx7y7, playerBoardx7y8, playerBoardx7y9, playerBoardx8y0, playerBoardx8y1, playerBoardx8y2, playerBoardx8y3, playerBoardx8y4, playerBoardx8y5, playerBoardx8y6, playerBoardx8y7, playerBoardx8y8, playerBoardx8y9, playerBoardx9y0, playerBoardx9y1, playerBoardx9y2, playerBoardx9y3, playerBoardx9y4, playerBoardx9y5, playerBoardx9y6, playerBoardx9y7, playerBoardx9y8, playerBoardx9y9;

    @FXML Label labelTurn;

    ImageView[][] playerBoardImageViews;
    private Image shipModuleImage = new Image(getClass().getResourceAsStream("/ship_module.png"));

    
    @FXML
    private void initialize() {
        playerBoardImageViews = new ImageView[10][10];
        playerBoardImageViews[0][0] = playerBoardx0y0;
        playerBoardImageViews[0][1] = playerBoardx0y1;
        playerBoardImageViews[0][2] = playerBoardx0y2;
        playerBoardImageViews[0][3] = playerBoardx0y3;
        playerBoardImageViews[0][4] = playerBoardx0y4;
        playerBoardImageViews[0][5] = playerBoardx0y5;
        playerBoardImageViews[0][6] = playerBoardx0y6;
        playerBoardImageViews[0][7] = playerBoardx0y7;
        playerBoardImageViews[0][8] = playerBoardx0y8;
        playerBoardImageViews[0][9] = playerBoardx0y9;

        playerBoardImageViews[1][0] = playerBoardx1y0;
        playerBoardImageViews[1][1] = playerBoardx1y1;
        playerBoardImageViews[1][2] = playerBoardx1y2;
        playerBoardImageViews[1][3] = playerBoardx1y3;
        playerBoardImageViews[1][4] = playerBoardx1y4;
        playerBoardImageViews[1][5] = playerBoardx1y5;
        playerBoardImageViews[1][6] = playerBoardx1y6;
        playerBoardImageViews[1][7] = playerBoardx1y7;
        playerBoardImageViews[1][8] = playerBoardx1y8;
        playerBoardImageViews[1][9] = playerBoardx1y9;

        playerBoardImageViews[2][0] = playerBoardx2y0;
        playerBoardImageViews[2][1] = playerBoardx2y1;
        playerBoardImageViews[2][2] = playerBoardx2y2;
        playerBoardImageViews[2][3] = playerBoardx2y3;
        playerBoardImageViews[2][4] = playerBoardx2y4;
        playerBoardImageViews[2][5] = playerBoardx2y5;
        playerBoardImageViews[2][6] = playerBoardx2y6;
        playerBoardImageViews[2][7] = playerBoardx2y7;
        playerBoardImageViews[2][8] = playerBoardx2y8;
        playerBoardImageViews[2][9] = playerBoardx2y9;

        playerBoardImageViews[3][0] = playerBoardx3y0;
        playerBoardImageViews[3][1] = playerBoardx3y1;
        playerBoardImageViews[3][2] = playerBoardx3y2;
        playerBoardImageViews[3][3] = playerBoardx3y3;
        playerBoardImageViews[3][4] = playerBoardx3y4;
        playerBoardImageViews[3][5] = playerBoardx3y5;
        playerBoardImageViews[3][6] = playerBoardx3y6;
        playerBoardImageViews[3][7] = playerBoardx3y7;
        playerBoardImageViews[3][8] = playerBoardx3y8;
        playerBoardImageViews[3][9] = playerBoardx3y9;

        playerBoardImageViews[4][0] = playerBoardx4y0;
        playerBoardImageViews[4][1] = playerBoardx4y1;
        playerBoardImageViews[4][2] = playerBoardx4y2;
        playerBoardImageViews[4][3] = playerBoardx4y3;
        playerBoardImageViews[4][4] = playerBoardx4y4;
        playerBoardImageViews[4][5] = playerBoardx4y5;
        playerBoardImageViews[4][6] = playerBoardx4y6;
        playerBoardImageViews[4][7] = playerBoardx4y7;
        playerBoardImageViews[4][8] = playerBoardx4y8;
        playerBoardImageViews[4][9] = playerBoardx4y9;

        playerBoardImageViews[5][0] = playerBoardx5y0;
        playerBoardImageViews[5][1] = playerBoardx5y1;
        playerBoardImageViews[5][2] = playerBoardx5y2;
        playerBoardImageViews[5][3] = playerBoardx5y3;
        playerBoardImageViews[5][4] = playerBoardx5y4;
        playerBoardImageViews[5][5] = playerBoardx5y5;
        playerBoardImageViews[5][6] = playerBoardx5y6;
        playerBoardImageViews[5][7] = playerBoardx5y7;
        playerBoardImageViews[5][8] = playerBoardx5y8;
        playerBoardImageViews[5][9] = playerBoardx5y9;

        playerBoardImageViews[6][0] = playerBoardx6y0;
        playerBoardImageViews[6][1] = playerBoardx6y1;
        playerBoardImageViews[6][2] = playerBoardx6y2;
        playerBoardImageViews[6][3] = playerBoardx6y3;
        playerBoardImageViews[6][4] = playerBoardx6y4;
        playerBoardImageViews[6][5] = playerBoardx6y5;
        playerBoardImageViews[6][6] = playerBoardx6y6;
        playerBoardImageViews[6][7] = playerBoardx6y7;
        playerBoardImageViews[6][8] = playerBoardx6y8;
        playerBoardImageViews[6][9] = playerBoardx6y9;

        playerBoardImageViews[7][0] = playerBoardx7y0;
        playerBoardImageViews[7][1] = playerBoardx7y1;
        playerBoardImageViews[7][2] = playerBoardx7y2;
        playerBoardImageViews[7][3] = playerBoardx7y3;
        playerBoardImageViews[7][4] = playerBoardx7y4;
        playerBoardImageViews[7][5] = playerBoardx7y5;
        playerBoardImageViews[7][6] = playerBoardx7y6;
        playerBoardImageViews[7][7] = playerBoardx7y7;
        playerBoardImageViews[7][8] = playerBoardx7y8;
        playerBoardImageViews[7][9] = playerBoardx7y9;

        playerBoardImageViews[8][0] = playerBoardx8y0;
        playerBoardImageViews[8][1] = playerBoardx8y1;
        playerBoardImageViews[8][2] = playerBoardx8y2;
        playerBoardImageViews[8][3] = playerBoardx8y3;
        playerBoardImageViews[8][4] = playerBoardx8y4;
        playerBoardImageViews[8][5] = playerBoardx8y5;
        playerBoardImageViews[8][6] = playerBoardx8y6;
        playerBoardImageViews[8][7] = playerBoardx8y7;
        playerBoardImageViews[8][8] = playerBoardx8y8;
        playerBoardImageViews[8][9] = playerBoardx8y9;

        playerBoardImageViews[9][0] = playerBoardx9y0;
        playerBoardImageViews[9][1] = playerBoardx9y1;
        playerBoardImageViews[9][2] = playerBoardx9y2;
        playerBoardImageViews[9][3] = playerBoardx9y3;
        playerBoardImageViews[9][4] = playerBoardx9y4;
        playerBoardImageViews[9][5] = playerBoardx9y5;
        playerBoardImageViews[9][6] = playerBoardx9y6;
        playerBoardImageViews[9][7] = playerBoardx9y7;
        playerBoardImageViews[9][8] = playerBoardx9y8;
        playerBoardImageViews[9][9] = playerBoardx9y9;

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(App.getActiveGameplay().getPlayerBoard().get(i + (j * 10)).isShip()) {
                    playerBoardImageViews[i][j].setImage(shipModuleImage);
                }
            }
        }
    }

    @FXML
    private void shotAtOpponentsBoard(MouseEvent event) {

    }
}