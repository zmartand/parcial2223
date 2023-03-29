import java.awt.*;

public class Canoe extends Ship {
    private static final int SIZE = 1;

    public Canoe(Point startPoint) {
        super(startPoint, startPoint);
        if (getSize() != SIZE) {
            throw new IllegalArgumentException("El tamaño de la canoa debe ser 1.");
        }
    }
}

