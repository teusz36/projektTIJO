package ships;

public class Field {
    private boolean ship;
    private boolean active;

    public Field() {
        ship = false;
        active = true;
    }

    public void ship(boolean shipBoolean) {
        ship = shipBoolean;
    }

    public boolean shot() {
        if(ship) {
            active = false;
        }
        return ship;
    }

    public boolean isShip() {
        return ship;
    }

    public boolean isActive() {
        return active;
    }
}
