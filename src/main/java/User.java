import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private boolean alive;
    private List<Ship> ships;

    public User(List<Ship> ships) {
        if (ships == null || ships.size() < 1) {
            throw new IllegalArgumentException("Debe haber al menos un barco.");
        }
        this.ships = new ArrayList<>(ships);
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        this.alive = false;
    }

    public void attack(Point shotPoint, User user) {
        user.getShot(shotPoint);
    }

    public void getShot(Point shotPoint) {
        for (Ship ship : ships) {
            ship.getShot(shotPoint);
            if (ship.isSunk()) {
                ships.remove(ship);
                break;
            }
        }
        if (ships.isEmpty()) {
            die();
        }
    }
}

