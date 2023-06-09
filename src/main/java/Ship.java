import java.awt.*;
import java.util.List;
public abstract class Ship {
    protected Point startPoint;
    protected Point endPoint;
    protected int size;
    protected int hits;
    protected CardinalPoints direction;
    private String name;

    public Ship(Point startPoint, Point endPoint) {

        if (!isStraight(startPoint, endPoint))
            throw new IllegalArgumentException("Las coordenadas indicadas no forman una linea recta.");

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.size = calculateSize() + 1;
        this.hits = 0;
        System.out.println("Tamaño del barco: " + size);
    }

    private boolean isStraight(Point startPoint, Point endPoint){
        return startPoint.getX() == endPoint.getX() || startPoint.getY() == endPoint.getY();
    }

    /**
     * Calcula el tamaño del barco dada su posición de inicio y fin.
     * */
    private int calculateSize(){
        int size = (int) (startPoint.getX() - endPoint.getX());
        if (size != 0)
            return Math.abs(size);
        return Math.abs((int)(startPoint.getY() - endPoint.getY()));
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
        return hits == getSize();
    }




    public void getShot(Point shotPoint) {
        if (isPointInsideShip(shotPoint)) {
            hits++;
        }
    }
    public void registerHit() {
        hits++;
    }
    /*private CardinalPoints calculateDirection(Point startPoint, Point endPoint) {
        if (startPoint.getX() == endPoint.getX()) {
            return (startPoint.getY() < endPoint.getY()) ? CardinalPoints.NORTH : CardinalPoints.SOUTH;
        } else {
            return (startPoint.getX() < endPoint.getX()) ? CardinalPoints.EAST : CardinalPoints.WEST;
        }
    }

    private double calculateSize(Point startPoint, Point endPoint) {
        return Math.max(Math.abs(startPoint.getX() - endPoint.getX()), Math.abs(startPoint.getY() - endPoint.getY())) + 1;
    }*/

    public boolean isPointInsideShip(Point shotPoint) {
        int shotX = shotPoint.x;
        int shotY = shotPoint.y;

        boolean withinX = (shotX >= startPoint.x && shotX <= endPoint.x) || (shotX >= endPoint.x && shotX <= startPoint.x);
        boolean withinY = (shotY >= startPoint.y && shotY <= endPoint.y) || (shotY >= endPoint.y && shotY <= startPoint.y);

        return withinX && withinY;
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
    public abstract boolean isValidSize(Point startPoint, Point endPoint);

}