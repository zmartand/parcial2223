import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canoe extends Ship {
    private static final int SIZE = 1;

    public Canoe(Point startPoint) {
        super(startPoint, startPoint);
        if (getSize() != SIZE) {
            throw new IllegalArgumentException("El tamaño de la canoa debe ser 1.");
        }
    }
    @Override
    protected java.util.List<Point> getCoordinates() {
        List<Point> coordinates = new ArrayList<>();
        coordinates.add(startPoint); // Agrega el punto de inicio a la lista 'coordinates'
        return coordinates;
    }
}

