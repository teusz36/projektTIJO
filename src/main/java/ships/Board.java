package ships;

import java.util.ArrayList;
import java.util.Dictionary;

public class Board {
    public static final String UP = "UP";
    public static final String RIGHT = "RIGHT";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    public ArrayList<Field> fields;

    public Board() {
        fields = new ArrayList<>();
        for(int i = 0; i < 100; i ++) {
            fields.add(new Field());
        }
    }

    public boolean isShipSunk(int coordinateX, int coordinateY) {
        return !fields.get(coordinateX + (coordinateY * 10)).isActive();
    }

    public boolean canPlaceShip(int numberOfMasts, int coordinateX, int coordinateY, String direction) {
        try {
            if(!fields.get(coordinateX + coordinateY * 10).isShip()) {
                switch (direction) {
                    case Board.UP:
                        if (coordinateY - numberOfMasts >= -1) {
                            for (int i = 0; i < numberOfMasts; i++) {
                                if (fields.get(coordinateX + ((coordinateY - i) * 10)).isShip()) {
                                    return false;
                                } else {
                                    if (isShipAround(coordinateX, coordinateY - i)) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                        return false;
                    case Board.LEFT:
                        if (coordinateX - numberOfMasts >= -1) {
                            for (int i = 0; i < numberOfMasts; i++) {
                                if (fields.get(coordinateX - i + (coordinateY * 10)).isShip()) {
                                    return false;
                                } else {
                                    if (isShipAround(coordinateX - i, coordinateY)) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                        return false;
                    case Board.DOWN:
                        if (coordinateY + numberOfMasts <= 10) {
                            for (int i = 0; i < numberOfMasts; i++) {
                                if (fields.get(coordinateX + ((coordinateY + i) * 10)).isShip()) {
                                    return false;
                                } else {
                                    if (isShipAround(coordinateX, coordinateY + i)) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                        return false;
                    case Board.RIGHT:
                        if (coordinateX + numberOfMasts <= 10) {
                            for (int i = 0; i < numberOfMasts; i++) {
                                if (fields.get(coordinateX + i + (coordinateY * 10)).isShip()) {
                                    return false;
                                } else {
                                    if (isShipAround(coordinateX + i, coordinateY)) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                        return false;
                }
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
        return false;
    }

    public boolean isShipAround(int x, int y) {
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(!(i == 0 && j == 0)) {
                    int index = x + i + ((y + j) * 10);
                    try {
                        if (x + i >= 0 && x + i <= 10 && y + j >= 0 && y + j <= 10) {
                            if (fields.get(index) != null) {
                                if (fields.get(index).isShip()) {
                                    return true;
                                }
                            }
                        }
                    } catch (Exception exception) {
                    }
                }
            }
        }
        return false;
    }

    public boolean generateShip(int numberOfMasts, int coordinateX, int coordinateY, String direction) {
        if(canPlaceShip(numberOfMasts, coordinateX, coordinateY, direction)) {
            switch (direction) {
                case Board.UP:
                    for(int i = 0; i < numberOfMasts; i++) {
                        fields.get(coordinateX + ((coordinateY - i) * 10)).ship(true);
                    }
                    break;
                case Board.LEFT:
                    for(int i = 0; i < numberOfMasts; i++) {
                        fields.get(coordinateX - i + ((coordinateY) * 10)).ship(true);
                    }
                    break;
                case Board.DOWN:
                    for(int i = 0; i < numberOfMasts; i++) {
                        fields.get(coordinateX + ((coordinateY + i) * 10)).ship(true);
                    }
                    break;
                case Board.RIGHT:
                    for(int i = 0; i < numberOfMasts; i++) {
                        fields.get(coordinateX + i + ((coordinateY) * 10)).ship(true);
                    }
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    public Board generateAIBoard() {
        return new Board();
    }

    public Board generateAIBoard(int i) {
        return new Board();
    }

    public boolean shot(int coordinateX, int coordinateY) {
        return false;
    }

    public boolean checkForShipsHit() {
        return false;
    }

    public Board getBoard() {
        return this;
    }

    public Field get(int i) {
        return fields.get(i);
    }
}
