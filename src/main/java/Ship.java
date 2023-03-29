import java.awt.*;
public abstract class Ship {
    protected Point startPoint;
    protected Point endPoint;
    protected double size;
    protected int hits;
    protected CardinalPoints direction;

    public Ship(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.direction = calculateDirection(startPoint, endPoint);
        this.size = calculateSize(startPoint, endPoint);
        this.hits = 0;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public double getSize() {
        return size;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public boolean isSunk() {
        return hits == size;
    }

    public void getShot(Point shotPoint) {
        if (isPointInsideShip(shotPoint)) {
            hits++;
        }
    }

    private CardinalPoints calculateDirection(Point startPoint, Point endPoint) {
        if (startPoint.getX() == endPoint.getX()) {
            return (startPoint.getY() < endPoint.getY()) ? CardinalPoints.NORTH : CardinalPoints.SOUTH;
        } else {
            return (startPoint.getX() < endPoint.getX()) ? CardinalPoints.EAST : CardinalPoints.WEST;
        }
    }

    private double calculateSize(Point startPoint, Point endPoint) {
        return Math.max(Math.abs(startPoint.getX() - endPoint.getX()), Math.abs(startPoint.getY() - endPoint.getY())) + 1;
    }

    protected boolean isPointInsideShip(Point shotPoint) {
        double x = shotPoint.getX();
        double y = shotPoint.getY();
        double startX = startPoint.getX();
        double startY = startPoint.getY();
        double endX = endPoint.getX();
        double endY = endPoint.getY();
        return (x >= startX && x <= endX && y >= startY && y <= endY);
    }
}




