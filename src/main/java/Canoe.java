import java.awt.*;

public class Canoe extends Ship {
    private static final int SIZE = 1;

    public Canoe(Point startPoint, Point endPoint) {
        super(startPoint, startPoint);
        if (getSize() != SIZE) {
            throw new IllegalArgumentException("El tamaño de la canoa debe ser 1.");
        }
    }
}

