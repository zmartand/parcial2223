import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener configuración de barcos para el Usuario 1
        System.out.println("Configuración de barcos para el Usuario 1:");
        ArrayList<Ship> user1Ships = getUserShips(scanner);

        // Obtener configuración de barcos para el Usuario 2
        System.out.println("Configuración de barcos para el Usuario 2:");
        ArrayList<Ship> user2Ships = getUserShips(scanner);

        // Crear usuarios del juego
        User user1 = new User(user1Ships);
        User user2 = new User(user2Ships);

        // Comenzar el juego
        Random random = new Random();
        while (user1.isAlive() && user2.isAlive()) {
            // Ataque del Usuario 1 al Usuario 2
            Point shotPoint1 = getRandomShotPoint(random);
            user1.attack(shotPoint1, user2);

            // Ataque del Usuario 2 al Usuario 1
            Point shotPoint2 = getRandomShotPoint(random);
            user2.attack(shotPoint2, user1);
        }

        // Mostrar el ganador
        if (user1.isAlive() && !user2.isAlive()) {
            // Mostrar el ganador
            if (user1.isAlive() && !user2.isAlive()) {
                System.out.println("¡El Usuario 1 ha ganado!");
            } else if (!user1.isAlive() && user2.isAlive()) {
                System.out.println("¡El Usuario 2 ha ganado!");
            } else {
                System.out.println("¡Empate!");
            }
        }
    }

        private static ArrayList<Ship> getUserShips(Scanner scanner) {
            ArrayList<Ship> ships = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                System.out.println("Introduzca el tipo de barco (Battleship, Frigate, Canoe), punto de inicio y punto final (x1 y1 x2 y2):");
                String shipType = scanner.next();
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                Point startPoint = new Point(x1, y1);
                Point endPoint = new Point(x2, y2);

                Ship ship;
                switch (shipType) {
                    case "Battleship":
                        ship = new Battleship(startPoint, endPoint);
                        break;
                    case "Frigate":
                        ship = new Frigate(startPoint, endPoint);
                        break;
                    case "Canoe":
                        ship = new Canoe(startPoint, endPoint);
                        break;
                    default:
                        System.out.println("Tipo de barco no válido. Intente de nuevo.");
                        i--;
                        continue;
                }
                ships.add(ship);
            }
            return ships;

        }

        private static Point getRandomShotPoint(Random random) {
            int x = random.nextInt(10); // Asume un tablero de 10x10
            int y = random.nextInt(10);
            return new Point(x, y);
        }
    }

// Asegúrese de que las clases Point, Ship, Battleship, Frigate, Canoe y User estén implementadas antes de ejecutar este código.

