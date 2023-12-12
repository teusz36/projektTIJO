package org.openjfx;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ships.Board;

public class CreateBoardController {

    @FXML HBox HBox1Masts;
    @FXML HBox HBox2Masts;
    @FXML HBox HBox3Masts;
    @FXML HBox HBox4Masts;

    @FXML Label createBoard1MastsLeftNumber, createBoard2MastsLeftNumber, createBoard3MastsLeftNumber, createBoard4MastsLeftNumber;

    @FXML ImageView createBoardx0y0, createBoardx0y1, createBoardx0y2, createBoardx0y3, createBoardx0y4, createBoardx0y5, createBoardx0y6, createBoardx0y7, createBoardx0y8, createBoardx0y9, createBoardx1y0, createBoardx1y1, createBoardx1y2, createBoardx1y3, createBoardx1y4, createBoardx1y5, createBoardx1y6, createBoardx1y7, createBoardx1y8, createBoardx1y9, createBoardx2y0, createBoardx2y1, createBoardx2y2, createBoardx2y3, createBoardx2y4, createBoardx2y5, createBoardx2y6, createBoardx2y7, createBoardx2y8, createBoardx2y9, createBoardx3y0, createBoardx3y1, createBoardx3y2, createBoardx3y3, createBoardx3y4, createBoardx3y5, createBoardx3y6, createBoardx3y7, createBoardx3y8, createBoardx3y9, createBoardx4y0, createBoardx4y1, createBoardx4y2, createBoardx4y3, createBoardx4y4, createBoardx4y5, createBoardx4y6, createBoardx4y7, createBoardx4y8, createBoardx4y9, createBoardx5y0, createBoardx5y1, createBoardx5y2, createBoardx5y3, createBoardx5y4, createBoardx5y5, createBoardx5y6, createBoardx5y7, createBoardx5y8, createBoardx5y9, createBoardx6y0, createBoardx6y1, createBoardx6y2, createBoardx6y3, createBoardx6y4, createBoardx6y5, createBoardx6y6, createBoardx6y7, createBoardx6y8, createBoardx6y9, createBoardx7y0, createBoardx7y1, createBoardx7y2, createBoardx7y3, createBoardx7y4, createBoardx7y5, createBoardx7y6, createBoardx7y7, createBoardx7y8, createBoardx7y9, createBoardx8y0, createBoardx8y1, createBoardx8y2, createBoardx8y3, createBoardx8y4, createBoardx8y5, createBoardx8y6, createBoardx8y7, createBoardx8y8, createBoardx8y9, createBoardx9y0, createBoardx9y1, createBoardx9y2, createBoardx9y3, createBoardx9y4, createBoardx9y5, createBoardx9y6, createBoardx9y7, createBoardx9y8, createBoardx9y9;

    private boolean isShipSelected;
    private int selectedShipMasts;
    private String direction;
    private Image shipModuleInactiveImage = new Image(getClass().getResourceAsStream("/ship_module_inactive.png"));
    private Image shipModuleImage = new Image(getClass().getResourceAsStream("/ship_module.png"));
    private int numberOf1MastsShipsLeft = 4;
    private int numberOf2MastsShipsLeft = 3;
    private int numberOf3MastsShipsLeft = 2;
    private int numberOf4MastsShipsLeft = 1;

    private Board board;
    private ImageView[][] boardImageViews;

    @FXML
    private void initialize() {
        direction = Board.UP;
        board = new Board();
        boardImageViews = new ImageView[10][10];
        boardImageViews[0][0] = createBoardx0y0;
        boardImageViews[0][1] = createBoardx0y1;
        boardImageViews[0][2] = createBoardx0y2;
        boardImageViews[0][3] = createBoardx0y3;
        boardImageViews[0][4] = createBoardx0y4;
        boardImageViews[0][5] = createBoardx0y5;
        boardImageViews[0][6] = createBoardx0y6;
        boardImageViews[0][7] = createBoardx0y7;
        boardImageViews[0][8] = createBoardx0y8;
        boardImageViews[0][9] = createBoardx0y9;

        boardImageViews[1][0] = createBoardx1y0;
        boardImageViews[1][1] = createBoardx1y1;
        boardImageViews[1][2] = createBoardx1y2;
        boardImageViews[1][3] = createBoardx1y3;
        boardImageViews[1][4] = createBoardx1y4;
        boardImageViews[1][5] = createBoardx1y5;
        boardImageViews[1][6] = createBoardx1y6;
        boardImageViews[1][7] = createBoardx1y7;
        boardImageViews[1][8] = createBoardx1y8;
        boardImageViews[1][9] = createBoardx1y9;

        boardImageViews[2][0] = createBoardx2y0;
        boardImageViews[2][1] = createBoardx2y1;
        boardImageViews[2][2] = createBoardx2y2;
        boardImageViews[2][3] = createBoardx2y3;
        boardImageViews[2][4] = createBoardx2y4;
        boardImageViews[2][5] = createBoardx2y5;
        boardImageViews[2][6] = createBoardx2y6;
        boardImageViews[2][7] = createBoardx2y7;
        boardImageViews[2][8] = createBoardx2y8;
        boardImageViews[2][9] = createBoardx2y9;

        boardImageViews[3][0] = createBoardx3y0;
        boardImageViews[3][1] = createBoardx3y1;
        boardImageViews[3][2] = createBoardx3y2;
        boardImageViews[3][3] = createBoardx3y3;
        boardImageViews[3][4] = createBoardx3y4;
        boardImageViews[3][5] = createBoardx3y5;
        boardImageViews[3][6] = createBoardx3y6;
        boardImageViews[3][7] = createBoardx3y7;
        boardImageViews[3][8] = createBoardx3y8;
        boardImageViews[3][9] = createBoardx3y9;

        boardImageViews[4][0] = createBoardx4y0;
        boardImageViews[4][1] = createBoardx4y1;
        boardImageViews[4][2] = createBoardx4y2;
        boardImageViews[4][3] = createBoardx4y3;
        boardImageViews[4][4] = createBoardx4y4;
        boardImageViews[4][5] = createBoardx4y5;
        boardImageViews[4][6] = createBoardx4y6;
        boardImageViews[4][7] = createBoardx4y7;
        boardImageViews[4][8] = createBoardx4y8;
        boardImageViews[4][9] = createBoardx4y9;

        boardImageViews[5][0] = createBoardx5y0;
        boardImageViews[5][1] = createBoardx5y1;
        boardImageViews[5][2] = createBoardx5y2;
        boardImageViews[5][3] = createBoardx5y3;
        boardImageViews[5][4] = createBoardx5y4;
        boardImageViews[5][5] = createBoardx5y5;
        boardImageViews[5][6] = createBoardx5y6;
        boardImageViews[5][7] = createBoardx5y7;
        boardImageViews[5][8] = createBoardx5y8;
        boardImageViews[5][9] = createBoardx5y9;

        boardImageViews[6][0] = createBoardx6y0;
        boardImageViews[6][1] = createBoardx6y1;
        boardImageViews[6][2] = createBoardx6y2;
        boardImageViews[6][3] = createBoardx6y3;
        boardImageViews[6][4] = createBoardx6y4;
        boardImageViews[6][5] = createBoardx6y5;
        boardImageViews[6][6] = createBoardx6y6;
        boardImageViews[6][7] = createBoardx6y7;
        boardImageViews[6][8] = createBoardx6y8;
        boardImageViews[6][9] = createBoardx6y9;

        boardImageViews[7][0] = createBoardx7y0;
        boardImageViews[7][1] = createBoardx7y1;
        boardImageViews[7][2] = createBoardx7y2;
        boardImageViews[7][3] = createBoardx7y3;
        boardImageViews[7][4] = createBoardx7y4;
        boardImageViews[7][5] = createBoardx7y5;
        boardImageViews[7][6] = createBoardx7y6;
        boardImageViews[7][7] = createBoardx7y7;
        boardImageViews[7][8] = createBoardx7y8;
        boardImageViews[7][9] = createBoardx7y9;

        boardImageViews[8][0] = createBoardx8y0;
        boardImageViews[8][1] = createBoardx8y1;
        boardImageViews[8][2] = createBoardx8y2;
        boardImageViews[8][3] = createBoardx8y3;
        boardImageViews[8][4] = createBoardx8y4;
        boardImageViews[8][5] = createBoardx8y5;
        boardImageViews[8][6] = createBoardx8y6;
        boardImageViews[8][7] = createBoardx8y7;
        boardImageViews[8][8] = createBoardx8y8;
        boardImageViews[8][9] = createBoardx8y9;

        boardImageViews[9][0] = createBoardx9y0;
        boardImageViews[9][1] = createBoardx9y1;
        boardImageViews[9][2] = createBoardx9y2;
        boardImageViews[9][3] = createBoardx9y3;
        boardImageViews[9][4] = createBoardx9y4;
        boardImageViews[9][5] = createBoardx9y5;
        boardImageViews[9][6] = createBoardx9y6;
        boardImageViews[9][7] = createBoardx9y7;
        boardImageViews[9][8] = createBoardx9y8;
        boardImageViews[9][9] = createBoardx9y9;
    }

    @FXML
    private void startGame() throws IOException {
        App.getActiveGameplay().setPlayerBoard(board);
        App.setRoot("game");
    }

    @FXML
    private void selectShipToPlace(MouseEvent event) {
        HBox1Masts.setStyle("-fx-background-color: white;");
        HBox2Masts.setStyle("-fx-background-color: white;");
        HBox3Masts.setStyle("-fx-background-color: white;");
        HBox4Masts.setStyle("-fx-background-color: white;");
        ((HBox)(event.getSource())).setStyle("-fx-background-color: lightblue;");
        switch(((HBox)(event.getSource())).getId().charAt(4)) {
            case '1':
                if(numberOf1MastsShipsLeft > 0) {
                    selectedShipMasts = 1;
                    isShipSelected = true;
                } else {
                    isShipSelected = false;
                }
                break;
            case '2':
                if(numberOf2MastsShipsLeft > 0) {
                    selectedShipMasts = 2;
                    isShipSelected = true;
                } else {
                    isShipSelected = false;
                }
                break;
            case '3':
                if(numberOf3MastsShipsLeft > 0) {
                    selectedShipMasts = 3;
                    isShipSelected = true;
                } else {
                    isShipSelected = false;
                }
                break;
            case '4':
                if(numberOf4MastsShipsLeft > 0) {
                    selectedShipMasts = 4;
                    isShipSelected = true;
                } else {
                    isShipSelected = false;
                }
                break;
        }
    }

    @FXML
    private void putShipOrRotate(MouseEvent event) {
        if(isShipSelected) {
            if (event.getButton() == MouseButton.SECONDARY) {
                    if (direction.equals(Board.UP)) {
                        direction = Board.RIGHT;
                    } else if (direction.equals(Board.RIGHT)) {
                        direction = Board.DOWN;
                    } else if (direction.equals(Board.DOWN)) {
                        direction = Board.LEFT;
                    } else if (direction.equals(Board.LEFT)) {
                        direction = Board.UP;
                    }
                int x = Integer.parseInt(((ImageView) (event.getSource())).getId().charAt(12) + "");
                int y = Integer.parseInt(((ImageView) (event.getSource())).getId().charAt(14) + "");
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (!board.fields.get(i + (j * 10)).isShip()) {
                            boardImageViews[i][j].setImage(null);
                        }
                    }
                }
                displayShip(x, y);
            } else if (event.getButton() == MouseButton.PRIMARY) {
                int x = Integer.parseInt(((ImageView) (event.getSource())).getId().charAt(12) + "");
                int y = Integer.parseInt(((ImageView) (event.getSource())).getId().charAt(14) + "");
                if(board.canPlaceShip(selectedShipMasts, x, y, direction)) {
                    board.generateShip(selectedShipMasts, x, y, direction);
                    switch (selectedShipMasts) {
                        case 4:
                            numberOf4MastsShipsLeft--;
                            createBoard4MastsLeftNumber.setText(numberOf4MastsShipsLeft + "");
                            if (numberOf4MastsShipsLeft < 1) {
                                isShipSelected = false;
                            } else {
                                isShipSelected = true;
                            }
                            break;
                        case 3:
                            numberOf3MastsShipsLeft--;
                            createBoard3MastsLeftNumber.setText(numberOf3MastsShipsLeft + "");
                            if (numberOf3MastsShipsLeft < 1) {
                                isShipSelected = false;
                            } else {
                                isShipSelected = true;
                            }
                            break;
                        case 2:
                            numberOf2MastsShipsLeft--;
                            createBoard2MastsLeftNumber.setText(numberOf2MastsShipsLeft + "");
                            if (numberOf2MastsShipsLeft < 1) {
                                isShipSelected = false;
                            } else {
                                isShipSelected = true;
                            }
                            break;
                        case 1:
                            numberOf1MastsShipsLeft--;
                            createBoard1MastsLeftNumber.setText(numberOf1MastsShipsLeft + "");
                            if (numberOf1MastsShipsLeft < 1) {
                                isShipSelected = false;
                            } else {
                                isShipSelected = true;
                            }
                            break;
                    }
                    refreshBoard();
                }
            }
        }
    }

    @FXML
    private void refreshBoard() {
        for(int i = 0; i < 100; i ++) {
            if(board.fields.get(i).isShip()){
                boardImageViews[i%10][i/10].setImage(shipModuleImage);
            } else {
                boardImageViews[i%10][i/10].setImage(null);
            }
        }
    }

    @FXML
    private void fieldHover(MouseEvent event) {
        int x = Integer.parseInt(((ImageView)(event.getSource())).getId().charAt(12)+"");
        int y = Integer.parseInt(((ImageView)(event.getSource())).getId().charAt(14)+"");
        displayShip(x, y);
    }

    @FXML
    private void fieldUnHover() {
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                if(boardImageViews[x][y].getImage() != null) {
                    if(!board.fields.get(x + (y * 10)).isShip()) {
                        boardImageViews[x][y].setImage(null);
                    }
                }
            }
        }
    }

    @FXML
    private void displayShip(int x, int y) {
        if(board.canPlaceShip(selectedShipMasts, x, y, direction) && isShipSelected) {
            switch (selectedShipMasts) {
                case 1:
                    if(!board.fields.get(x + (y * 10)).isShip() && numberOf1MastsShipsLeft > 0) {boardImageViews[x][y].setImage(shipModuleInactiveImage);}
                    break;
                case 2:
                    if(numberOf2MastsShipsLeft > 0) {
                        switch (direction) {
                            case Board.UP:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y - 1) * 10)).isShip()) {
                                    boardImageViews[x][y - 1].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.LEFT:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x - 1 + (y * 10)).isShip()) {
                                    boardImageViews[x - 1][y].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.DOWN:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y + 1) * 10)).isShip()) {
                                    boardImageViews[x][y + 1].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.RIGHT:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + 1 + (y * 10)).isShip()) {
                                    boardImageViews[x + 1][y].setImage(shipModuleInactiveImage);
                                }
                                break;
                        }
                    }
                    break;
                case 3:
                    if(numberOf3MastsShipsLeft > 0) {
                        switch (direction) {
                            case Board.UP:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y - 1) * 10)).isShip()) {
                                    boardImageViews[x][y - 1].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y - 2) * 10)).isShip()) {
                                    boardImageViews[x][y - 2].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.LEFT:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x - 1 + (y * 10)).isShip()) {
                                    boardImageViews[x - 1][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x - 2 + (y * 10)).isShip()) {
                                    boardImageViews[x - 2][y].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.DOWN:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y + 1) * 10)).isShip()) {
                                    boardImageViews[x][y + 1].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y + 2) * 10)).isShip()) {
                                    boardImageViews[x][y + 2].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.RIGHT:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + 1 + (y * 10)).isShip()) {
                                    boardImageViews[x + 1][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + 2 + (y * 10)).isShip()) {
                                    boardImageViews[x + 2][y].setImage(shipModuleInactiveImage);
                                }
                                break;
                        }
                    }
                    break;
                case 4:
                    if(numberOf4MastsShipsLeft > 0) {
                        switch (direction) {
                            case Board.UP:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y - 1) * 10)).isShip()) {
                                    boardImageViews[x][y - 1].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y - 2) * 10)).isShip()) {
                                    boardImageViews[x][y - 2].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y - 3) * 10)).isShip()) {
                                    boardImageViews[x][y - 3].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.LEFT:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x - 1 + (y * 10)).isShip()) {
                                    boardImageViews[x - 1][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x - 2 + (y * 10)).isShip()) {
                                    boardImageViews[x - 2][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x - 3 + (y * 10)).isShip()) {
                                    boardImageViews[x - 3][y].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.DOWN:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y + 1) * 10)).isShip()) {
                                    boardImageViews[x][y + 1].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y + 2) * 10)).isShip()) {
                                    boardImageViews[x][y + 2].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + ((y + 3) * 10)).isShip()) {
                                    boardImageViews[x][y + 3].setImage(shipModuleInactiveImage);
                                }
                                break;
                            case Board.RIGHT:
                                if (!board.fields.get(x + (y * 10)).isShip()) {
                                    boardImageViews[x][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + 1 + (y * 10)).isShip()) {
                                    boardImageViews[x + 1][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + 2 + (y * 10)).isShip()) {
                                    boardImageViews[x + 2][y].setImage(shipModuleInactiveImage);
                                }
                                if (!board.fields.get(x + 3 + (y * 10)).isShip()) {
                                    boardImageViews[x + 3][y].setImage(shipModuleInactiveImage);
                                }
                                break;
                        }
                    }
                    break;
            }
        }
    }
}