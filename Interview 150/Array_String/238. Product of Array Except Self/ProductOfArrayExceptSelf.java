import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Paso 1: Calcular productos acumulativos de izquierda a derecha.
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        // Paso 2: Calcular productos acumulativos de derecha a izquierda.
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // Ejemplo 1
        int[] nums1 = { 1, 2, 3, 4 };
        int[] result1 = productExceptSelf(nums1);
        System.out.println(Arrays.toString(result1)); // [24, 12, 8, 6]

        // Ejemplo 2
        int[] nums2 = { -1, 1, 0, -3, 3 };
        int[] result2 = productExceptSelf(nums2);
        System.out.println(Arrays.toString(result2)); // [0, 0, 9, 0, 0]
    }
}
