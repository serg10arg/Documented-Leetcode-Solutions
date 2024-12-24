import java.util.Arrays;

public class RemoveDuplicates {

    // Método para eliminar duplicados de un arreglo ordenado
    public int removeDuplicates(int[] nums) {
        // Caso base: Si el arreglo tiene 1 o ningún elemento, no hay duplicados.
        if (nums.length <= 1) {
            return nums.length;
        }

        // Puntero para escribir elementos únicos.
        int write_index = 1;

        // Recorremos el arreglo desde el segundo elemento.
        for (int read_index = 1; read_index < nums.length; read_index++) {
            // Si encontramos un número diferente al anterior, es único.
            if (nums[read_index] != nums[read_index - 1]) {
                nums[write_index] = nums[read_index];
                write_index++; // Avanzamos el puntero de escritura.
            }
        }

        // `write_index` es el número de elementos únicos (k).
        return write_index;
    }

    // Clase principal para realizar pruebas
    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();

        // Caso de prueba 1
        int[] nums1 = { 1, 1, 2 };
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Unique count: " + k1); // Esperado: 2
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums1, k1))); // Esperado: [1, 2]

        // Caso de prueba 2
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Unique count: " + k2); // Esperado: 5
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums2, k2))); // Esperado: [0, 1, 2, 3, 4]
    }
}
