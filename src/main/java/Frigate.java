import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frigate extends Ship {
    Scanner scanner = new Scanner(System.in);
    private static final int SIZE = 3;

    public Frigate(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
        if (getSize() != SIZE) {
            while (true) {
                System.out.println("El tamaño de la fragata debe ser 3. Por favor, ingrese nuevas coordenadas para el barco:");
                startPoint = new Point(scanner.nextInt(), scanner.nextInt());
                endPoint = new Point(scanner.nextInt(), scanner.nextInt());
                if (isValidSize(startPoint, endPoint)) {
                    break;
                }
            }
        }
    }

    @Override
    protected java.util.List<Point> getCoordinates() {
        List<Point> coordinates = new ArrayList<>();
        return  coordinates;
    }
    @Override
    public boolean isValidSize(Point startPoint, Point endPoint) {
        int size = Math.max(Math.abs(endPoint.x - startPoint.x), Math.abs(endPoint.y - startPoint.y)) + 1;
        return size == SIZE;
    }
}

