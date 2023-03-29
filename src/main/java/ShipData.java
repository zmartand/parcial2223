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
    /*Apartado a) En la primera tabla hash la función hash debe ser sobre el tipo de barco, en la segunda tabla la
    función hash deberá utilizar el número del barco como clave, mientras que en la tercera el campo
    clave de la función hash será por el nombre del barco.*/
    HashMap<String, LinkedList<ShipData>> tableByType = new HashMap<>();
    HashMap<Integer, ShipData> tableByNumber = new HashMap<>(15);
    HashMap<String, ShipData> tableByName = new HashMap<>();
    /*Para manejar colisiones en la primera tabla, estamos usando LinkedList<ShipData> como valor.
    El tamaño de la primera tabla es dinámico porque está utilizando un HashMap en Java*/



}