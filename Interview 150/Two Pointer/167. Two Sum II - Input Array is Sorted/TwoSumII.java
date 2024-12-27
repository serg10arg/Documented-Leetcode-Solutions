public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; // Puntero inicial
        int right = numbers.length - 1; // Puntero final

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Devolver 1-indexado
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++; // Mover puntero izquierdo
            } else {
                right--; // Mover puntero derecho
            }
        }

        // Nunca debería llegar aquí, ya que siempre hay una solución
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();

        // Ejemplo 1
        int[] numbers1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // Output: [1, 2]

        // Ejemplo 2
        int[] numbers2 = { 2, 3, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 3]

        // Ejemplo 3
        int[] numbers3 = { -1, 0 };
        int target3 = -1;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // Output: [1, 2]
    }
}
