package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ships.Board;
import ships.Gameplay;


public class GameController {

    @FXML
    ImageView playerBoardx0y0, playerBoardx0y1, playerBoardx0y2, playerBoardx0y3, playerBoardx0y4, playerBoardx0y5, playerBoardx0y6, playerBoardx0y7, playerBoardx0y8, playerBoardx0y9, playerBoardx1y0, playerBoardx1y1, playerBoardx1y2, playerBoardx1y3, playerBoardx1y4, playerBoardx1y5, playerBoardx1y6, playerBoardx1y7, playerBoardx1y8, playerBoardx1y9, playerBoardx2y0, playerBoardx2y1, playerBoardx2y2, playerBoardx2y3, playerBoardx2y4, playerBoardx2y5, playerBoardx2y6, playerBoardx2y7, playerBoardx2y8, playerBoardx2y9, playerBoardx3y0, playerBoardx3y1, playerBoardx3y2, playerBoardx3y3, playerBoardx3y4, playerBoardx3y5, playerBoardx3y6, playerBoardx3y7, playerBoardx3y8, playerBoardx3y9, playerBoardx4y0, playerBoardx4y1, playerBoardx4y2, playerBoardx4y3, playerBoardx4y4, playerBoardx4y5, playerBoardx4y6, playerBoardx4y7, playerBoardx4y8, playerBoardx4y9, playerBoardx5y0, playerBoardx5y1, playerBoardx5y2, playerBoardx5y3, playerBoardx5y4, playerBoardx5y5, playerBoardx5y6, playerBoardx5y7, playerBoardx5y8, playerBoardx5y9, playerBoardx6y0, playerBoardx6y1, playerBoardx6y2, playerBoardx6y3, playerBoardx6y4, playerBoardx6y5, playerBoardx6y6, playerBoardx6y7, playerBoardx6y8, playerBoardx6y9, playerBoardx7y0, playerBoardx7y1, playerBoardx7y2, playerBoardx7y3, playerBoardx7y4, playerBoardx7y5, playerBoardx7y6, playerBoardx7y7, playerBoardx7y8, playerBoardx7y9, playerBoardx8y0, playerBoardx8y1, playerBoardx8y2, playerBoardx8y3, playerBoardx8y4, playerBoardx8y5, playerBoardx8y6, playerBoardx8y7, playerBoardx8y8, playerBoardx8y9, playerBoardx9y0, playerBoardx9y1, playerBoardx9y2, playerBoardx9y3, playerBoardx9y4, playerBoardx9y5, playerBoardx9y6, playerBoardx9y7, playerBoardx9y8, playerBoardx9y9;

    @FXML
    ImageView opponentBoardx0y0, opponentBoardx0y1, opponentBoardx0y2, opponentBoardx0y3, opponentBoardx0y4, opponentBoardx0y5, opponentBoardx0y6, opponentBoardx0y7, opponentBoardx0y8, opponentBoardx0y9, opponentBoardx1y0, opponentBoardx1y1, opponentBoardx1y2, opponentBoardx1y3, opponentBoardx1y4, opponentBoardx1y5, opponentBoardx1y6, opponentBoardx1y7, opponentBoardx1y8, opponentBoardx1y9, opponentBoardx2y0, opponentBoardx2y1, opponentBoardx2y2, opponentBoardx2y3, opponentBoardx2y4, opponentBoardx2y5, opponentBoardx2y6, opponentBoardx2y7, opponentBoardx2y8, opponentBoardx2y9, opponentBoardx3y0, opponentBoardx3y1, opponentBoardx3y2, opponentBoardx3y3, opponentBoardx3y4, opponentBoardx3y5, opponentBoardx3y6, opponentBoardx3y7, opponentBoardx3y8, opponentBoardx3y9, opponentBoardx4y0, opponentBoardx4y1, opponentBoardx4y2, opponentBoardx4y3, opponentBoardx4y4, opponentBoardx4y5, opponentBoardx4y6, opponentBoardx4y7, opponentBoardx4y8, opponentBoardx4y9, opponentBoardx5y0, opponentBoardx5y1, opponentBoardx5y2, opponentBoardx5y3, opponentBoardx5y4, opponentBoardx5y5, opponentBoardx5y6, opponentBoardx5y7, opponentBoardx5y8, opponentBoardx5y9, opponentBoardx6y0, opponentBoardx6y1, opponentBoardx6y2, opponentBoardx6y3, opponentBoardx6y4, opponentBoardx6y5, opponentBoardx6y6, opponentBoardx6y7, opponentBoardx6y8, opponentBoardx6y9, opponentBoardx7y0, opponentBoardx7y1, opponentBoardx7y2, opponentBoardx7y3, opponentBoardx7y4, opponentBoardx7y5, opponentBoardx7y6, opponentBoardx7y7, opponentBoardx7y8, opponentBoardx7y9, opponentBoardx8y0, opponentBoardx8y1, opponentBoardx8y2, opponentBoardx8y3, opponentBoardx8y4, opponentBoardx8y5, opponentBoardx8y6, opponentBoardx8y7, opponentBoardx8y8, opponentBoardx8y9, opponentBoardx9y0, opponentBoardx9y1, opponentBoardx9y2, opponentBoardx9y3, opponentBoardx9y4, opponentBoardx9y5, opponentBoardx9y6, opponentBoardx9y7, opponentBoardx9y8, opponentBoardx9y9;

    @FXML Label labelTurn;

    ImageView[][] playerBoardImageViews;
    ImageView[][] opponentBoardImageViews;
    private Image shipModuleImage = new Image(getClass().getResourceAsStream("/ship_module.png"));
    private Image shipModuleHitImage = new Image(getClass().getResourceAsStream("/ship_module_hit.png"));
    private Image missImage = new Image(getClass().getResourceAsStream("/miss.png"));

    
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

        opponentBoardImageViews = new ImageView[10][10];
        opponentBoardImageViews[0][0] = opponentBoardx0y0;
        opponentBoardImageViews[0][1] = opponentBoardx0y1;
        opponentBoardImageViews[0][2] = opponentBoardx0y2;
        opponentBoardImageViews[0][3] = opponentBoardx0y3;
        opponentBoardImageViews[0][4] = opponentBoardx0y4;
        opponentBoardImageViews[0][5] = opponentBoardx0y5;
        opponentBoardImageViews[0][6] = opponentBoardx0y6;
        opponentBoardImageViews[0][7] = opponentBoardx0y7;
        opponentBoardImageViews[0][8] = opponentBoardx0y8;
        opponentBoardImageViews[0][9] = opponentBoardx0y9;

        opponentBoardImageViews[1][0] = opponentBoardx1y0;
        opponentBoardImageViews[1][1] = opponentBoardx1y1;
        opponentBoardImageViews[1][2] = opponentBoardx1y2;
        opponentBoardImageViews[1][3] = opponentBoardx1y3;
        opponentBoardImageViews[1][4] = opponentBoardx1y4;
        opponentBoardImageViews[1][5] = opponentBoardx1y5;
        opponentBoardImageViews[1][6] = opponentBoardx1y6;
        opponentBoardImageViews[1][7] = opponentBoardx1y7;
        opponentBoardImageViews[1][8] = opponentBoardx1y8;
        opponentBoardImageViews[1][9] = opponentBoardx1y9;

        opponentBoardImageViews[2][0] = opponentBoardx2y0;
        opponentBoardImageViews[2][1] = opponentBoardx2y1;
        opponentBoardImageViews[2][2] = opponentBoardx2y2;
        opponentBoardImageViews[2][3] = opponentBoardx2y3;
        opponentBoardImageViews[2][4] = opponentBoardx2y4;
        opponentBoardImageViews[2][5] = opponentBoardx2y5;
        opponentBoardImageViews[2][6] = opponentBoardx2y6;
        opponentBoardImageViews[2][7] = opponentBoardx2y7;
        opponentBoardImageViews[2][8] = opponentBoardx2y8;
        opponentBoardImageViews[2][9] = opponentBoardx2y9;

        opponentBoardImageViews[3][0] = opponentBoardx3y0;
        opponentBoardImageViews[3][1] = opponentBoardx3y1;
        opponentBoardImageViews[3][2] = opponentBoardx3y2;
        opponentBoardImageViews[3][3] = opponentBoardx3y3;
        opponentBoardImageViews[3][4] = opponentBoardx3y4;
        opponentBoardImageViews[3][5] = opponentBoardx3y5;
        opponentBoardImageViews[3][6] = opponentBoardx3y6;
        opponentBoardImageViews[3][7] = opponentBoardx3y7;
        opponentBoardImageViews[3][8] = opponentBoardx3y8;
        opponentBoardImageViews[3][9] = opponentBoardx3y9;

        opponentBoardImageViews[4][0] = opponentBoardx4y0;
        opponentBoardImageViews[4][1] = opponentBoardx4y1;
        opponentBoardImageViews[4][2] = opponentBoardx4y2;
        opponentBoardImageViews[4][3] = opponentBoardx4y3;
        opponentBoardImageViews[4][4] = opponentBoardx4y4;
        opponentBoardImageViews[4][5] = opponentBoardx4y5;
        opponentBoardImageViews[4][6] = opponentBoardx4y6;
        opponentBoardImageViews[4][7] = opponentBoardx4y7;
        opponentBoardImageViews[4][8] = opponentBoardx4y8;
        opponentBoardImageViews[4][9] = opponentBoardx4y9;

        opponentBoardImageViews[5][0] = opponentBoardx5y0;
        opponentBoardImageViews[5][1] = opponentBoardx5y1;
        opponentBoardImageViews[5][2] = opponentBoardx5y2;
        opponentBoardImageViews[5][3] = opponentBoardx5y3;
        opponentBoardImageViews[5][4] = opponentBoardx5y4;
        opponentBoardImageViews[5][5] = opponentBoardx5y5;
        opponentBoardImageViews[5][6] = opponentBoardx5y6;
        opponentBoardImageViews[5][7] = opponentBoardx5y7;
        opponentBoardImageViews[5][8] = opponentBoardx5y8;
        opponentBoardImageViews[5][9] = opponentBoardx5y9;

        opponentBoardImageViews[6][0] = opponentBoardx6y0;
        opponentBoardImageViews[6][1] = opponentBoardx6y1;
        opponentBoardImageViews[6][2] = opponentBoardx6y2;
        opponentBoardImageViews[6][3] = opponentBoardx6y3;
        opponentBoardImageViews[6][4] = opponentBoardx6y4;
        opponentBoardImageViews[6][5] = opponentBoardx6y5;
        opponentBoardImageViews[6][6] = opponentBoardx6y6;
        opponentBoardImageViews[6][7] = opponentBoardx6y7;
        opponentBoardImageViews[6][8] = opponentBoardx6y8;
        opponentBoardImageViews[6][9] = opponentBoardx6y9;

        opponentBoardImageViews[7][0] = opponentBoardx7y0;
        opponentBoardImageViews[7][1] = opponentBoardx7y1;
        opponentBoardImageViews[7][2] = opponentBoardx7y2;
        opponentBoardImageViews[7][3] = opponentBoardx7y3;
        opponentBoardImageViews[7][4] = opponentBoardx7y4;
        opponentBoardImageViews[7][5] = opponentBoardx7y5;
        opponentBoardImageViews[7][6] = opponentBoardx7y6;
        opponentBoardImageViews[7][7] = opponentBoardx7y7;
        opponentBoardImageViews[7][8] = opponentBoardx7y8;
        opponentBoardImageViews[7][9] = opponentBoardx7y9;

        opponentBoardImageViews[8][0] = opponentBoardx8y0;
        opponentBoardImageViews[8][1] = opponentBoardx8y1;
        opponentBoardImageViews[8][2] = opponentBoardx8y2;
        opponentBoardImageViews[8][3] = opponentBoardx8y3;
        opponentBoardImageViews[8][4] = opponentBoardx8y4;
        opponentBoardImageViews[8][5] = opponentBoardx8y5;
        opponentBoardImageViews[8][6] = opponentBoardx8y6;
        opponentBoardImageViews[8][7] = opponentBoardx8y7;
        opponentBoardImageViews[8][8] = opponentBoardx8y8;
        opponentBoardImageViews[8][9] = opponentBoardx8y9;

        opponentBoardImageViews[9][0] = opponentBoardx9y0;
        opponentBoardImageViews[9][1] = opponentBoardx9y1;
        opponentBoardImageViews[9][2] = opponentBoardx9y2;
        opponentBoardImageViews[9][3] = opponentBoardx9y3;
        opponentBoardImageViews[9][4] = opponentBoardx9y4;
        opponentBoardImageViews[9][5] = opponentBoardx9y5;
        opponentBoardImageViews[9][6] = opponentBoardx9y6;
        opponentBoardImageViews[9][7] = opponentBoardx9y7;
        opponentBoardImageViews[9][8] = opponentBoardx9y8;
        opponentBoardImageViews[9][9] = opponentBoardx9y9;

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(App.getActiveGameplay().getPlayerBoard().get(i + (j * 10)).isShip()) {
                    playerBoardImageViews[i][j].setImage(shipModuleImage);
                }
            }
        }

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(App.getActiveGameplay().getAIBoard().get(i + (j * 10)).isShip()) {
                    opponentBoardImageViews[i][j].setImage(shipModuleImage);
                }
            }
        }
    }

    @FXML
    private void shotAtOpponentsBoard(MouseEvent event) {
        if(App.getActiveGameplay().currentTurn().equals(Gameplay.PLAYER)) {
            int x = Integer.parseInt(((ImageView) (event.getSource())).getId().charAt(14) + "");
            int y = Integer.parseInt(((ImageView) (event.getSource())).getId().charAt(16) + "");
            if(App.getActiveGameplay().getAIBoard().get(x + (y * 10)).isActive()) {
                boolean hit = App.getActiveGameplay().getAIBoard().shot(x, y);
                if(hit) {
                    opponentBoardImageViews[x][y].setImage(shipModuleHitImage);
                    if(App.getActiveGameplay().getAIBoard().isShipSunk(x, y)) {
                        updateFieldsAfterSunk(App.getActiveGameplay().getAIBoard(), x, y);
                    }
                } else {
                    opponentBoardImageViews[x][y].setImage(missImage);
                    App.getActiveGameplay().setCurrentTurn(Gameplay.AI);
                }
            }
        }
    }

    private void updateFieldsAfterSunk(Board board, int x, int y) {
        boolean goLeft = false, goRight = false, goUp = false, goDown = false;

        if(x - 1 >= 0) {
            goLeft = board.fields.get(x - 1 + (y * 10)).isShip();
        } else {
            goLeft = false;
        }

        if(x + 1 <= 9) {
            goRight = board.fields.get(x + 1 + (y * 10)).isShip();
        } else {
            goRight = false;
        }

        if(y - 1 >= 0) {
            goUp = board.fields.get(x + ((y - 1) * 10)).isShip();
        } else {
            goUp = false;
        }

        if(y + 1 <= 9) {
            goDown = board.fields.get(x + ((y + 1) * 10)).isShip();
        } else {
            goDown = false;
        }

        if(goLeft) {
            boolean checkNextField = true;
            int i = 0;
            while (checkNextField) {
                if(x + i >= 0) {
                    if(board.fields.get(x + i + (y * 10)).isShip()) {
                        for(int ii = -1; ii < 2; ii++) {
                            for (int j = -1; j < 2; j++) {
                                if(!(ii == 0 & j == 0)) {
                                    try {
                                        int index = (x + i + ii) + ((y + j) * 10);
                                        if(!board.get(index).isShip()) {
                                            board.get(x + i + ii + ((y + j) * 10)).shot();
                                            opponentBoardImageViews[x + i + ii][y + j].setImage(missImage);
                                        }
                                    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                    }
                                }
                            }
                        }
                        i--;
                    } else {
                        checkNextField = false;
                    }
                } else {
                    checkNextField = false;
                }
            }
        }

        if(goRight) {
            boolean checkNextField = true;
            int i = 0;
            while (checkNextField) {
                if(x + i <= 9) {
                    if(board.fields.get(x + i + (y * 10)).isShip()) {
                        for(int ii = -1; ii < 2; ii++) {
                            for (int j = -1; j < 2; j++) {
                                if(!(ii == 0 & j == 0)) {
                                    try {
                                        int index = (x + i + ii) + ((y + j) * 10);
                                        if(!board.get(index).isShip()) {
                                            board.get(x + i + ii + ((y + j) * 10)).shot();
                                            opponentBoardImageViews[x + i + ii][y + j].setImage(missImage);
                                        }
                                    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                    }
                                }
                            }
                        }
                        i++;
                    } else {
                        checkNextField = false;
                    }
                } else {
                    checkNextField = false;
                }
            }
        }

        if(goDown) {
            boolean checkNextField = true;
            int i = 0;
            while (checkNextField) {
                if(y + i <= 9) {
                    if(board.fields.get(x + ((y + i) * 10)).isShip()) {
                        for(int ii = -1; ii < 2; ii++) {
                            for (int j = -1; j < 2; j++) {
                                if(!(ii == 0 & j == 0)) {
                                    try {
                                        int index = (x + ii) + ((y + i + j) * 10);
                                        if(!board.get(index).isShip()) {
                                            board.get(x + ii + ((y + i + j) * 10)).shot();
                                            opponentBoardImageViews[x + ii][y + i + j].setImage(missImage);
                                        }
                                    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                    }
                                }
                            }
                        }
                        i++;
                    } else {
                        checkNextField = false;
                    }
                } else {
                    checkNextField = false;
                }
            }
        }

        if(goUp) {
            boolean checkNextField = true;
            int i = 0;
            while (checkNextField) {
                if(y + i >= 0) {
                    if(board.fields.get(x + ((y + i) * 10)).isShip()) {
                        for(int ii = -1; ii < 2; ii++) {
                            for (int j = -1; j < 2; j++) {
                                if(!(ii == 0 & j == 0)) {
                                    try {
                                        int index = (x + ii) + ((y + i + j) * 10);
                                        if(!board.get(index).isShip()) {
                                            board.get(x + ii + ((y + i + j) * 10)).shot();
                                            opponentBoardImageViews[x + ii][y + i + j].setImage(missImage);
                                        }
                                    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                    }
                                }
                            }
                        }
                        i--;
                    } else {
                        checkNextField = false;
                    }
                } else {
                    checkNextField = false;
                }
            }
        }

        if(!goLeft && !goRight && !goUp && !goDown) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (!(i == 0 & j == 0)) {
                        try {
                            int index = (x + i) + ((y + j) * 10);
                            if (!board.get(index).isShip()) {
                                board.get(x + i + ((y + j) * 10)).shot();
                                opponentBoardImageViews[x + i][y + j].setImage(missImage);
                            }
                        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        }
                    }
                }
            }
        }
    }
}