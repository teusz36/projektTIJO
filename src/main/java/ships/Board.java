package ships;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Random;

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
        boolean goLeft = false, goRight = false, goUp = false, goDown = false;

        if(coordinateX - 1 >= 0) {
            goLeft = fields.get(coordinateX - 1 + (coordinateY * 10)).isShip();
        } else {
            goLeft = false;
        }

        if(coordinateX + 1 <= 9) {
            goRight = fields.get(coordinateX + 1 + (coordinateY * 10)).isShip();
        } else {
            goRight = false;
        }

        if(coordinateY - 1 >= 0) {
            goUp = fields.get(coordinateX + ((coordinateY - 1) * 10)).isShip();
        } else {
            goUp = false;
        }

        if(coordinateY + 1 <= 9) {
            goDown = fields.get(coordinateX + ((coordinateY + 1) * 10)).isShip();
        } else {
            goDown = false;
        }

        if(goLeft) {
            boolean checkNextField = true;
            int i = -1;
            while (checkNextField) {
                if(coordinateX + i >= 0) {
                    if(fields.get(coordinateX + i + (coordinateY * 10)).isShip()) {
                        if(fields.get(coordinateX + i + (coordinateY * 10)).isActive()) {
                            return false;
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
            int i = 1;
            while (checkNextField) {
                if(coordinateX + i <= 9) {
                    if(fields.get(coordinateX + i + (coordinateY * 10)).isShip()) {
                        if(fields.get(coordinateX + i + (coordinateY * 10)).isActive()) {
                            return false;
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
            int i = -1;
            while (checkNextField) {
                if(coordinateY + i  >= 0) {
                    if(fields.get(coordinateX + ((coordinateY + i) * 10)).isShip()) {
                        if(fields.get(coordinateX + ((coordinateY + i) * 10)).isActive()) {
                            return false;
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

        if(goDown) {
            boolean checkNextField = true;
            int i = 1;
            while (checkNextField) {
                if(coordinateY + i <= 9) {
                    if(fields.get(coordinateX + ((coordinateY + i) * 10)).isShip()) {
                        if(fields.get(coordinateX + ((coordinateY + i) * 10)).isActive()) {
                            return false;
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

        return true;
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
                        if (x + i >= 0 && x + i <= 9 && y + j >= 0 && y + j <= 9) {
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
        Board AIBoard = new Board();
        Random rand = new Random();
        int boardNumber = rand.nextInt(10);
        String fileLine;
        String fileName = "./AIplansze/AI_plansza_"+boardNumber+".txt";
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            fileLine = in.readLine();
            in.close();
            for(int i=0; i< 100; i++){
                if(fileLine.charAt(i) != '0'){
                    AIBoard.get(i).ship(true);
                }
            }
        } catch (Exception e){
            System.out.println("Brak pliku");
        }
        return AIBoard;
    }

    public Board generateAIBoard(int boardNumber) {
        Board AIBoard = new Board();
        String fileLine;
        String fileName = "./AIplansze/AI_plansza_"+boardNumber+".txt";
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            fileLine = in.readLine();
            in.close();
            for(int i=0; i< 100; i++){
                if(fileLine.charAt(i) != '0'){
                    AIBoard.get(i).ship(true);
                }
            }
        } catch (Exception e){
            System.out.println("Brak pliku");
        }
        return AIBoard;
    }

    public boolean shot(int coordinateX, int coordinateY) {
        return fields.get(coordinateX + coordinateY * 10).shot();
    }

    public boolean isBoardCleared() {
        for(Field field: fields) {
            if(field.isShip() && field.isActive()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForShipsHit() {
        int coordinateX = 0, coordinateY = 0;
        for(Field field: fields) {
            if(field.isShip() && !field.isActive()) {
                if(coordinateX - 1 >= 0) {
                    if(fields.get(coordinateX - 1 + (coordinateY * 10)).isShip() && fields.get(coordinateX - 1 + (coordinateY * 10)).isActive()) {
                        return true;
                    }
                }

                if(coordinateX + 1 <= 9) {
                    if(fields.get(coordinateX + 1 + (coordinateY * 10)).isShip() && fields.get(coordinateX + 1 + (coordinateY * 10)).isActive()) {
                        return true;
                    }
                }

                if(coordinateY - 1 >= 0) {
                    if(fields.get(coordinateX + ((coordinateY - 1) * 10)).isShip() && fields.get(coordinateX + ((coordinateY - 1) * 10)).isActive()) {
                        return true;
                    }
                }

                if(coordinateY + 1 <= 9) {
                    if(fields.get(coordinateX + ((coordinateY + 1) * 10)).isShip() && fields.get(coordinateX + ((coordinateY + 1) * 10)).isActive()) {
                        return true;
                    }
                }
            }
            coordinateX++;
            if(coordinateX > 9) {
                coordinateX = 0;
                coordinateY++;
            }
        }
        return false;
    }

    public Board getBoard() {
        return this;
    }

    public Field get(int i) {
        return fields.get(i);
    }
}
