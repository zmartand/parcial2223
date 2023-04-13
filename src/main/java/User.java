import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private boolean alive;
    private List<Ship> ships;
    private Graph shipGraph;

    public User(List<Ship> ships) {
        if (ships == null || ships.size() < 1) {
            throw new IllegalArgumentException("Debe haber al menos un barco.");
        }
        this.ships = new ArrayList<>(ships);
        this.alive = true;
        this.shipGraph = new Graph();
        for (Ship ship : ships) {
            ship.addToGraph(shipGraph);
        }
    }

    public boolean isAlive() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return true;
            }
        }
        return false;
    }

    public void die() {
        this.alive = false;
    }

    public boolean attack(int x, int y) {
        Point shotPoint = new Point(x, y);
        for (Ship ship : ships) {
            if (ship.isPointInsideShip(shotPoint)) {
                ship.registerHit();
                if (ship.isSunk()) {
                    System.out.println("¡Has hundido un barco!");
                } else {
                    System.out.println("¡Le has dado, pero el barco aún no se ha hundido!");
                }
                return true;
            }
        }
        return false;
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

    public void printShipGraph() {
        System.out.println("Grafo de barcos:");
        shipGraph.printGraph();
    }
}

