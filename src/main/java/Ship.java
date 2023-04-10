import java.awt.*;
import java.util.List;
public abstract class Ship {
    protected Point startPoint;
    protected Point endPoint;
    protected double size;
    protected int hits;
    protected CardinalPoints direction;
    private String name;

    public Ship(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.direction = calculateDirection(startPoint, endPoint);
        this.size = calculateSize(startPoint, endPoint);
        this.hits = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public void addToGraph(Graph graph) {
        List<Point> coordinates = getCoordinates();
        for (Point coordinate : coordinates) {
            String node = pointToNode(coordinate);
            graph.addNode(node);
        }

        for (int i = 0; i < coordinates.size() - 1; i++) {
            String nodeA = pointToNode(coordinates.get(i));
            String nodeB = pointToNode(coordinates.get(i + 1));
            graph.addEdge(nodeA, nodeB);
        }
    }
    protected String pointToNode(Point point) {
        return "(" + point.x + ", " + point.y + ")";
    }
    protected abstract List<Point> getCoordinates();
}




