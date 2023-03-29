import java.awt.*;

public class Ship {
    private Point inicio;
    private Point fin;
    private double tamanio;
    private int golpes;
    private boolean hundido;

    public Ship(Point inicio, Point fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.tamanio = Math.max(Math.abs(fin.getX() - inicio.getX()), Math.abs(fin.getY() - inicio.getY())) + 1;
        this.golpes = 0;
        this.hundido = false;
    }

    public Point getStart() {
        return inicio;
    }

    public void setStart(Point start) {
        this.inicio = start;
    }

    public Point getEnd() {
        return fin;
    }

    public void setEnd(Point end) {
        this.fin = end;
    }

    public double getSize() {
        return tamanio;
    }

    public int getHitCount() {
        return golpes;
    }

    public boolean isSunk() {
        return hundido;
    }

    public void getShot(Point shot_point) {
        if (isOnShip(shot_point)) {
            golpes++;
            if (golpes == tamanio) {
                hundido = true;
            }
        }
    }

    private boolean isOnShip(Point p) {
        if (p.getX() >= inicio.getX() && p.getX() <= fin.getX() && p.getY() >= inicio.getY() && p.getY() <= fin.getY()) {
            if (inicio.getX() == fin.getX()) {
                return true;
            } else {
                return false;
            }
        } else if (p.getX() >= inicio.getX() && p.getX() <= fin.getX() && p.getY() <= inicio.getY() && p.getY() >= fin.getY()) {
            if (inicio.getX() == fin.getX()) {
                return true;
            } else {
                return false;
            }
        } else if (p.getY() >= inicio.getY() && p.getY() <= fin.getY() && p.getX() <= inicio.getX() && p.getX() >= fin.getX()) {
            if (inicio.getY() == fin.getY()) {
                return true;
            } else {
                return false;
            }
        } else if (p.getY() >= inicio.getY() && p.getY() <= fin.getY() && p.getX() >= inicio.getX() && p.getX() <= fin.getX()) {
            if (inicio.getY() == fin.getY()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}


