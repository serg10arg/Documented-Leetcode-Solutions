public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, sum = 0;
        int minLength = Integer.MAX_VALUE; // Longitud mínima de la ventana

        for (int end = 0; end < n; end++) {
            sum += nums[end]; // Expandimos la ventana
            while (sum >= target) { // Intentamos minimizar la ventana
                minLength = Math.min(minLength, end - start + 1); // +1 porque
                sum -= nums[start]; // Reducimos la ventana desde el inicio
                start++; //
            }
        }
        // Si no encontramos una ventana válida, devolvemos 0
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum solver = new MinimumSizeSubarraySum();

        // Ejemplo 1
        System.out.println(solver.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 })); // Output: 2

        // Ejemplo 2
        System.out.println(solver.minSubArrayLen(4, new int[] { 1, 4, 4 })); // Output: 1

        // Ejemplo 3
        System.out.println(solver.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 })); // Output: 0
    }
}
