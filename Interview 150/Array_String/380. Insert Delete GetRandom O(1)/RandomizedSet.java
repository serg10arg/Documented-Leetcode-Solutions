import java.util.*;

class RandomizedSet {
    private List<Integer> list; // Almacena los elementos
    private Map<Integer, Integer> map; // Almacena el valor y su índice en la lista
    private Random random; // Para generar índices aleatorios

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // El valor ya existe
        }
        list.add(val);
        map.put(val, list.size() - 1); // Almacena el índice del valor
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // El valor no existe
        }
        int index = map.get(val); // Índice del valor
        int lastElement = list.get(list.size() - 1); // Último elemento de la lista

        // Intercambia el elemento a eliminar con el último
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Elimina el último elemento
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size()); // Índice aleatorio
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        // Entrada
        String[] operations = { "RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert",
                "getRandom" };
        int[][] arguments = { {}, { 1 }, { 2 }, { 2 }, {}, { 1 }, { 2 }, {} };

        // Salida
        List<Object> output = new ArrayList<>();
        RandomizedSet randomizedSet = null;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "RandomizedSet":
                    randomizedSet = new RandomizedSet();
                    output.add(null);
                    break;
                case "insert":
                    output.add(randomizedSet.insert(arguments[i][0]));
                    break;
                case "remove":
                    output.add(randomizedSet.remove(arguments[i][0]));
                    break;
                case "getRandom":
                    output.add(randomizedSet.getRandom());
                    break;
            }
        }

        System.out.println(output); // Imprime la salida
    }
}