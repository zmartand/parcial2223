import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Canoe extends Ship {
    Scanner scanner = new Scanner(System.in);
    private static final int SIZE = 1;

    public Canoe(Point startPoint) {
        super(startPoint, startPoint);
        if (getSize() != SIZE) {
            while (true) {
                System.out.println("El tamaño de la canoa debe ser 1. Por favor, ingrese nuevas coordenadas para el barco:");
                startPoint = new Point(scanner.nextInt(), scanner.nextInt());
                if (isValidSize(startPoint, startPoint)) {
                    break;
                }
            }
        }
    }

    @Override
    protected java.util.List<Point> getCoordinates() {
        List<Point> coordinates = new ArrayList<>();
        // Agrega las coordenadas del barco a la lista 'coordinates'
        return  coordinates;
    }
    @Override
    public boolean isValidSize(Point startPoint, Point endPoint) {
        int size = Math.max(Math.abs(endPoint.x - startPoint.x), Math.abs(endPoint.y - startPoint.y)) + 1;
        return size == SIZE;
    }
}

