import java.util.HashMap;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Mapa para almacenar el valor y su índice más reciente
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterar sobre el array
        for (int i = 0; i < nums.length; i++) {
            // Si el número ya está en el mapa
            if (map.containsKey(nums[i])) {
                // Verificar la distancia entre índices
                if (i - map.get(nums[i]) <= k) {
                    return true; // Encontramos un par válido
                }
            }
            // Actualizar el índice del número en el mapa
            map.put(nums[i], i);
        }

        // Si no encontramos pares válidos
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3)); // true
        System.out.println(containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1)); // true
        System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2)); // false
    }

}
