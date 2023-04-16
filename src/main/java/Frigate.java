import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frigate extends Ship {
    private static final int SIZE = 3;

    public Frigate(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
        if (getSize() != SIZE) {
            throw new IllegalArgumentException("El tamaño de la fragata debe ser 3.");
        }
    }
    @Override
    protected java.util.List<Point> getCoordinates() {
        List<Point> coordinates = new ArrayList<>();
        return  coordinates;
    }
}

