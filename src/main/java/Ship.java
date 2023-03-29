import java.awt.*;
public class Ship {
    private Point puntoInicial;
    private Point puntoFinal;
    private double tamanio;
    private int golpes;
    private CardinalPoints direccion;

    public Ship(Point puntoInicial, Point puntoFinal) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.direccion = calculateDirection(puntoInicial, puntoFinal);
        this.tamanio = calcularTamanio(puntoInicial, puntoFinal);
        this.golpes = 0;
    }

    public Point getPuntoInicial() {
        return puntoInicial;
    }

    public Point getPuntoFinal() {
        return puntoFinal;
    }

    public double getTamanio() {
        return tamanio;
    }

    public CardinalPoints getDireccion() {
        return direccion;
    }

    public boolean estaHundido() {
        return golpes == tamanio;
    }

    public void getShot(Point shotPoint) {
        if (isPointInsideShip(shotPoint)) {
            golpes++;
        }
    }

    private CardinalPoints calculateDirection(Point puntoInicial, Point puntoFinal) {
        if (puntoInicial.getX() == puntoFinal.getX()) {
            return (puntoInicial.getY() < puntoFinal.getY()) ? CardinalPoints.NORTH : CardinalPoints.SOUTH;
        } else {
            return (puntoInicial.getX() < puntoFinal.getX()) ? CardinalPoints.EAST : CardinalPoints.WEST;
        }
    }

    private double calcularTamanio(Point puntoInicial, Point puntoFinal) {
        return Math.max(Math.abs(puntoInicial.getX() - puntoFinal.getX()), Math.abs(puntoInicial.getY() - puntoFinal.getY())) + 1;
    }

    private boolean isPointInsideShip(Point shotPoint) {
        double x = shotPoint.getX();
        double y = shotPoint.getY();
        double startX = puntoInicial.getX();
        double startY = puntoInicial.getY();
        double endX = puntoFinal.getX();
        double endY = puntoFinal.getY();
        return (x >= startX && x <= endX && y >= startY && y <= endY);
    }
}




