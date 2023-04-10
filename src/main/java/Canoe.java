import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canoe extends Ship {
    private static final int SIZE = 1;

    public Canoe(Point startPoint, Point endPoint) {
        super(startPoint, startPoint);
        if (getSize() != SIZE) {
            throw new IllegalArgumentException("El tamaño de la canoa debe ser 1.");
        }
    }
    @Override
    protected java.util.List<Point> getCoordinates() {
        List<Point> coordinates = new ArrayList<>();
        // Agrega las coordenadas del barco a la lista 'coordinates'
        return  coordinates;
    }
}

