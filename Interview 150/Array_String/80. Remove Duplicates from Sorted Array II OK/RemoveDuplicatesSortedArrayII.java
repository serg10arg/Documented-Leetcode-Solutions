import java.util.Arrays;

public class RemoveDuplicatesSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        // Si el array tiene menos de 3 elementos, ya cumple las condiciones
        if (nums.length <= 2)
            return nums.length;

        // Puntero lento para la posición de escritura
        int insert = 2;

        // Recorremos el array desde el tercer elemento
        for (int i = 2; i < nums.length; i++) {
            // Si el elemento actual es diferente del que está dos posiciones atrás
            // significa que no excede el límite de dos repeticiones
            if (nums[i] != nums[insert - 2]) {
                nums[insert] = nums[i];
                insert++;
            }
        }

        return insert; // Número de elementos válidos
    }

    public static void main(String[] args) {
        // Ejemplo 1
        int[] nums1 = { 1, 1, 1, 2, 2, 3 };
        int k1 = removeDuplicates(nums1);
        System.out.println("Output: " + k1);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums1, k1)));

        // Ejemplo 2
        int[] nums2 = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int k2 = removeDuplicates(nums2);
        System.out.println("Output: " + k2);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums2, k2)));

        // Caso límite vacío
        int[] nums3 = {};
        int k3 = removeDuplicates(nums3);
        System.out.println("Output: " + k3);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums3, k3)));

        // Caso límite con 2 elementos
        int[] nums4 = { 1, 1 };
        int k4 = removeDuplicates(nums4);
        System.out.println("Output: " + k4);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums4, k4)));
    }
}
