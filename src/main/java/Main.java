import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static ShipData storage = new ShipData("", "", 0, 0);
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
            System.out.println("¡El Usuario 1 ha ganado!");
        } else if (!user1.isAlive() && user2.isAlive()) {
            System.out.println("¡El Usuario 2 ha ganado!");
        } else {
            System.out.println("¡Empate!");
        }
    }
    private static ArrayList<Ship> getUserShips(Scanner scanner) {
        ArrayList<Ship> ships = new ArrayList<>();
        int shipCounter = 1;

        System.out.println("Tienes un máximo de 3 barcos en total, uno de cada tipo:");
        System.out.println("Battleship: 5 casillas, Frigate: 3 casillas, Canoe: 1 casilla");
        System.out.println("Ingresa las coordenadas de inicio y fin para cada barco o escribe 'no' si no deseas ese tipo de barco.");

        for (String shipType : new String[]{"Battleship", "Frigate", "Canoe"}) {
            System.out.println("Punto inicial y punto final del " + shipType + " en formato x1 y1 x2 y2 ej(3 2 2 6), o 'no' si no deseas este tipo de barco:");

            String input = scanner.next();
            if (!input.equalsIgnoreCase("no")) {
                int x1 = Integer.parseInt(input);
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                Point startPoint = new Point(x1, y1);
                Point endPoint = new Point(x2, y2);
                Ship ship;
                int level;

                switch (shipType) {
                    case "Battleship":
                        ship = new Battleship(startPoint, endPoint);
                        level = 5;
                        break;
                    case "Frigate":
                        ship = new Frigate(startPoint, endPoint);
                        level = 3;
                        break;
                    case "Canoe":
                        ship = new Canoe(startPoint, endPoint);
                        level = 1;
                        break;
                    default:
                        System.out.println("Tipo de barco no válido. Intente de nuevo.");
                        continue;
                }

                ships.add(ship);
                String shipName = "Ship" + shipCounter;
                storage.addShip(new ShipData(shipName, shipType, shipCounter, level));
                shipCounter++;
            }
        }
        return ships;
    }
    private static Point getRandomShotPoint(Random random) {
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        return new Point(x, y);
    }
}