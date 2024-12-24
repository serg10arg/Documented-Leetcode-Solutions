public class RotateArray {
    // Método principal para rotar el arreglo
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Normalizar k para manejar casos en que k > n
        reverse(nums, 0, n - 1); // Revertir todo el arreglo
        reverse(nums, 0, k - 1); // Revertir los primeros k elementos
        reverse(nums, k, n - 1); // Revertir los elementos restantes
    }

    // Método auxiliar para revertir una sección del arreglo
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Método main para probar el programa
    public static void main(String[] args) {
        // Caso de prueba 1
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        int k1 = 3;
        rotate(nums1, k1);
        System.out.print("Output: ");
        printArray(nums1);

        // Caso de prueba 2
        int[] nums2 = { -1, -100, 3, 99 };
        int k2 = 2;
        rotate(nums2, k2);
        System.out.print("Output: ");
        printArray(nums2);
    }

    // Método para imprimir un arreglo
    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}