import java.util.HashSet;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();

        // Agregar todos los números al conjunto
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSequence = 0;

        // Verificar las secuencias
        for (int num : numSet) {
            // Solo empezar a contar si num-1 no está en el conjunto (inicio de secuencia)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;

                // Contamos la secuencia consecutiva
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                }

                // Actualizamos la longitud máxima
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        int[] nums1 = { 100, 4, 200, 1, 3, 2 };
        int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

        System.out.println(longestConsecutive(nums1)); // Output: 4
        System.out.println(longestConsecutive(nums2)); // Output: 9
    }
}
