import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        while (user1.isAlive() && user2.isAlive()) {
            // Ataque del Usuario 1 al Usuario 2
            System.out.println("Turno del Usuario 1:");
            Point shotPoint1 = getUserShotPoint(scanner);
            boolean sunk1 = user1.attack(shotPoint1, user2);
            if (sunk1) {
                System.out.println("¡El Usuario 1 ha hundido un barco del Usuario 2!");
            } else {
                System.out.println("El Usuario 1 ha fallado.");
            }

            // Comprobar si el Usuario 2 sigue en juego
            if (!user2.isAlive()) {
                break;
            }

            // Ataque del Usuario 2 al Usuario 1
            System.out.println("Turno del Usuario 2:");
            Point shotPoint2 = getUserShotPoint(scanner);
            boolean sunk2 = user2.attack(shotPoint2, user1);
            if (sunk2) {
                System.out.println("¡El Usuario 2 ha hundido un barco del Usuario 1!");
            } else {
                System.out.println("El Usuario 2 ha fallado.");
            }
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

    private static Point getUserShotPoint(Scanner scanner) {
        System.out.println("Ingrese las coordenadas de ataque en formato x y ej(3 2):");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Point(x, y);
    }
    private static ArrayList<Ship> getUserShips(Scanner scanner) {
        ArrayList<Ship> ships = new ArrayList<>();
        int shipCounter = 1;

        System.out.println("Tienes un máximo de 3 barcos en total, uno de cada tipo:");
        System.out.println("Battleship: 5 casillas, Frigate: 3 casillas, Canoe: 1 casilla");
        System.out.println("Ingresa las coordenadas de inicio y fin para cada barco o escribe 'no' si no deseas ese tipo de barco.");

        for (String shipType : new String[]{"Battleship", "Frigate", "Canoe"}) {
            if (shipType.equals("Canoe")) {
                System.out.println("Punto de inicio del " + shipType + " en formato x y ej(3 2), o 'no' si no deseas este tipo de barco:");
            } else {
                System.out.println("Punto inicial y punto final del " + shipType + " en formato x1 y1 x2 y2 ej(3 2 2 6), o 'no' si no deseas este tipo de barco:");
            }
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("no")) {
                String[] inputs = input.split(" ");
                int x1 = Integer.parseInt(inputs[0]);
                int y1 = Integer.parseInt(inputs[1]);
                Point startPoint = new Point(x1, y1);
                Ship ship;

                if (shipType.equals("Canoe")) {
                    ship = new Canoe(startPoint);
                } else {
                    int x2 = Integer.parseInt(inputs[2]);
                    int y2 = Integer.parseInt(inputs[3]);
                    Point endPoint = new Point(x2, y2);

                    switch (shipType) {
                        case "Battleship":
                            ship = new Battleship(startPoint, endPoint);
                            break;
                        case "Frigate":
                            ship = new Frigate(startPoint, endPoint);
                            break;
                        default:
                            System.out.println("Tipo de barco no válido. Intente de nuevo.");
                            continue;
                    }
                }

                ships.add(ship);
                shipCounter++;
            }
        }
        return ships;
    }
}
