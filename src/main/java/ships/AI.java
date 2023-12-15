package ships;

import java.util.Random;

public class AI {
    public static int[] shot(Board board) {
        if(board.checkForShipsHit()) {
            int coordinateX = 0, coordinateY = 0;
            for(Field field: board.fields) {
                if(field.isShip() && !field.isActive()) {
                    if(coordinateX - 1 >= 0) {
                        if(board.fields.get(coordinateX - 1 + (coordinateY * 10)).isShip() && board.fields.get(coordinateX - 1 + (coordinateY * 10)).isActive()) {
                            int[] coordinates;
                            do {
                                coordinates = getFieldOnRandomDirection(coordinateX, coordinateY);
                            } while (!board.get(coordinates[0] + coordinates[1] * 10).isActive());
                            return coordinates;
                        }
                    }

                    if(coordinateX + 1 <= 9) {
                        if(board.fields.get(coordinateX + 1 + (coordinateY * 10)).isShip() && board.fields.get(coordinateX + 1 + (coordinateY * 10)).isActive()) {
                            int[] coordinates;
                            do {
                                coordinates = getFieldOnRandomDirection(coordinateX, coordinateY);
                            } while (!board.get(coordinates[0] + coordinates[1] * 10).isActive());
                            return coordinates;
                        }
                    }

                    if(coordinateY - 1 >= 0) {
                        if(board.fields.get(coordinateX + ((coordinateY - 1) * 10)).isShip() && board.fields.get(coordinateX + ((coordinateY - 1) * 10)).isActive()) {
                            int[] coordinates;
                            do {
                                coordinates = getFieldOnRandomDirection(coordinateX, coordinateY);
                            } while (!board.get(coordinates[0] + coordinates[1] * 10).isActive());
                            return coordinates;
                        }
                    }

                    if(coordinateY + 1 <= 9) {
                        if(board.fields.get(coordinateX + ((coordinateY + 1) * 10)).isShip() && board.fields.get(coordinateX + ((coordinateY + 1) * 10)).isActive()) {
                            int[] coordinates;
                            do {
                                coordinates = getFieldOnRandomDirection(coordinateX, coordinateY);
                            } while (!board.get(coordinates[0] + coordinates[1] * 10).isActive());
                            return coordinates;
                        }
                    }
                }
                coordinateX++;
                if(coordinateX > 9) {
                    coordinateX = 0;
                    coordinateY++;
                }
            }
            return new int[] {0, 0};
        } else {
            Random rand = new Random();
            int[] coordinates;
            do {
                coordinates = new int[]{rand.nextInt(10), rand.nextInt(10)};
            } while (!board.fields.get(coordinates[0] + coordinates[1] * 10).isActive());
            return coordinates;
        }
    }

    private static int[] getFieldOnRandomDirection(int i, int j){
        int[] coordinates;
        Random rand = new Random();
        int AIDirection = rand.nextInt(4);
        switch(AIDirection){
            case 0: //góra
                coordinates = new int[]{i, j + 1};
                if(j + 1 <= 9){
                    return coordinates;
                } else {
                    return getFieldOnRandomDirection(i, j);
                }
            case 1: //prawo
                coordinates = new int[]{i + 1, j};
                if(i + 1 <= 9){
                    return coordinates;
                } else {
                    return getFieldOnRandomDirection(i, j);
                }
            case 2: //dół
                coordinates = new int[]{i, j - 1};
                if(j - 1 >= 0){
                    return coordinates;
                } else {
                    return getFieldOnRandomDirection(i, j);
                }
            case 3: //lewo
                coordinates = new int[]{i - 1, j};
                if(i - 1 >= 0){
                    return coordinates;
                } else {
                    return getFieldOnRandomDirection(i, j);
                }
        }
        return new int[]{0, 0};
    }
}
