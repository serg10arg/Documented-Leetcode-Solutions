import java.util.Arrays;

public class MajorityElement {
    // Método principal para encontrar el elemento mayoritario
    public int majorityElement(int[] nums) {
        // Etapa 1: Encontrar un candidato para el elemento mayoritario
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num; // Cambiamos de candidato
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Etapa 2: Retornar el candidato
        return candidate;
    }

    // Método de prueba
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        // Caso 1
        int[] nums1 = { 3, 2, 3 };
        int result1 = solution.majorityElement(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);

        // Caso 2
        int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
        int result2 = solution.majorityElement(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);
    }
}
