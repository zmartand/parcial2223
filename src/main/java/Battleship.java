import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Battleship extends Ship {
    private static final int SIZE = 5;
    private boolean[] hitPositions;

    public Battleship(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
        if (getSize() != SIZE) {
            throw new IllegalArgumentException("El tamaño del acorazado debe ser 5.");
        }

    }
    @Override
    protected java.util.List<Point> getCoordinates() {
        List<Point> coordinates = new ArrayList<>();
        return  coordinates;
    }


}


