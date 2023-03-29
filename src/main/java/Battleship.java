import java.awt.*;
public class Battleship extends Ship {
    private static final int SIZE = 5;
    private boolean[] hitPositions;

    public Battleship(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
        if (getSize() != SIZE) {
            throw new IllegalArgumentException("El tamaño del acorazado debe ser 5.");
        }
        hitPositions = new boolean[SIZE];
    }

    @Override
    public void getShot(Point shotPoint) {
        if (isPointInsideShip(shotPoint)) {
            double index = calculateHitIndex(shotPoint);
            hitPositions[(int) index] = true;
        }
    }

    @Override
    public boolean isSunk() {
        for (boolean hit : hitPositions) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }

    private double calculateHitIndex(Point shotPoint) {
        if (getDirection() == CardinalPoints.NORTH || getDirection() == CardinalPoints.SOUTH) {
            return Math.abs(shotPoint.getY() - getStartPoint().getY());
        } else {
            return Math.abs(shotPoint.getX() - getStartPoint().getX());
        }
    }
}


