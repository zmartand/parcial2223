import java.util.HashMap;
import java.util.LinkedList;

    public class ShipData {
        private String name;
        private String type;
        private int number;
        private int level;

        public ShipData(String name, String type, int number, int level) {
            this.name = name;
            this.type = type;
            this.number = number;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getNumber() {
            return number;
        }

        public int getLevel() {
            return level;
        }

        HashMap<String, LinkedList<ShipData>> tableByType = new HashMap<>();
        HashMap<Integer, ShipData> tableByNumber = new HashMap<>(15);
        HashMap<String, ShipData> tableByName = new HashMap<>();

        public void addShip(ShipData ship) {
            // Agregar a la tabla por tipo
            LinkedList<ShipData> shipsByType = tableByType.get(ship.getType());
            if (shipsByType == null) {
                shipsByType = new LinkedList<>();
                tableByType.put(ship.getType(), shipsByType);
            }
            shipsByType.add(ship);

            // Agregar a la tabla por número
            tableByNumber.put(ship.getNumber(), ship);

            // Agregar a la tabla por nombre
            tableByName.put(ship.getName(), ship);
        }
        /*Apartado a) En la primera tabla hash la función hash debe ser sobre el tipo de barco, en la segunda tabla la
    función hash deberá utilizar el número del barco como clave, mientras que en la tercera el campo
    clave de la función hash será por el nombre del barco.*/


    /*Apartado b) Para manejar colisiones en la primera tabla, estamos usando LinkedList<ShipData> como valor.
    El tamaño de la primera tabla es dinámico porque está utilizando un HashMap en Java*/
    /*Apartado c) El tamaño de las segundas tablas está establecido en 15.
    En este caso, estamos utilizando un HashMap en Java que maneja automáticamente el tamaño y las colisiones.*/
    }